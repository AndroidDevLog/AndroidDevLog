package com.iosdevlog.a25launchmode_singleinstance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SingleInstanceActivity extends AppCompatActivity {
    private static final String TAG = "singleInstance";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_instance);

        Log.d(TAG, "onCreate: " + this.toString() + " Task id is " + getTaskId());
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d(TAG, "onRestart: " + this.toString() + " Task id is " + getTaskId());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy: " + this.toString() + " Task id is " + getTaskId());
    }

    public void onClick(View view) {
        Intent intent = new Intent(SingleInstanceActivity.this,
                DetailActivity.class);
        startActivity(intent);
    }
}
