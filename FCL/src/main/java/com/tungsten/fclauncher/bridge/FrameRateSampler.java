package com.tungsten.fclauncher.bridge;

import java.util.function.IntSupplier;

/** One destructive native-counter read per interval, shared by all FPS displays. */
final class FrameRateSampler {
    private long lastSampleTime = -1L;
    private int cachedFps;

    synchronized int sample(long now, IntSupplier counter) {
        if (lastSampleTime < 0L) {
            counter.getAsInt();
            lastSampleTime = now;
            return 0;
        }
        long elapsed = now - lastSampleTime;
        if (elapsed >= 1000L) {
            cachedFps = Math.max(0, (int) Math.round(counter.getAsInt() * 1000d / elapsed));
            lastSampleTime = now;
        }
        return cachedFps;
    }
}
