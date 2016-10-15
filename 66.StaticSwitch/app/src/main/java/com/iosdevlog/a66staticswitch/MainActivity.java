package com.iosdevlog.a66staticswitch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Switch switch_controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switch_controller = (Switch) findViewById(R.id.switch1);

        switch_controller.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true)
                    Toast.makeText(getBaseContext(), "ON Stage", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getBaseContext(), "OFF Stage", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
