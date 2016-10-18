package com.iosdevlog.a165staticzoombutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ZoomButton;

public class MainActivity extends AppCompatActivity {
    ZoomButton zoom;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zoom = (ZoomButton) findViewById(R.id.zoomButton1);
        img = (ImageView) findViewById(R.id.imageView1);

        zoom.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                float x = img.getScaleX();
                float y = img.getScaleY();

                img.setScaleX(x+2);
                img.setScaleY(y+2);
            }
        });
    }
}
