package com.teenstian.universaldemo.compoundviews;

import java.util.ArrayList;
import java.util.List;

import com.teenstian.universaldemo.R;
import com.teenstian.universaldemo.R.id;
import com.teenstian.universaldemo.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;

public class CompoundViewsActivity extends Activity {

	private NumberPicker mFriendCountPicker;
	private FriendNameView mFriendNameView;
	private Button mCountFriendsButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.compound_views_main);

		mFriendCountPicker = (NumberPicker) findViewById(R.id.friend_count);
		mFriendNameView = (FriendNameView) findViewById(R.id.friend_names);
		mCountFriendsButton = (Button) findViewById(R.id.count_friends_button);

		mFriendCountPicker.setMaxValue(10);
		mFriendCountPicker.setOnValueChangedListener(new OnValueChangeListener() {
					@Override
					public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
						mFriendNameView.setFriendCount(newVal);
					}
				});

		mCountFriendsButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				List<String> names = mFriendNameView.getFriendNames();
				Intent i = new Intent(CompoundViewsActivity.this, FriendCountActivity.class);
				i.putStringArrayListExtra("names", new ArrayList<String>(names));
				startActivity(i);
			}
		});
	}
}
