package com.teenstian.universaldemo.translucentactionbar;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.ScrollView;

import com.teenstian.universaldemo.R;

public class TranslucentActionBarActivity extends Activity {

	private Drawable mActionBarBackgroundDrawable;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.translucent_actionbar);

		mActionBarBackgroundDrawable = getResources().getDrawable(R.drawable.skin_purple);
		mActionBarBackgroundDrawable.setAlpha(0);

		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
		    mActionBarBackgroundDrawable.setCallback(mDrawableCallback);
		}
		
		getActionBar().setBackgroundDrawable(mActionBarBackgroundDrawable);

		((NotifyingScrollView) findViewById(R.id.scroll_view)).setOnScrollChangedListener(mOnScrollChangedListener);
	}

	private NotifyingScrollView.OnScrollChangedListener mOnScrollChangedListener = new NotifyingScrollView.OnScrollChangedListener() {
		public void onScrollChanged(ScrollView who, int l, int t, int oldl,
				int oldt) {
			final int headerHeight = findViewById(R.id.image_header)
					.getHeight() - getActionBar().getHeight();
			final float ratio = (float) Math.min(Math.max(t, 0), headerHeight)
					/ headerHeight;
			final int newAlpha = (int) (ratio * 255);
			mActionBarBackgroundDrawable.setAlpha(newAlpha);
		}
	};

	private Drawable.Callback mDrawableCallback = new Drawable.Callback() {
		@Override
		public void invalidateDrawable(Drawable who) {
			getActionBar().setBackgroundDrawable(who);
		}

		@Override
		public void scheduleDrawable(Drawable who, Runnable what, long when) {
		}

		@Override
		public void unscheduleDrawable(Drawable who, Runnable what) {
		}
	};

}
