package com.iosdevlog.a221collegenoticeboard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by iosdevlog on 2016/10/22.
 */


public class SampleCodez extends Activity {
    private static final String TAG = "SampleCodez";
    protected boolean active = true;
    protected int splashTime = 5000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.samplecodez);

        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;

                    while (active && (waited < splashTime)) {
                        sleep(40);
                        if (active) {
                            waited += 100;
                        }
                    }
                } catch (InterruptedException e) {
                    // do nothing
                    Log.e(TAG, "run: " + e.toString());
                } finally {
                    finish();
                    startActivity(new Intent(SampleCodez.this, NetConnection.class));
                }
            }
        };
        splashTread.start();
    }
}