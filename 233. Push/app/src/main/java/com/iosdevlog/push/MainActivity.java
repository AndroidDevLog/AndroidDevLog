package com.iosdevlog.push;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);

        String token = FirebaseInstanceId.getInstance().getToken();
        //Log the token
        Log.d(TAG, "token: " + token);
        textView.setText(token);
    }

    @Override
    protected void onResume() {
        super.onResume();

        textView.setText("MainActivity onResume");
    }
}
