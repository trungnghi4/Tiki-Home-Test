package com.ntn.testhometiki.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import com.ntn.testhometiki.R;

import java.util.Random;

public class Utils {

    public static int getRandomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    // set background and color
    public static Drawable getRoundBackground(Context context, int colorHex) {
        Drawable mDrawable = ContextCompat.getDrawable(context, R.drawable.bg_radius_round);
        if (mDrawable != null) {
            mDrawable.setColorFilter(new PorterDuffColorFilter(colorHex, PorterDuff.Mode.MULTIPLY));
        }
        return mDrawable;
    }
}
