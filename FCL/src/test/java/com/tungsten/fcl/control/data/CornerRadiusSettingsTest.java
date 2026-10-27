package com.tungsten.fcl.control.data;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

public class CornerRadiusSettingsTest {
    private final Gson gson = new Gson();

    @Test
    public void legacyStyleDefaultsToSimpleAndKeepsBothUniformRadii() {
        ControlButtonStyle style = gson.fromJson("{\"name\":\"Legacy\",\"cornerRadius\":270,\"cornerRadiusPressed\":80}", ControlButtonStyle.class);
        assertEquals(CornerRadiusSettings.SIMPLE, style.getCornerSettings().getMode(false));
        assertEquals(CornerRadiusSettings.SIMPLE, style.getCornerSettings().getMode(true));
        for (int corner = 0; corner < 4; corner++) {
            assertEquals(270, style.getCornerSettings().getEffectiveRadius(false, corner));
            assertEquals(80, style.getCornerSettings().getEffectiveRadius(true, corner));
        }
    }

    @Test
    public void firstAdvancedSelectionCopiesCurrentSimpleValueAndModesStayIndependent() {
        ControlButtonStyle style = new ControlButtonStyle("Corners");
        style.setCornerRadius(225);
        style.setCornerRadiusPressed(65);
        CornerRadiusSettings settings = style.getCornerSettings();
        settings.setMode(false, CornerRadiusSettings.ADVANCED);
        for (int i = 0; i < 4; i++) assertEquals(225, settings.getRadius(false, i));
        assertEquals(CornerRadiusSettings.SIMPLE, settings.getMode(true));
        settings.setMode(true, CornerRadiusSettings.ADVANCED);
        for (int i = 0; i < 4; i++) assertEquals(65, settings.getRadius(true, i));
    }

    @Test
    public void switchingToSimpleAndBackDoesNotEraseAdvancedCorners() {
        ControlButtonStyle style = new ControlButtonStyle("Retain");
        CornerRadiusSettings settings = style.getCornerSettings();
        settings.setMode(false, CornerRadiusSettings.ADVANCED);
        settings.setRadius(false, CornerRadiusSettings.TOP_LEFT, 10);
        settings.setRadius(false, CornerRadiusSettings.BOTTOM_RIGHT, 450);
        settings.setMode(false, CornerRadiusSettings.SIMPLE);
        style.setCornerRadius(200);
        assertEquals(200, settings.getEffectiveRadius(false, 0));
        settings.setMode(false, CornerRadiusSettings.ADVANCED);
        assertEquals(10, settings.getEffectiveRadius(false, 0));
        assertEquals(450, settings.getEffectiveRadius(false, 2));
    }

    @Test
    public void jsonAndClonePreserveModesAndAllEightCornersWithoutSharingProperties() {
        ControlButtonStyle style = new ControlButtonStyle("Round trip");
        CornerRadiusSettings settings = style.getCornerSettings();
        settings.setMode(false, CornerRadiusSettings.ADVANCED);
        settings.setMode(true, CornerRadiusSettings.ADVANCED);
        for (int i = 0; i < 4; i++) {
            settings.setRadius(false, i, 10 + i * 30);
            settings.setRadius(true, i, 300 + i * 40);
        }
        ControlButtonStyle restored = gson.fromJson(gson.toJson(style), ControlButtonStyle.class);
        ControlButtonStyle clone = restored.clone();
        for (int i = 0; i < 4; i++) {
            assertEquals(10 + i * 30, clone.getCornerSettings().getRadius(false, i));
            assertEquals(300 + i * 40, clone.getCornerSettings().getRadius(true, i));
        }
        assertEquals(CornerRadiusSettings.ADVANCED, clone.getCornerSettings().getMode(false));
        clone.getCornerSettings().setRadius(false, 0, 500);
        assertEquals(10, restored.getCornerSettings().getRadius(false, 0));
    }

    @Test
    public void pixelRadiiUseAndroidOrderAndInterpolateAcrossDifferentModes() {
        ControlButtonStyle style = new ControlButtonStyle("Interpolate");
        style.setCornerRadius(100);
        CornerRadiusSettings settings = style.getCornerSettings();
        settings.setMode(true, CornerRadiusSettings.ADVANCED);
        for (int i = 0; i < 4; i++) settings.setRadius(true, i, i * 100);
        float[] pixels = new float[8];
        settings.fillPixelRadii(pixels, 0.5f, 2f);
        assertArrayEquals(new float[]{10, 10, 20, 20, 30, 30, 40, 40}, pixels, 0.0001f);
        settings.fillPixelRadii(pixels, 0f, 1f);
        assertArrayEquals(new float[]{10, 10, 10, 10, 10, 10, 10, 10}, pixels, 0.0001f);
    }

    @Test
    public void unknownModeAndMalformedRadiiFallBackWithoutBreakingLegacyStyle() {
        ControlButtonStyle style = gson.fromJson("{\"cornerRadius\":120,\"cornerRadii\":{\"normal\":{\"mode\":\"future\",\"radii\":[1,2]},\"pressed\":{\"mode\":\"advanced\",\"radii\":[-1,900,\"bad\",null]}}}", ControlButtonStyle.class);
        CornerRadiusSettings settings = style.getCornerSettings();
        assertEquals(CornerRadiusSettings.SIMPLE, settings.getMode(false));
        assertEquals(120, settings.getEffectiveRadius(false, 0));
        assertEquals(0, settings.getRadius(true, 0));
        assertEquals(500, settings.getRadius(true, 1));
        assertEquals(100, settings.getRadius(true, 2));
        assertEquals(100, settings.getRadius(true, 3));
    }

    @Test
    public void initializedButTemporarilySimpleCornersPersistAndUninitializedOnesInherit() {
        ControlButtonStyle original = new ControlButtonStyle("Preserve laziness");
        ControlButtonStyle restored = gson.fromJson(gson.toJson(original), ControlButtonStyle.class);
        restored.setCornerRadius(345);
        restored.getCornerSettings().setMode(false, CornerRadiusSettings.ADVANCED);
        assertEquals(345, restored.getCornerSettings().getRadius(false, 0));
        restored.getCornerSettings().setRadius(false, 1, 25);
        restored.getCornerSettings().setMode(false, CornerRadiusSettings.SIMPLE);
        ControlButtonStyle again = gson.fromJson(gson.toJson(restored), ControlButtonStyle.class);
        again.getCornerSettings().setMode(false, CornerRadiusSettings.ADVANCED);
        assertEquals(25, again.getCornerSettings().getRadius(false, 1));
    }

    @Test
    public void directionStyleSelectionCloneAndExportRetainAdvancedCorners() {
        ControlButtonStyle selected = new ControlButtonStyle("Selected");
        selected.getCornerSettings().setMode(false, CornerRadiusSettings.ADVANCED);
        selected.getCornerSettings().setRadius(false, 3, 365);
        ControlDirectionStyle.ButtonStyle direction = new ControlDirectionStyle.ButtonStyle();
        direction.getCornerSettings().copyFrom(selected.getCornerSettings());
        ControlDirectionStyle.ButtonStyle restored = gson.fromJson(gson.toJson(direction), ControlDirectionStyle.ButtonStyle.class);
        ControlDirectionStyle.ButtonStyle clone = restored.clone();
        assertEquals(CornerRadiusSettings.ADVANCED, clone.getCornerSettings().getMode(false));
        assertEquals(365, clone.getCornerSettings().getEffectiveRadius(false, 3));
        clone.getCornerSettings().setRadius(false, 3, 50);
        assertEquals(365, restored.getCornerSettings().getRadius(false, 3));
    }

    @Test
    public void cornerPropertyChangesNotifyOwningStyleAndAreClampedForDrawing() {
        ControlButtonStyle style = new ControlButtonStyle("Observed");
        AtomicInteger changes = new AtomicInteger();
        style.addListener(observable -> changes.incrementAndGet());
        style.getCornerSettings().setMode(false, CornerRadiusSettings.ADVANCED);
        style.getCornerSettings().radiusProperty(false, 0).set(9999);
        assertTrue(changes.get() > 0);
        assertEquals(500, style.getCornerSettings().getEffectiveRadius(false, 0));
        style.getCornerSettings().setRadius(false, 1, -10);
        assertEquals(0, style.getCornerSettings().getRadius(false, 1));
    }
}
