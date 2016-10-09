package com.iosdevlog.a23launchmode_singletop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "singleTap";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: " + this.toString());
    }

    public void newMainActivity(View view) {
        Log.d(TAG, "MainActivity: " + this.toString() + " start New Main Activity");
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void newDetailActivity(View view) {
        Log.d(TAG, "MainActivity: " + this.toString() + " start Detail Activity");
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        startActivity(intent);
    }
}
