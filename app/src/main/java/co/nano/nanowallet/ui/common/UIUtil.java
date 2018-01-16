package co.nano.nanowallet.ui.common;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;

import co.nano.nanowallet.R;

/**
 * UI Utility Functions
 */

public class UIUtil {
    /**
     * Colorize a string in the following manner:
     * First 9 characters are blue
     * Last 5 characters are orange
     *
     * @param s       Spannable
     * @param context
     */
    public static void colorizeSpannable(Spannable s, Context context) {
        s.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.dark_sky_blue)), 0, s.length() > 8 ? 9 : s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        if (s.length() > 59) {
            s.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.burnt_yellow)), 59, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

    /**
     * Colorize a string in the following manner:
     * First 9 characters are blue
     * Last 5 characters are orange
     *
     * @param s       String
     * @param context Context
     * @return Spannable string
     */
    public static Spannable getColorizedSpannable(String s, Context context) {
        Spannable sp = new SpannableString(s);
        colorizeSpannable(sp, context);
        return sp;
    }


    /**
     * This method converts dp unit to equivalent pixels, depending on device density.
     *
     * @param dp      A value in dp (density independent pixels) unit. Which we need to convert into pixels
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent px equivalent to dp depending on device density
     */
    public static float convertDpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    /**
     * This method converts device specific pixels to density independent pixels.
     *
     * @param px      A value in px (pixels) unit. Which we need to convert into dp
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent dp equivalent to px value
     */
    public static float convertPixelsToDp(float px, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return dp;
    }
}