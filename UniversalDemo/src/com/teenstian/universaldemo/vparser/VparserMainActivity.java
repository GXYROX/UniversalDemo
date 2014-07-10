package com.teenstian.universaldemo.vparser;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.teenstian.universaldemo.R;
import com.teenstian.universaldemo.R.id;
import com.teenstian.universaldemo.R.layout;
import com.yixia.vparser.VParser;
import com.yixia.vparser.model.Video;

public class VparserMainActivity extends Activity {

	private VParser mVParser;
	private EditText mEditText;
	private Button mParserButton;
	private Button mPlayButton;
	private TextView mTitleView;
	private TextView mUriView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vparser_demo);

		mVParser = new VParser(this);
		mEditText = (EditText) findViewById(R.id.et_website);
		mParserButton = (Button) findViewById(R.id.bt_parser);
		mPlayButton = (Button) findViewById(R.id.bt_play);
		mParserButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String website = mEditText.getText().toString();
				if (TextUtils.isEmpty(website)) {
					return;
				}
				new AsyncTask<Object, Void, Video>() {

					@Override
					protected Video doInBackground(Object... params) {
						return mVParser.parse(String.valueOf(params[0]));
					}

					@Override
					protected void onPostExecute(Video result) {
						super.onPostExecute(result);
						if (result != null) {
							String title = result.title;
							String uri = result.videoUri;
							String website = result.videoSiteUri;
							mTitleView.setText(title);
							mUriView.setText(uri);
						}
					}

				}.execute(website);
			}
		});
		
		mPlayButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (!("".equals(mUriView.getText().toString()))) {
					Intent playIntent = new Intent(VparserMainActivity.this, VideoPlayActivity.class);
					playIntent.putExtra("play_title", mTitleView.getText().toString());
					playIntent.putExtra("play_url", mUriView.getText().toString());
					startActivity(playIntent);
				}
			}
			
		});
		
		
		mTitleView = (TextView) findViewById(R.id.tv_title);
		mUriView = (TextView) findViewById(R.id.tv_uri);
	}


}
