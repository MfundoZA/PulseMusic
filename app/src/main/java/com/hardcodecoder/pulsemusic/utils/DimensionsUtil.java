package com.hardcodecoder.pulsemusic.utils;

import android.content.Context;
import android.util.DisplayMetrics;

public class DimensionsUtil {

    public static float convertToPixels(Context context, float dimenDp) {
        float factor = (float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT;
        return factor * dimenDp;
    }
}
