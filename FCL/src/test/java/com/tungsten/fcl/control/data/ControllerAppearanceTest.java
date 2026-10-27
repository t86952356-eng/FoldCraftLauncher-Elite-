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

    @Test
    public void newIconDefaultsAndVerticalOffsetSurviveEditorCopiesAndExport() {
        ControlButtonData source = new ControlButtonData("source");
        assertEquals(14, source.getIconWidth());
        assertEquals(14, source.getIconHeight());
        assertEquals(0, source.getIconOffsetY());
        source.setIconWidth(24); // Do not overwrite dimensions saved by an older release.
        source.setIconOffsetY(18);
        ControlButtonData target = new ControlButtonData("target");
        target.copySettingsFrom(source);
        assertEquals("target", target.getId());
        assertEquals(24, target.getIconWidth());
        assertEquals(18, target.getIconOffsetY());
        assertEquals(18, target.clone().getIconOffsetY());
        assertEquals(18, gson.toJsonTree(target).getAsJsonObject().get("iconOffsetY").getAsInt());
        target.setIconOffsetY(1000);
        assertEquals(96, target.getIconOffsetY());
        target.setIconOffsetY(-1000);
        assertEquals(-96, target.getIconOffsetY());
    }

    @Test
    public void menuAppearanceHasCompatibleDefaultsAndIndependentPersistence() {
        MenuSetting legacy = gson.fromJson("{}", MenuSetting.class);
        assertEquals(80, legacy.getMenuBackgroundOpacity());
        assertEquals(100, legacy.getMenuScale());
        assertEquals(232, legacy.getMenuLength());
        legacy.setMenuBackgroundOpacity(0);
        legacy.setMenuScale(125);
        legacy.setMenuLength(310);
        MenuSetting restored = gson.fromJson(gson.toJson(legacy), MenuSetting.class);
        assertEquals(0, restored.getMenuBackgroundOpacity());
        assertEquals(125, restored.getMenuScale());
        assertEquals(310, restored.getMenuLength());
        assertTrue(restored.isMenuShowFps());
        restored.setMenuBackgroundOpacity(200);
        restored.setMenuScale(-1);
        restored.setMenuLength(10000);
        assertEquals(100, restored.getMenuBackgroundOpacity());
        assertEquals(50, restored.getMenuScale());
        assertEquals(360, restored.getMenuLength());
    }

    @Test
    public void movingIconClampsToButtonWithoutChangingTextLayout() {
        assertEquals(10f, com.tungsten.fcl.control.ControllerIconGeometry.top(10, 0, 48, 14, 2), 0f);
        assertEquals(20f, com.tungsten.fcl.control.ControllerIconGeometry.top(10, 10, 48, 14, 2), 0f);
        assertEquals(32f, com.tungsten.fcl.control.ControllerIconGeometry.top(10, 100, 48, 14, 2), 0f);
        assertEquals(2f, com.tungsten.fcl.control.ControllerIconGeometry.top(10, -100, 48, 14, 2), 0f);
        assertEquals(0f, com.tungsten.fcl.control.ControllerIconGeometry.top(10, 100, 1, 1, 2), 0f);
    }

    @Test
    public void iconCatalogPreservesExistingIdsAndAdds15LucideIcons() {
        java.util.Set<String> ids = new java.util.HashSet<>();
        for (com.tungsten.fcl.control.ControllerIconRegistry.Icon icon :
                com.tungsten.fcl.control.ControllerIconRegistry.INSTANCE.getIcons()) {
            assertTrue(ids.add(icon.getId()));
        }
        assertEquals(68, ids.size()); // 52 existing + 15 new + none.
        assertTrue(ids.contains("gamepad"));
        assertTrue(ids.contains("crosshair"));
        assertTrue(ids.contains("battery"));
        assertTrue(ids.contains("capacitor"));
        assertTrue(ids.contains("motion_wave"));
        assertTrue(ids.contains("minecraft_pickaxe"));
        assertEquals("none", com.tungsten.fcl.control.ControllerIconRegistry.INSTANCE.find("unknown-future-id").getId());
    }
}
