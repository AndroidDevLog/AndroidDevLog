package com.iosdevlog.a30staticbutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1, b2, b3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);

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
