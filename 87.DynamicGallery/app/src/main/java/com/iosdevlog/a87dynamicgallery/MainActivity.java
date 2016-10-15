package com.iosdevlog.a87dynamicgallery;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    RelativeLayout rl;
    ImageView img;
    Gallery gal;
    TextView tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int[] myImageIds = {
                R.drawable.autolayout,
                R.drawable.gameplaykit,
                R.drawable.multitasking,
                R.drawable.protocol,
                R.drawable.valuetypes,
                R.drawable.watchkit,
        };

        rl = (RelativeLayout) findViewById(R.id.activity_main);
        tv = (TextView) findViewById(R.id.textView2);
        img = (ImageView) findViewById(R.id.imageView1);
        gal = new Gallery(MainActivity.this);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
                (LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

        params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        gal.setLayoutParams(params);

        rl.addView(gal);

        gal.setAdapter(new ImageAdapter(this));

        gal.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                tv.setText("Selected Option : " + arg2);

                img.setImageResource(myImageIds[arg2]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                tv.setText("Nothing Selected");
            }
        });
    }
}

class ImageAdapter extends BaseAdapter {

    private Context myContext;

    private int[] myImageIds = {
            R.drawable.autolayout,
            R.drawable.gameplaykit,
            R.drawable.multitasking,
            R.drawable.protocol,
            R.drawable.valuetypes,
            R.drawable.watchkit,
    };

    public ImageAdapter(Context c) {
        this.myContext = c;
    }

    @Override
    public int getCount() {
        return this.myImageIds.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView iv = new ImageView(this.myContext);
        iv.setImageResource(this.myImageIds[position]);

        iv.setScaleType(ImageView.ScaleType.FIT_END);

        // Set the Width & Height of the individual images
        iv.setLayoutParams(new Gallery.LayoutParams(300, 300));

        return iv;
    }
}
