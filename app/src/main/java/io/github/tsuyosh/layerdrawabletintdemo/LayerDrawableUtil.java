package io.github.tsuyosh.layerdrawabletintdemo;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;

/**
 * Created by tsuyosh on 17/02/07.
 */

public class LayerDrawableUtil {
	public static void invalidateCache(Drawable d) {
		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) return;
		if (!(d instanceof LayerDrawable)) return;

		LayerDrawable ld = (LayerDrawable) d;
		int count = ld.getNumberOfLayers();
		if (count == 0) return;

		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
			// TODO first layer item needs to be set android:id
			int id = ld.getId(0);
			Drawable d0 = ld.findDrawableByLayerId(id);
			ld.setDrawableByLayerId(id, d0);
		} else {
			Drawable d0 = ld.getDrawable(0);
			ld.setDrawable(0, d0);
		}
	}
}
