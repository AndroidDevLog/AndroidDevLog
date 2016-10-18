package com.iosdevlog.a144dynamicimageswitcher;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends AppCompatActivity implements ViewFactory {


    RelativeLayout rl;
    Gallery gal;
    ImageSwitcher img;
    RelativeLayout.LayoutParams params;

    int imgs[] =
            {
                    R.drawable.android,
                    R.drawable.cup,
                    R.drawable.donut,
                    R.drawable.eclair,
                    R.drawable.froyo,
                    R.drawable.ginger,
                    R.drawable.honey,
                    R.drawable.ics,
                    R.drawable.jellybean
            };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.activity_main);
        gal = (Gallery) findViewById(R.id.gallery1);

        img = new ImageSwitcher(MainActivity.this);

        gal.setAdapter(new ImageAdapter(this));

        img.setFactory(this);

        img.setAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));

        img.setAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));

        params = new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        params.addRule(RelativeLayout.CENTER_IN_PARENT);

        img.setLayoutParams(params);

        rl.addView(img);

        gal.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                img.setImageResource(imgs[arg2]);
            }
        });
    }

    public class ImageAdapter extends BaseAdapter {
        private Context ctx;

        public ImageAdapter(Context c) {
            ctx = c;
        }

        @Override
        public int getCount() {
            return imgs.length;
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
            ImageView iView = new ImageView(ctx);
            iView.setImageResource(imgs[position]);
            iView.setScaleType(ImageView.ScaleType.FIT_XY);
            iView.setLayoutParams(new Gallery.LayoutParams(200, 150));

            return iView;
        }
    }

    @Override
    public View makeView() {
        ImageView iView = new ImageView(this);
        iView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        iView.setLayoutParams(new ImageSwitcher.LayoutParams
                (LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        iView.setBackgroundColor(0xFFffffff);

        return iView;
    }
}
