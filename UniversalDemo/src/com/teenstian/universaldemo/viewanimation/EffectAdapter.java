package com.teenstian.universaldemo.viewanimation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.daimajia.androidanimations.library.YoYo;
import com.teenstian.universaldemo.R;
import com.teenstian.universaldemo.R.id;
import com.teenstian.universaldemo.R.layout;

public class EffectAdapter extends BaseAdapter {

    private Context mContext;

    public EffectAdapter(Context context){
        mContext = context;
    }

    @Override
    public int getCount() {
        return YoYo.Techniques.values().length;
    }

    @Override
    public Object getItem(int position) {
        return YoYo.Techniques.values()[position].getAnimator();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item,null,false);
        TextView t = (TextView)v.findViewById(R.id.list_item_text);
        Object o = getItem(position);
        int start = o.getClass().getName().lastIndexOf(".") + 1;
        String name = o.getClass().getName().substring(start);
        t.setText(name);
        v.setTag(o);
        return v;
    }
}
