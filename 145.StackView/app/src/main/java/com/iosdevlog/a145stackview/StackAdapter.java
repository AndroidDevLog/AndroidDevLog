package com.iosdevlog.a145stackview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by iosdevlog on 2016/10/18.
 */

public class StackAdapter extends ArrayAdapter<StackItem> {
    private ArrayList<StackItem> items;
    private Context ctx;

    public StackAdapter(Context context, int textViewResourceId,
                        ArrayList<StackItem> objects) {
        super(context, textViewResourceId, objects);

        this.items = objects;
        this.ctx = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater)
                    ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.item, null);
        }

        StackItem m = items.get(position);

        if (m != null) {
            TextView text = (TextView) v.findViewById(R.id.textView1);
            ImageView img = (ImageView) v.findViewById(R.id.imageView1);

            if (text != null) {
                text.setText(m.text);
                img.setImageDrawable(m.img);
            }
        }
        return v;
    }
}
