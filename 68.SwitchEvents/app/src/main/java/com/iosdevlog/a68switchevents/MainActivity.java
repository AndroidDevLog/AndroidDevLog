package com.iosdevlog.a68switchevents;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rl;
    Switch switch_controll;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rl = (RelativeLayout) findViewById(R.id.activity_main);
        switch_controll = (Switch) findViewById(R.id.switch1);
        image = new ImageView(MainActivity.this);

        image.setImageResource(R.drawable.ic_launcher);
        RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        param.addRule(RelativeLayout.CENTER_IN_PARENT);
        image.setLayoutParams(param);

        switch_controll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true)
                    rl.addView(image);
                else
                    rl.removeView(image);
            }
        });
    }
}
