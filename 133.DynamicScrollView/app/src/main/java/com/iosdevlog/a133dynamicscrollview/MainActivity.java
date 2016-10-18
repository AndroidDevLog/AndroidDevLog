package com.iosdevlog.a133dynamicscrollview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.view.ViewGroup.LayoutParams;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rl1, rl2;
    ScrollView sv;
    Button[] b;
    int sum = 30;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl1 = (RelativeLayout) findViewById(R.id.activity_main);
        sv = new ScrollView(MainActivity.this);
        rl2 = new RelativeLayout(MainActivity.this);
        b = new Button[20];

        for (int i = 1; i < 15; i++) {
            b[i] = new Button(this);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params.leftMargin = 50;
            params.topMargin = sum;
            b[i].setText("Button " + i);
            b[i].setLayoutParams(params);
            rl2.addView(b[i]);
            sum = sum + 300;
        }

        sv.addView(rl2);
        rl1.addView(sv);
    }
}
