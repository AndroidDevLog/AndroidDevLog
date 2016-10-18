package com.iosdevlog.a140tabwidget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button first = (Button) findViewById(R.id.button1);
        final Button second = (Button) findViewById(R.id.button2);

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final Intent i = new Intent(MainActivity.this, First.class);
                MainActivity.this.startActivity(i);
            }
        });

        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final Intent i = new Intent(MainActivity.this, Second.class);
                MainActivity.this.startActivity(i);
            }
        });
    }
}
