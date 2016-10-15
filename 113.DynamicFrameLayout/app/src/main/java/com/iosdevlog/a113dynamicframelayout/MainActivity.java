package com.iosdevlog.a113dynamicframelayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rl;
    FrameLayout fl;
    TextView t1;
    ImageView img;
    RelativeLayout.LayoutParams param1, param2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.activity_main);
        fl = new FrameLayout(MainActivity.this);

        param1 = new RelativeLayout.LayoutParams
                ((int) RelativeLayout.LayoutParams.WRAP_CONTENT,
                        (int) RelativeLayout.LayoutParams.WRAP_CONTENT);

        param2 = new RelativeLayout.LayoutParams
                ((int) RelativeLayout.LayoutParams.WRAP_CONTENT,
                        (int) RelativeLayout.LayoutParams.WRAP_CONTENT);

        t1 = new TextView(MainActivity.this);
        img = new ImageView(MainActivity.this);

        t1.setText("Jelly Bean");
        t1.setTextSize(25);
        param1.setMargins(150, 50, 0, 0);
        t1.setLayoutParams(param1);

        param2.setMargins(0, 50, 0, 0);
        fl.setLayoutParams(param2);

        img.setImageResource(R.drawable.jelly);
        img.setLayoutParams(new LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        fl.addView(img);

        rl.addView(t1);
        rl.addView(fl);
    }
}
