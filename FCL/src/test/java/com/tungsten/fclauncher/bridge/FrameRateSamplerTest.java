package com.tungsten.fclauncher.bridge;

import org.junit.Test;
import java.util.concurrent.atomic.AtomicInteger;
import static org.junit.Assert.assertEquals;

public class FrameRateSamplerTest {
    @Test
    public void multipleDisplaysShareOneCounterReadPerSecond() {
        FrameRateSampler sampler = new FrameRateSampler();
        AtomicInteger frames = new AtomicInteger(20);
        assertEquals(0, sampler.sample(0L, () -> frames.getAndSet(0)));
        frames.set(60);
        assertEquals(60, sampler.sample(1000L, () -> frames.getAndSet(0)));
        frames.set(5);
        assertEquals(60, sampler.sample(1050L, () -> frames.getAndSet(0)));
        assertEquals(5, frames.get());
        frames.addAndGet(55);
        assertEquals(60, sampler.sample(2000L, () -> frames.getAndSet(0)));
    }

    @Test
    public void normalizesDelayedSamplingByElapsedTime() {
        FrameRateSampler sampler = new FrameRateSampler();
        AtomicInteger frames = new AtomicInteger();
        sampler.sample(100L, () -> frames.getAndSet(0));
        frames.set(120);
        assertEquals(60, sampler.sample(2100L, () -> frames.getAndSet(0)));
        assertEquals(60, sampler.sample(2150L, () -> frames.getAndSet(0)));
    }
}
