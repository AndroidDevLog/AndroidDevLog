package com.iosdevlog.a98staticanalogclock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AnalogClock clk;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clk = (AnalogClock) findViewById(R.id.analogClock1);

        clk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "This is Static AnalogClock",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

}
