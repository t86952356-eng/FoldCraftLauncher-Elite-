package com.tungsten.fcl.control;

/** Pixel-space bounds shared by controller drawing and regression tests. */
public final class ControllerIconGeometry {
    private ControllerIconGeometry() {
    }

    public static float top(float defaultTop, float offset, float buttonHeight, float iconHeight, float inset) {
        float maximum = Math.max(0f, buttonHeight - iconHeight);
        float safeInset = Math.max(0f, Math.min(inset, maximum / 2f));
        return Math.max(safeInset, Math.min(maximum - safeInset, defaultTop + offset));
    }
}
