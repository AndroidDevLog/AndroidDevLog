package com.iosdevlog.a27textview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv1, tv2, tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.textView1);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);

        tv1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Static TextView Clicked",
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
