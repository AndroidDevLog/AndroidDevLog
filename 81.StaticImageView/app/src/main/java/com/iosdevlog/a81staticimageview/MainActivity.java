package com.iosdevlog.a81staticimageview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    Button b;
    int flag = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.imageView1);
        b = (Button) findViewById(R.id.button1);

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (flag == 0) {
                    img.setImageResource(R.drawable.a2);
                    flag = 1;
                } else if (flag == 1) {
                    img.setImageResource(R.drawable.a3);
                    flag = 2;
                } else if (flag == 2) {
                    img.setImageResource(R.drawable.a4);
                    flag = 0;
                }
            }
        });
    }
}
