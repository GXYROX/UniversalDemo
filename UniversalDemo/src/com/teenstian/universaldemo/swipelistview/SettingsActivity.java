/*
 * Copyright (C) 2013 47 Degrees, LLC
 *  http://47deg.com
 *  hello@47deg.com
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.teenstian.universaldemo.swipelistview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.teenstian.universaldemo.R;
import com.teenstian.universaldemo.swipelistview.library.SwipeListView;

public class SettingsActivity extends Activity {

    private static int MAX_OFFSET = 200;

    private SettingsManager settings;

    private SeekBar sbOffsetLeft;
    private TextView tvOffsetLeft;
    private SeekBar sbOffsetRight;
    private TextView tvOffsetRight;
    private Button infoButton;
    
    
    CompoundButton.OnCheckedChangeListener radiosListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                switch (buttonView.getId()) {
                    case R.id.mode_both:
                        settings.setSwipeMode(SwipeListView.SWIPE_MODE_BOTH);
                        break;
                    case R.id.mode_left:
                        settings.setSwipeMode(SwipeListView.SWIPE_MODE_LEFT);
                        break;
                    case R.id.mode_right:
                        settings.setSwipeMode(SwipeListView.SWIPE_MODE_RIGHT);
                        break;
                    case R.id.action_left_dismiss:
                        settings.setSwipeActionLeft(SwipeListView.SWIPE_ACTION_DISMISS);
                        break;
                    case R.id.action_left_reveal:
                        settings.setSwipeActionLeft(SwipeListView.SWIPE_ACTION_REVEAL);
                        break;
                    case R.id.action_left_choice:
                        settings.setSwipeActionLeft(SwipeListView.SWIPE_ACTION_CHOICE);
                        break;
                    case R.id.action_right_dismiss:
                        settings.setSwipeActionRight(SwipeListView.SWIPE_ACTION_DISMISS);
                        break;
                    case R.id.action_right_reveal:
                        settings.setSwipeActionRight(SwipeListView.SWIPE_ACTION_REVEAL);
                        break;
                    case R.id.action_right_choice:
                        settings.setSwipeActionRight(SwipeListView.SWIPE_ACTION_CHOICE);
                        break;
                }
            }
        }
    };

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        settings = SettingsManager.getInstance();

        infoButton = (Button)findViewById(R.id.button_package_info);
        infoButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SettingsActivity.this, PackageInfoActivity.class);
				startActivity(intent);
			}
		});
        
        RadioButton rbModeBoth = (RadioButton) findViewById(R.id.mode_both);
        rbModeBoth.setOnCheckedChangeListener(radiosListener);

        RadioButton rbModeLeft = (RadioButton) findViewById(R.id.mode_left);
        rbModeLeft.setOnCheckedChangeListener(radiosListener);

        RadioButton rbModeRight = (RadioButton) findViewById(R.id.mode_right);
        rbModeRight.setOnCheckedChangeListener(radiosListener);

        if (settings.getSwipeMode() == SwipeListView.SWIPE_MODE_BOTH) {
            rbModeBoth.setChecked(true);
        } else if (settings.getSwipeMode() == SwipeListView.SWIPE_MODE_LEFT) {
            rbModeLeft.setChecked(true);
        } else if (settings.getSwipeMode() == SwipeListView.SWIPE_MODE_RIGHT) {
            rbModeRight.setChecked(true);
        }

        RadioButton rbActionLeftDismiss = (RadioButton) findViewById(R.id.action_left_dismiss);
        rbActionLeftDismiss.setOnCheckedChangeListener(radiosListener);

        RadioButton rbActionLeftReveal = (RadioButton) findViewById(R.id.action_left_reveal);
        rbActionLeftReveal.setOnCheckedChangeListener(radiosListener);

        RadioButton rbActionLeftChoice = (RadioButton) findViewById(R.id.action_left_choice);
        rbActionLeftChoice.setOnCheckedChangeListener(radiosListener);

        if (settings.getSwipeActionLeft() == SwipeListView.SWIPE_ACTION_DISMISS) {
            rbActionLeftDismiss.setChecked(true);
        } else if (settings.getSwipeActionLeft() == SwipeListView.SWIPE_ACTION_REVEAL) {
            rbActionLeftReveal.setChecked(true);
        } else if (settings.getSwipeActionLeft() == SwipeListView.SWIPE_ACTION_CHOICE) {
            rbActionLeftChoice.setChecked(true);
        }

        RadioButton rbActionRightDismiss = (RadioButton) findViewById(R.id.action_right_dismiss);
        rbActionRightDismiss.setOnCheckedChangeListener(radiosListener);

        RadioButton rbActionRightReveal = (RadioButton) findViewById(R.id.action_right_reveal);
        rbActionRightReveal.setOnCheckedChangeListener(radiosListener);

        RadioButton rbActionRightChoice = (RadioButton) findViewById(R.id.action_right_choice);
        rbActionRightChoice.setOnCheckedChangeListener(radiosListener);

        if (settings.getSwipeActionRight() == SwipeListView.SWIPE_ACTION_DISMISS) {
            rbActionRightDismiss.setChecked(true);
        } else if (settings.getSwipeActionRight() == SwipeListView.SWIPE_ACTION_REVEAL) {
            rbActionRightReveal.setChecked(true);
        } else if (settings.getSwipeActionRight() == SwipeListView.SWIPE_ACTION_CHOICE) {
            rbActionRightChoice.setChecked(true);
        }

        tvOffsetLeft = (TextView) findViewById(R.id.offset_label_left);
        tvOffsetLeft.setText(SettingsActivity.this.getString(R.string.leftOffset, (int) settings.getSwipeOffsetLeft()));

        sbOffsetLeft = (SeekBar) findViewById(R.id.offset_left);
        sbOffsetLeft.setMax(MAX_OFFSET);
        sbOffsetLeft.setProgress((int) settings.getSwipeOffsetLeft());
        sbOffsetLeft.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                settings.setSwipeOffsetLeft(progress);
                tvOffsetLeft.setText(SettingsActivity.this.getString(R.string.leftOffset, progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        tvOffsetRight = (TextView) findViewById(R.id.offset_label_right);

        sbOffsetRight = (SeekBar) findViewById(R.id.offset_right);
        tvOffsetRight.setText(SettingsActivity.this.getString(R.string.rightOffset, (int) settings.getSwipeOffsetRight()));
        sbOffsetRight.setMax(MAX_OFFSET);
        sbOffsetRight.setProgress((int) settings.getSwipeOffsetRight());
        sbOffsetRight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                settings.setSwipeOffsetRight(progress);
                tvOffsetRight.setText(SettingsActivity.this.getString(R.string.rightOffset, progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        final EditText etAnimationTime = (EditText) findViewById(R.id.animation_time);
        etAnimationTime.setText(String.format("%d", (int) settings.getSwipeAnimationTime()));
        etAnimationTime.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.isEmpty(s)) {
                    try {
                        settings.setSwipeAnimationTime(Integer.parseInt(s.toString()));
                    } catch (NumberFormatException e) {
                        etAnimationTime.setText("0");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        CheckBox cbLongPress = (CheckBox) findViewById(R.id.open_long_press);
        cbLongPress.setChecked(settings.isSwipeOpenOnLongPress());
        cbLongPress.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                settings.setSwipeOpenOnLongPress(isChecked);
            }
        });

    }

}