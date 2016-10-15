package com.iosdevlog.a58captureseekbarvalue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int pro = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar sk = (SeekBar) findViewById(R.id.seekBar1);

        sk.setMax(50);

        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                pro = progress;    //we can use the progress value of pro as anywhere
                Toast.makeText(getBaseContext(), String.valueOf(progress),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
