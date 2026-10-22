package com.tungsten.fcl.control.data;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.tungsten.fcl.setting.MenuSetting;

import org.junit.Test;

import static org.junit.Assert.*;

public class ControllerAppearanceTest {
    private final Gson gson = new Gson();

    @Test
    public void editorSnapshotCopiesIconAndDimensionsWithoutReplacingId() {
        ControlButtonData original = new ControlButtonData("keep-this-id");
        ControlButtonData edited = original.clone();
        edited.setIcon("pickaxe");
        edited.setIconWidth(42);
        edited.setIconHeight(36);
        edited.getStyle().setAnimationEnabled(true);
        edited.getStyle().setAnimationDuration(250);
        original.copySettingsFrom(edited);
        assertEquals("keep-this-id", original.getId());
        assertEquals("pickaxe", original.getIcon());
        assertEquals(42, original.getIconWidth());
        assertEquals(36, original.getIconHeight());
        assertTrue(original.getStyle().isAnimationEnabled());
        assertEquals(250, original.getStyle().getAnimationDuration());
        assertNotSame(edited.getStyle(), original.getStyle());
        assertNotSame(edited.getBaseInfo(), original.getBaseInfo());
        assertNotSame(edited.getEvent(), original.getEvent());
        edited.setIcon("none");
        assertEquals("pickaxe", original.getIcon());
    }

    @Test
    public void cloneAndExportRetainStableIconIdAndSize() {
        ControlButtonData button = new ControlButtonData("source");
        button.setIcon("bow");
        button.setIconWidth(40);
        button.setIconHeight(32);
        ControlButtonData copy = button.clone();
        assertNotEquals(button.getId(), copy.getId());
        JsonObject json = gson.toJsonTree(copy).getAsJsonObject();
        assertEquals("bow", json.get("icon").getAsString());
        assertEquals(40, json.get("iconWidth").getAsInt());
        assertEquals(32, json.get("iconHeight").getAsInt());
    }

    @Test
    public void animationRoundTripAndClonePreserveSettings() {
        ControlButtonStyle style = new ControlButtonStyle("Smooth");
        style.setAnimationEnabled(true);
        style.setAnimationDuration(320);
        ControlButtonStyle restored = gson.fromJson(gson.toJson(style), ControlButtonStyle.class);
        assertTrue(restored.isAnimationEnabled());
        assertEquals(320, restored.getAnimationDuration());
        assertTrue(restored.clone().isAnimationEnabled());
        assertEquals(320, restored.clone().getAnimationDuration());
    }

    @Test
    public void oldStyleUsesInstantTransitionAndSafeDefaultDuration() {
        ControlButtonStyle old = gson.fromJson("{\"name\":\"Legacy\"}", ControlButtonStyle.class);
        assertFalse(old.isAnimationEnabled());
        assertEquals(180, old.getAnimationDuration());
        old.setAnimationDuration(-10);
        assertEquals(50, old.getAnimationDuration());
        old.setAnimationDuration(100000);
        assertEquals(1000, old.getAnimationDuration());
    }

    @Test
    public void menuCountersPersistIndependentlyOfStandaloneOverlays() {
        MenuSetting settings = new MenuSetting();
        settings.setMenuShowFps(false);
        settings.setMenuShowRam(true);
        settings.setMenuShowTime(false);
        settings.setShowFps(true);
        settings.setShowMemory(false);
        MenuSetting restored = gson.fromJson(gson.toJson(settings), MenuSetting.class);
        assertFalse(restored.isMenuShowFps());
        assertTrue(restored.isMenuShowRam());
        assertFalse(restored.isMenuShowTime());
        assertTrue(restored.isShowFps());
        assertFalse(restored.isShowMemory());
    }

    @Test
    public void oldMenuSettingsReceiveVisibleCountersByDefault() {
        MenuSetting old = gson.fromJson("{}", MenuSetting.class);
        assertTrue(old.isMenuShowFps());
        assertTrue(old.isMenuShowRam());
        assertTrue(old.isMenuShowTime());
    }
}
