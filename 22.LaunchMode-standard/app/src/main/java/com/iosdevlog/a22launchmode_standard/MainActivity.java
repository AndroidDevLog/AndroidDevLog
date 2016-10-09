package com.iosdevlog.a22launchmode_standard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: " + this.toString());
    }

    public void newActivity(View view) {
        Log.d(TAG, "newActivity: " + this.toString() + " start New Activity");
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
