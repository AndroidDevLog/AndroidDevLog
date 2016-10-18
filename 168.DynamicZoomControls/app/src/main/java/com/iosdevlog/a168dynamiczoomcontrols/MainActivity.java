package com.iosdevlog.a168dynamiczoomcontrols;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ZoomControls;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;


public class MainActivity extends AppCompatActivity {
    RelativeLayout rl;
    ZoomControls zoom;
    ImageView img;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.activity_main);
        img = (ImageView) findViewById(R.id.imageView1);

        zoom = new ZoomControls(MainActivity.this);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.bottomMargin = 40;

        zoom.setLayoutParams(params);

        rl.addView(zoom);

        zoom.setOnZoomInClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                float x = img.getScaleX();
                float y = img.getScaleY();

                img.setScaleX(x + 1);
                img.setScaleY(y + 1);
            }
        });

        zoom.setOnZoomOutClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                float x = img.getScaleX();
                float y = img.getScaleY();

                img.setScaleX(x - 1);
                img.setScaleY(y - 1);
            }
        });
    }

}
