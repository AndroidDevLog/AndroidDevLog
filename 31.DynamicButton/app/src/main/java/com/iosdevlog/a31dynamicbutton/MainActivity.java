package com.iosdevlog.a31dynamicbutton;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.view.ViewGroup.LayoutParams;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rl;
    Button b1, b2, b3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.activity_main);

        b1 = new Button(MainActivity.this);
        b2 = new Button (MainActivity.this);
        b3 = new Button (MainActivity.this);

        b1.setText("Java");
        b2.setText("Android");
        b3.setText("PHP");

        b2.setBackgroundColor(Color.MAGENTA);
        b3.setBackgroundColor(Color.rgb(65, 105, 225));

        b2.setTextColor(Color.WHITE);
        b3.setTextColor(Color.WHITE);

        RelativeLayout.LayoutParams params1=new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params1.leftMargin=190;
        params1.topMargin=100;

        RelativeLayout.LayoutParams params2=new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params2.leftMargin=175;
        params2.topMargin=300;

        RelativeLayout.LayoutParams params3=new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params3.leftMargin=190;
        params3.topMargin=500;

        b1.setLayoutParams(params1);
        b2.setLayoutParams(params2);
        b3.setLayoutParams(params3);

        rl.addView(b1);
        rl.addView(b2);
        rl.addView(b3);

        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Java Clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });

        b2.setOnLongClickListener(new View.OnLongClickListener() {

            public boolean onLongClick(View v) {
                Toast.makeText(getBaseContext(), "Android Long Clicked",
                        Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "PHP Clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });

        b3.setOnLongClickListener(new View.OnLongClickListener() {

            public boolean onLongClick(View v) {
                Toast.makeText(getBaseContext(), "PHP Long Clicked",
                        Toast.LENGTH_SHORT).show();

                return true;
            }
        });
    }
}
