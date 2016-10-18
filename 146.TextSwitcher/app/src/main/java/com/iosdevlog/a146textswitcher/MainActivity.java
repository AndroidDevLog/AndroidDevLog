package com.iosdevlog.a146textswitcher;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory,
        View.OnClickListener {

    TextSwitcher switcher;
    float counter = 0;
    Button Add, Subtract, Multiple, Divide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switcher = (TextSwitcher) findViewById(R.id.switcher);
        switcher.setFactory(MainActivity.this);

        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);

        switcher.setInAnimation(in);
        switcher.setOutAnimation(out);

        Add = (Button) findViewById(R.id.Add);
        Subtract = (Button) findViewById(R.id.Subtract);
        Multiple = (Button) findViewById(R.id.Multiple);
        Divide = (Button) findViewById(R.id.Divide);

        Add.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                counter++;
                switcher.setText(String.valueOf(counter));
            }
        });

        Subtract.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                counter--;
                switcher.setText(String.valueOf(counter));
            }
        });

        Multiple.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                counter = counter * 2;
                switcher.setText(String.valueOf(counter));
            }
        });

        Divide.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                counter = counter / 2;
                switcher.setText(String.valueOf(counter));
            }
        });
    }

    public View makeView() {
        TextView t = new TextView(this);
        t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
        t.setTextSize(36);
        return t;
    }

    public void onClick(View v) {
        Toast.makeText(this, v.toString(), Toast.LENGTH_SHORT).show();
    }
}
