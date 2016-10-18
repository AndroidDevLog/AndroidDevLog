package com.iosdevlog.a162dynamicsurfaceview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RelativeLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rl;
    SurfaceView sv;
    Button b;
    TextView tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.rl);
        sv = new SurfaceView(MainActivity.this);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.topMargin = 40;

        sv.setLayoutParams(params);
        sv.setBackgroundColor(Color.LTGRAY);

        tv = new TextView(MainActivity.this);
        b = new Button(MainActivity.this);

        tv.setText("TextView");
        b.setText("Button");

        RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        params1.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params2.addRule(RelativeLayout.CENTER_IN_PARENT);

        params1.topMargin = 75;

        tv.setLayoutParams(params1);
        b.setLayoutParams(params2);

        rl.addView(sv);
        rl.addView(tv);
        rl.addView(b);

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Cool Buddy",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
