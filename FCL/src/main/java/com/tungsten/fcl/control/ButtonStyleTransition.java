package com.tungsten.fcl.control;

import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.ColorUtils;

import com.tungsten.fcl.control.data.ControlButtonStyle;
import com.tungsten.fcllibrary.util.ConvertUtils;

/** Animates visuals only; input events are never delayed by the transition. */
public final class ButtonStyleTransition implements View.OnAttachStateChangeListener {
    private final AppCompatButton button;
    private final Runnable onFrame;
    private final GradientDrawable background = new GradientDrawable();
    private ControlButtonStyle style;
    private ValueAnimator animator;
    private final float[] cornerRadii = new float[8];
    private float fraction;
    private float target;

    public ButtonStyleTransition(AppCompatButton button, Runnable onFrame) {
        this.button = button;
        this.onFrame = onFrame;
        button.addOnAttachStateChangeListener(this);
        button.setSupportBackgroundTintList(null);
    }

    public void reset(ControlButtonStyle style) {
        cancel();
        this.style = style;
        fraction = 0f;
        target = 0f;
        button.setBackground(background);
        apply();
    }

    public void setPressed(boolean pressed) {
        if (style == null) return;
        float next = pressed ? 1f : 0f;
        if (target == next && animator != null && animator.isRunning()) return;
        cancel();
        target = next;
        if (!style.isAnimationEnabled() || !button.isAttachedToWindow()
                || !ValueAnimator.areAnimatorsEnabled() || fraction == target) {
            fraction = target;
            apply();
            return;
        }
        animator = ValueAnimator.ofFloat(fraction, target);
        animator.setDuration(Math.max(1L, Math.round(style.getAnimationDuration() * Math.abs(target - fraction))));
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.addUpdateListener(value -> {
            fraction = (float) value.getAnimatedValue();
            apply();
        });
        animator.start();
    }

    private float blend(float normal, float pressed) {
        return normal + (pressed - normal) * fraction;
    }

    private void apply() {
        background.setColor(ColorUtils.blendARGB(style.getFillColor(), style.getFillColorPressed(), fraction));
        background.setStroke(ConvertUtils.dip2px(button.getContext(), blend(style.getStrokeWidth(), style.getStrokeWidthPressed()) / 10f),
                ColorUtils.blendARGB(style.getStrokeColor(), style.getStrokeColorPressed(), fraction));
        style.getCornerSettings().fillPixelRadii(cornerRadii, fraction, button.getResources().getDisplayMetrics().density);
        background.setCornerRadii(cornerRadii);
        button.setTextColor(ColorUtils.blendARGB(style.getTextColor(), style.getTextColorPressed(), fraction));
        button.setTextSize(blend(style.getTextSize(), style.getTextSizePressed()));
        if (onFrame != null) onFrame.run();
    }

    public void cancel() {
        if (animator != null) {
            animator.cancel();
            animator = null;
        }
    }

    @Override
    public void onViewAttachedToWindow(View view) {
    }

    @Override
    public void onViewDetachedFromWindow(View view) {
        cancel();
        target = 0f;
        fraction = 0f;
        if (style != null) apply();
    }
}
