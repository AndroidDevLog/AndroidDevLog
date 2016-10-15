package com.iosdevlog.a112runtimeframelayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rl;
    Button b;
    FrameLayout frame1, frame2;
    TextView t1;
    RelativeLayout.LayoutParams param1, param2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.activity_main);

        b = (Button) findViewById(R.id.button1);

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                rl.removeViewInLayout(frame2);

                frame1 = new FrameLayout(MainActivity.this);

                param1 = new RelativeLayout.LayoutParams
                        (RelativeLayout.LayoutParams.WRAP_CONTENT,
                                RelativeLayout.LayoutParams.WRAP_CONTENT);

                param2 = new RelativeLayout.LayoutParams
                        (RelativeLayout.LayoutParams.WRAP_CONTENT,
                                RelativeLayout.LayoutParams.WRAP_CONTENT);

                t1 = new TextView(MainActivity.this);

                t1.setText("FrameLayout 1");
                t1.setTextSize(25);
                param1.setMargins(150, 350, 0, 0);
                t1.setLayoutParams(param1);

                param2.setMargins(100, 450, 0, 0);
                frame1.setLayoutParams(param2);

                frame1.addView(t1);

                rl.addView(frame1);
            }
        });

        b.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                rl.removeViewInLayout(frame1);

                frame2 = new FrameLayout(MainActivity.this);

                param1 = new RelativeLayout.LayoutParams
                        (RelativeLayout.LayoutParams.WRAP_CONTENT,
                                RelativeLayout.LayoutParams.WRAP_CONTENT);

                param2 = new RelativeLayout.LayoutParams
                        (RelativeLayout.LayoutParams.WRAP_CONTENT,
                                RelativeLayout.LayoutParams.WRAP_CONTENT);

                t1 = new TextView(MainActivity.this);

                t1.setText("FrameLayout 2");
                t1.setTextSize(25);
                param1.setMargins(150, 350, 0, 0);
                t1.setLayoutParams(param1);

                param2.setMargins(100, 450, 0, 0);
                frame2.setLayoutParams(param2);

                frame2.addView(t1);

                rl.addView(frame2);

                return true;
            }
        });
    }
}
