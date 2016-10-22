package com.iosdevlog.a219bindanactivitytoaservice;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Button start, stop;
    IntentFilter intentFilter;

    private MyService serviceBinder;
    Intent i;

    private ServiceConnection connection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            //---called when the connection is made---
            serviceBinder = ((MyService.MyBinder) service).getService();
            try {
                URL[] urls = new URL[]{
                        new URL("http://www.amazon.com/somefiles.pdf"),
                        new URL("http://www.wrox.com/somefiles.pdf"),
                        new URL("http://www.google.com/somefiles.pdf"),
                        new URL("http://www.learn2develop.net/somefiles.pdf")};
                //---assign the URLs to the service through the serviceBinder object---
                serviceBinder.urls = urls;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            startService(i);
        }

        public void onServiceDisconnected(ComponentName className) {
            //---called when the service disconnects---
            serviceBinder = null;
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intentFilter = new IntentFilter();
        intentFilter.addAction("FILE_DOWNLOADED_ACTION");

        registerReceiver(intentReceiver, intentFilter);

        start = (Button) findViewById(R.id.button1);
        stop = (Button) findViewById(R.id.button2);

        start.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                i = new Intent(MainActivity.this, MyService.class);
                bindService(i, connection, Context.BIND_AUTO_CREATE);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                stopService(new Intent(getBaseContext(), MyService.class));
            }
        });
    }

    private BroadcastReceiver intentReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(getBaseContext(), "File downloaded!",
                    Toast.LENGTH_LONG).show();
        }
    };

}
