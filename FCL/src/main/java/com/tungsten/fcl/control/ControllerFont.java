package com.tungsten.fcl.control;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;

/** A private, validated font override for game controls only; never the launcher UI. */
public final class ControllerFont {
    private static final String FILE_NAME = "controller-font";
    private static final int MAX_BYTES = 20 * 1024 * 1024;
    // Only accessed on the UI thread. Weak keys do not keep closed game views alive.
    private static final Map<TextView, Typeface> ORIGINALS = new WeakHashMap<>();
    private static boolean loaded;
    private static Typeface cached;

    private ControllerFont() {
    }

    private static synchronized Typeface get(Context context) {
        if (!loaded) {
            File file = new File(context.getFilesDir(), FILE_NAME);
            try {
                cached = file.isFile() ? Typeface.createFromFile(file) : null;
            } catch (RuntimeException ignored) {
                cached = null;
            }
            loaded = true;
        }
        return cached;
    }

    public static void applyTo(TextView view) {
        if (!ORIGINALS.containsKey(view)) ORIGINALS.put(view, view.getTypeface());
        Typeface font = get(view.getContext());
        view.setTypeface(font == null ? ORIGINALS.get(view) : font);
        view.requestLayout();
        view.invalidate();
    }

    /** Copy before validation and replace only after success; a failed import keeps the old font. */
    public static void install(Context context, InputStream input) throws IOException {
        if (input == null) throw new IOException("No font stream");
        File temp = File.createTempFile("controller-font-", ".tmp", context.getFilesDir());
        try {
            try (FileOutputStream output = new FileOutputStream(temp)) {
                byte[] buffer = new byte[8192];
                int total = 0;
                int read;
                while ((read = input.read(buffer)) != -1) {
                    total += read;
                    if (total > MAX_BYTES) throw new IOException("Font exceeds 20 MiB");
                    output.write(buffer, 0, read);
                }
                if (total == 0) throw new IOException("Empty font");
                output.getFD().sync();
            }
            Typeface font = Typeface.createFromFile(temp);
            synchronized (ControllerFont.class) {
                File destination = new File(context.getFilesDir(), FILE_NAME);
                try {
                    Files.move(temp.toPath(), destination.toPath(), StandardCopyOption.ATOMIC_MOVE,
                            StandardCopyOption.REPLACE_EXISTING);
                } catch (AtomicMoveNotSupportedException e) {
                    Files.move(temp.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
                cached = font;
                loaded = true;
            }
            refreshViews();
        } finally {
            Files.deleteIfExists(temp.toPath());
        }
    }

    public static synchronized void reset(Context context) throws IOException {
        Files.deleteIfExists(new File(context.getFilesDir(), FILE_NAME).toPath());
        cached = null;
        loaded = true;
        refreshViews();
    }

    private static void refreshViews() {
        new Handler(Looper.getMainLooper()).post(() -> {
            for (TextView view : new ArrayList<>(ORIGINALS.keySet())) {
                if (view != null) applyTo(view);
            }
        });
    }
}
