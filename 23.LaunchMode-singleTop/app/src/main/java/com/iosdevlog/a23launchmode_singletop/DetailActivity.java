package com.iosdevlog.a23launchmode_singletop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class DetailActivity extends AppCompatActivity {
    private static final String TAG = "singleTap";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Log.d(TAG, "onCreate: " + this.toString());
    }

    public void newActivity(View view) {
        Log.d(TAG, "MainActivity: " + this.toString() + " start New Activity");
        Intent intent = new Intent(DetailActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
