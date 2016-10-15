package com.iosdevlog.a82dynamicimageview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.view.ViewGroup.LayoutParams;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rl;
    ImageView img;
    Button b;
    int flag = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.activity_main);
        b = (Button) findViewById(R.id.button1);

        img = new ImageView(MainActivity.this);

        img.setImageResource(R.drawable.a4);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        params.addRule(RelativeLayout.CENTER_IN_PARENT);

        img.setLayoutParams(params);

        rl.addView(img);

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (flag == 0) {
                    img.setImageResource(R.drawable.a1);
                    flag = 1;
                } else if (flag == 1) {
                    img.setImageResource(R.drawable.a2);
                    flag = 2;
                } else if (flag == 2) {
                    img.setImageResource(R.drawable.a3);
                    flag = 0;
                }
            }
        });
    }
}
