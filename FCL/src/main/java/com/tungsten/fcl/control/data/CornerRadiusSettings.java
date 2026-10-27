package com.tungsten.fcl.control.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tungsten.fclcore.fakefx.beans.InvalidationListener;
import com.tungsten.fclcore.fakefx.beans.Observable;
import com.tungsten.fclcore.fakefx.beans.property.IntegerProperty;
import com.tungsten.fclcore.fakefx.beans.property.SimpleIntegerProperty;
import com.tungsten.fclcore.fakefx.beans.property.SimpleStringProperty;
import com.tungsten.fclcore.fakefx.beans.property.StringProperty;
import com.tungsten.fclcore.util.fakefx.ObservableHelper;

import java.util.function.IntSupplier;

/** Independent Normal/Pressed corner modes. Radii use the existing tenths-of-dp unit. */
public final class CornerRadiusSettings implements Observable {
    public static final String SIMPLE = "simple";
    public static final String ADVANCED = "advanced";
    public static final int TOP_LEFT = 0;
    public static final int TOP_RIGHT = 1;
    public static final int BOTTOM_RIGHT = 2;
    public static final int BOTTOM_LEFT = 3;

    private static final class State {
        final StringProperty mode = new SimpleStringProperty(SIMPLE);
        final IntegerProperty[] radii = new IntegerProperty[4];
        final IntSupplier simpleRadius;
        boolean initialized;

        State(IntSupplier simpleRadius) {
            this.simpleRadius = simpleRadius;
            for (int i = 0; i < 4; i++) radii[i] = new SimpleIntegerProperty(100);
        }
    }

    private final State normal;
    private final State pressed;
    private final ObservableHelper observableHelper = new ObservableHelper(this);

    public CornerRadiusSettings(IntSupplier normalRadius, IntSupplier pressedRadius) {
        normal = new State(normalRadius);
        pressed = new State(pressedRadius);
        for (State state : new State[]{normal, pressed}) {
            state.mode.addListener(observable -> observableHelper.invalidate());
            for (IntegerProperty radius : state.radii) {
                radius.addListener(observable -> {
                    state.initialized = true;
                    observableHelper.invalidate();
                });
            }
        }
    }

    private State state(boolean isPressed) {
        return isPressed ? pressed : normal;
    }

    public String getMode(boolean isPressed) {
        return ADVANCED.equals(state(isPressed).mode.get()) ? ADVANCED : SIMPLE;
    }

    public StringProperty modeProperty(boolean isPressed) {
        return state(isPressed).mode;
    }

    public void setMode(boolean isPressed, String mode) {
        State state = state(isPressed);
        if (ADVANCED.equals(mode) && !state.initialized) {
            int initial = clamp(state.simpleRadius.getAsInt());
            for (IntegerProperty radius : state.radii) radius.set(initial);
            state.initialized = true;
        }
        state.mode.set(ADVANCED.equals(mode) ? ADVANCED : SIMPLE);
    }

    public IntegerProperty radiusProperty(boolean isPressed, int corner) {
        return state(isPressed).radii[corner];
    }

    public int getRadius(boolean isPressed, int corner) {
        return state(isPressed).radii[corner].get();
    }

    public void setRadius(boolean isPressed, int corner, int value) {
        State state = state(isPressed);
        state.initialized = true;
        state.radii[corner].set(clamp(value));
    }

    public int getEffectiveRadius(boolean isPressed, int corner) {
        return ADVANCED.equals(getMode(isPressed)) ? clamp(getRadius(isPressed, corner))
                : Math.max(0, state(isPressed).simpleRadius.getAsInt());
    }

    private static int clamp(int value) {
        return Math.max(0, Math.min(500, value));
    }

    /** Android order: TL(x,y), TR(x,y), BR(x,y), BL(x,y); reused by every transition frame. */
    public void fillPixelRadii(float[] output, float fraction, float density) {
        if (output.length < 8) throw new IllegalArgumentException("Eight radius entries required");
        float t = Math.max(0f, Math.min(1f, fraction));
        for (int corner = 0; corner < 4; corner++) {
            int first = getEffectiveRadius(false, corner);
            int second = getEffectiveRadius(true, corner);
            float px = (first + (second - first) * t) * Math.max(0f, density) / 10f;
            output[corner * 2] = px;
            output[corner * 2 + 1] = px;
        }
    }

    public float[] getPixelRadii(boolean isPressed, float density) {
        float[] values = new float[8];
        fillPixelRadii(values, isPressed ? 1f : 0f, density);
        return values;
    }

    public void copyFrom(CornerRadiusSettings source) {
        if (source == this) return;
        copyState(normal, source.normal);
        copyState(pressed, source.pressed);
    }

    private static void copyState(State destination, State source) {
        for (int i = 0; i < 4; i++) destination.radii[i].set(source.radii[i].get());
        destination.initialized = source.initialized;
        destination.mode.set(source.mode.get());
    }

    public JsonObject toJson() {
        JsonObject obj = new JsonObject();
        obj.add("normal", serialize(normal));
        obj.add("pressed", serialize(pressed));
        return obj;
    }

    private static JsonObject serialize(State state) {
        JsonObject obj = new JsonObject();
        obj.addProperty("mode", ADVANCED.equals(state.mode.get()) ? ADVANCED : SIMPLE);
        if (state.initialized) {
            JsonArray radii = new JsonArray();
            for (IntegerProperty radius : state.radii) radii.add(clamp(radius.get()));
            obj.add("radii", radii);
        }
        return obj;
    }

    /** Missing or unknown new fields leave legacy styles in Simple mode. */
    public void readJson(JsonElement element) {
        if (element == null || !element.isJsonObject()) return;
        JsonObject obj = element.getAsJsonObject();
        readState(false, obj.get("normal"));
        readState(true, obj.get("pressed"));
    }

    private void readState(boolean isPressed, JsonElement element) {
        if (element == null || !element.isJsonObject()) return;
        JsonObject obj = element.getAsJsonObject();
        JsonElement radii = obj.get("radii");
        if (radii != null && radii.isJsonArray() && radii.getAsJsonArray().size() == 4) {
            JsonArray array = radii.getAsJsonArray();
            for (int i = 0; i < 4; i++) {
                JsonElement value = array.get(i);
                if (value.isJsonPrimitive() && value.getAsJsonPrimitive().isNumber()) {
                    setRadius(isPressed, i, value.getAsInt());
                } else {
                    setRadius(isPressed, i, state(isPressed).simpleRadius.getAsInt());
                }
            }
        }
        JsonElement mode = obj.get("mode");
        setMode(isPressed, mode != null && mode.isJsonPrimitive() ? mode.getAsString() : SIMPLE);
    }

    @Override
    public void addListener(InvalidationListener listener) {
        observableHelper.addListener(listener);
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        observableHelper.removeListener(listener);
    }
}
