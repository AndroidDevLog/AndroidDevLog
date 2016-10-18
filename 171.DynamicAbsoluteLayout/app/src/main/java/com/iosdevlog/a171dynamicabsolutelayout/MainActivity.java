package com.iosdevlog.a171dynamicabsolutelayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AbsoluteLayout abs;
    AbsoluteLayout.LayoutParams param1, param2;
    TextView[] tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        abs = new AbsoluteLayout (MainActivity.this);

        param1 = new AbsoluteLayout.LayoutParams(300, 150, 100, 150);

        param2 = new AbsoluteLayout.LayoutParams(300, 150, 100, 300);

        TextView t1 = new TextView(MainActivity.this);
        t1.setText("Dynamic AbsoluteLayout");
        t1.setTextSize(17);
        t1.setTextColor(Color.MAGENTA);
        t1.setLayoutParams(param1);

        Button b = new Button (MainActivity.this);
        b.setText("Android");
        b.setTextSize(17);
        b.setTextColor(Color.BLUE);
        b.setLayoutParams(param2);

        abs.addView(t1);
        abs.addView(b);

        setContentView(abs);

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Success !!!",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
