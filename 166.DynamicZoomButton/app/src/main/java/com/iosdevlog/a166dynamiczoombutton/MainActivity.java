package com.iosdevlog.a166dynamiczoombutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ZoomButton;
import android.widget.RelativeLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rl;
    ZoomButton zoom;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.activity_main);
        img = (ImageView) findViewById(R.id.imageView1);

        zoom = new ZoomButton(MainActivity.this);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

        params.bottomMargin = 40;

        zoom.setImageResource(android.R.drawable.btn_plus);
        zoom.setLayoutParams(params);

        rl.addView(zoom);

        zoom.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                float x = img.getScaleX();
                float y = img.getScaleY();

                img.setScaleX(x + 2);
                img.setScaleY(y + 2);
            }
        });
    }
}
