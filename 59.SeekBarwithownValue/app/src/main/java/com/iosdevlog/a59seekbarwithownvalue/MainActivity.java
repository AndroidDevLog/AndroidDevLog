package com.iosdevlog.a59seekbarwithownvalue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends AppCompatActivity {
    float discrete = 0;
    float start = 0;
    float end = 100;
    int start_position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start=-10;		//you need to give starting value of SeekBar
        end=10;			//you need to give end value of SeekBar

        SeekBar seek=(SeekBar) findViewById(R.id.seekBar1);
        seek.setProgress(start_position);
        seek.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getBaseContext(), "discrete = "+String.valueOf(discrete),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // To convert it as discrete value
                float temp=progress;
                float dis=end-start;
                discrete=(start+((temp/100)*dis));
            }
        });
    }
}
