package com.iosdevlog.a155dynamicview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rl;
    TextView tv;
    View line1, line2, line3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.activity_main);
        tv = (TextView) findViewById(R.id.textView2);

        line1 = new View(MainActivity.this);
        line2 = new View(MainActivity.this);
        line3 = new View(MainActivity.this);

        RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams
                (LayoutParams.MATCH_PARENT, 3);

        RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams
                (LayoutParams.MATCH_PARENT, 8);

        RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams
                (LayoutParams.MATCH_PARENT, 3);

        params1.topMargin = 10;

        params2.addRule(RelativeLayout.CENTER_IN_PARENT);

        params3.topMargin = 100;

        line1.setLayoutParams(params1);
        line1.setBackgroundColor(Color.MAGENTA);

        line2.setLayoutParams(params2);
        line2.setBackgroundColor(Color.RED);

        line3.setLayoutParams(params3);
        line3.setBackgroundColor(Color.BLUE);

        rl.addView(line1);
        rl.addView(line2);
        rl.addView(line3);

        line2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                tv.setText("Line 2 Clicked !!!");
            }
        });

    }
}
