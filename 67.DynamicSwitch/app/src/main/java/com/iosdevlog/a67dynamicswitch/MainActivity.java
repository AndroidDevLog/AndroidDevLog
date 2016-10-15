package com.iosdevlog.a67dynamicswitch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.RelativeLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rl;
    Switch switch_controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rl = (RelativeLayout) findViewById(R.id.activity_main);
        switch_controller = new Switch(MainActivity.this);
        switch_controller.setText("Switch");

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        switch_controller.setLayoutParams(params);

        rl.addView(switch_controller);

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
