package com.iosdevlog.a167staticzoomcontrols;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ZoomControls;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {
    ZoomControls zoom;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zoom = (ZoomControls) findViewById(R.id.zoomControls1);
        img = (ImageView) findViewById(R.id.imageView1);

        zoom.setOnZoomInClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                float x = img.getScaleX();
                float y = img.getScaleY();

                img.setScaleX((x + 1));
                img.setScaleY((y + 1));
            }
        });

        zoom.setOnZoomOutClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                float x = img.getScaleX();
                float y = img.getScaleY();

                img.setScaleX((x - 1));
                img.setScaleY((y - 1));
            }
        });
    }
}
