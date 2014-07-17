package com.teenstian.universaldemo.compoundviews;

import java.util.List;

import com.teenstian.universaldemo.R;
import com.teenstian.universaldemo.R.id;
import com.teenstian.universaldemo.R.layout;
import com.teenstian.universaldemo.R.string;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by rharter on 5/14/14.
 */
public class FriendCountActivity extends Activity {

    private TextView mTextView;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_count);

        mTextView = (TextView) findViewById(R.id.friend_text);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            List<String> names = extras.getStringArrayList("names");
            setFriendText(names);
        }
    }

    private void setFriendText(List<String> names) {
        StringBuilder builder = new StringBuilder();
        builder.append(getString(R.string.you_have_friends, names.size()));
        builder.append('\n');
        for (String name : names) {
            builder.append(name).append('\n');
        }
        mTextView.setText(builder.toString());
    }
}
