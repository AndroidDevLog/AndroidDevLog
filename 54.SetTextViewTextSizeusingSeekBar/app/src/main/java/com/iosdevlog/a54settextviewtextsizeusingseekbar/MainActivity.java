package com.iosdevlog.a54settextviewtextsizeusingseekbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView t1 = (TextView) findViewById(R.id.textView1);
        final SeekBar sk = (SeekBar) findViewById(R.id.seekBar1);

        sk.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int p = 0;

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (p < 30) {
                    p = 30;
                    sk.setProgress(p);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                p = progress;
                t1.setTextSize(p);
            }
        });
    }
}
