package com.iosdevlog.a218invokeanactivityfromaservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button start, stop;
    IntentFilter intentFilter;


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
                startService(new Intent(getBaseContext(), MyIntentService.class));
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
