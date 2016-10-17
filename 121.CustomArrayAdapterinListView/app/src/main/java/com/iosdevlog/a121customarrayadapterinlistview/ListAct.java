package com.iosdevlog.a121customarrayadapterinlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by iosdevlog on 2016/10/17.
 */

public class ListAct extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public ListAct(Context context, String[] values) {
        super(context, R.layout.activity_main, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.activity_main, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
        textView.setText(values[position]);

        // Change icon based on name
        String s = values[position];

        System.out.println(s);

        if (s.equals("CupCake")) {
            imageView.setImageResource(R.drawable.cup);
        } else if (s.equals("Donut")) {
            imageView.setImageResource(R.drawable.donut);
        } else if (s.equals("Froyo")) {
            imageView.setImageResource(R.drawable.froyo);
        } else if (s.equals("GingerBread")) {
            imageView.setImageResource(R.drawable.ginger);
        } else if (s.equals("HoneyComb")) {
            imageView.setImageResource(R.drawable.honey);
        } else if (s.equals("Ice-Cream Sandwich")) {
            imageView.setImageResource(R.drawable.ics);
        } else if (s.equals("Jelly-Bean")) {
            imageView.setImageResource(R.drawable.jellybean);
        } else {
            imageView.setImageResource(R.drawable.jelly);
        }

        return rowView;
    }
}
