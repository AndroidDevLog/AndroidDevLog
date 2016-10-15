package com.iosdevlog.a100staticdigitalclock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DigitalClock;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DigitalClock clk;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clk = (DigitalClock) findViewById(R.id.digitalClock1);

        clk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), clk.getText().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
