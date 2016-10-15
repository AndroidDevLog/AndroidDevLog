package com.iosdevlog.a106dynamicrelativelayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rl;
    RelativeLayout.LayoutParams param1, param2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rl = new RelativeLayout(MainActivity.this);

        param1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        param2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        param1.leftMargin = 100;
        param1.topMargin = 100;

        param2.setMargins(170, 200, 0, 0);

        TextView t1 = new TextView(MainActivity.this);
        t1.setText("Dynamic RelativeLayout");
        t1.setTextSize(17);
        t1.setTextColor(Color.MAGENTA);
        t1.setLayoutParams(param1);

        Button b = new Button (MainActivity.this);
        b.setText("Android");
        b.setTextSize(17);
        b.setTextColor(Color.BLUE);
        b.setLayoutParams(param2);

        rl.addView(t1);
        rl.addView(b);

        setContentView(rl);
    }

}
