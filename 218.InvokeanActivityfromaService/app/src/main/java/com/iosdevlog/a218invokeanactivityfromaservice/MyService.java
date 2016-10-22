package com.iosdevlog.a218invokeanactivityfromaservice;

import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
import android.app.Service;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by iosdevlog on 2016/10/22.
 */

public class MyService extends Service {
    int counter = 0;
    static final int UPDATE_INTERVAL = 1000;
    private Timer timer = new Timer();

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(getBaseContext(), "Service Started",
                Toast.LENGTH_SHORT).show();

        Repeate();
        return START_STICKY;
    }

    private void Repeate() {
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                Log.d("MyService", String.valueOf(++counter));
            }
        }, 0, UPDATE_INTERVAL);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
        }
        Toast.makeText(getBaseContext(), "Service Destroyed",
                Toast.LENGTH_SHORT).show();
    }
}