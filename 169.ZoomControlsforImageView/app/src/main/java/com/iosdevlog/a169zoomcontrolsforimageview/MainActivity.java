package com.iosdevlog.a169zoomcontrolsforimageview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ZoomControls;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    ZoomControls zoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.imageView1);
        zoom = (ZoomControls) findViewById(R.id.zoomControls1);

        zoom.setOnZoomInClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int w = img.getWidth();
                int h = img.getHeight();

                RelativeLayout.LayoutParams params =
                        new RelativeLayout.LayoutParams(w + 10, h + 10);
                params.addRule(RelativeLayout.CENTER_IN_PARENT);

                img.setLayoutParams(params);
            }
        });

        zoom.setOnZoomOutClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int w = img.getWidth();
                int h = img.getHeight();

                RelativeLayout.LayoutParams params =
                        new RelativeLayout.LayoutParams(w - 10, h - 10);
                params.addRule(RelativeLayout.CENTER_IN_PARENT);

                img.setLayoutParams(params);
            }
        });
    }
}
