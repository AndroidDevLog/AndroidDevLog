package com.iosdevlog.a28textviewcode;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.ViewGroup.LayoutParams;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rl;
    TextView tv1, tv2, tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.activity_main);

        tv1 = new TextView (MainActivity.this);
        tv2 = new TextView (MainActivity.this);
        tv3 = new TextView (MainActivity.this);

        tv1.setText("Dynamic TextView");
        tv2.setText("Java");
        tv3.setText("Android");

        tv1.setTextColor(Color.RED);
        tv2.setTextColor(Color.MAGENTA);
        tv3.setTextColor(Color.BLUE);

        tv1.setTextSize(20);
        tv2.setTextSize(20);
        tv3.setTextSize(20);

        RelativeLayout.LayoutParams params1=new RelativeLayout.LayoutParams
                ( RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params1.leftMargin=115;
        params1.topMargin=120;

        RelativeLayout.LayoutParams params2=new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        params2.leftMargin=190;
        params2.topMargin=190;

        RelativeLayout.LayoutParams params3=new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        params3.leftMargin=170;
        params3.topMargin=260;

        tv1.setLayoutParams(params1);
        tv2.setLayoutParams(params2);
        tv3.setLayoutParams(params3);

        rl.addView(tv1);
        rl.addView(tv2);
        rl.addView(tv3);

        tv1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Dynamic TextView Clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });

        tv2.setOnLongClickListener(new View.OnLongClickListener() {

            public boolean onLongClick(View v) {
                Toast.makeText(getBaseContext(), "Java Long Clicked",
                        Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        tv3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Android Clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });

        tv3.setOnLongClickListener(new View.OnLongClickListener() {

            public boolean onLongClick(View v) {
                Toast.makeText(getBaseContext(), "Android Long Clicked",
                        Toast.LENGTH_SHORT).show();

                return true;
            }
        });
    }
}
