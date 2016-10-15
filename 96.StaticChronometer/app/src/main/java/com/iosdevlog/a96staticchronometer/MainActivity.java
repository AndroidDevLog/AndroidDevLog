package com.iosdevlog.a96staticchronometer;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    Chronometer focus;
    Button start, stop, restart, set, clear;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.button1);
        stop = (Button) findViewById(R.id.button2);
        restart = (Button) findViewById(R.id.button3);
        set = (Button) findViewById(R.id.button4);
        clear = (Button) findViewById(R.id.button5);

        focus = (Chronometer) findViewById(R.id.chronometer1);

        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                focus.start();
            }
        });


        stop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                focus.stop();
            }
        });


        restart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                focus.setBase(SystemClock.elapsedRealtime());
            }
        });


        set.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                focus.setFormat("Formated Time - %s");
            }
        });


        clear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                focus.setFormat(null);
            }
        });
    }
}
