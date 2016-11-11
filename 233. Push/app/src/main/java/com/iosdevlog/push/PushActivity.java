package com.iosdevlog.push;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class PushActivity extends AppCompatActivity {
    private TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push);

        textView = (TextView)findViewById(R.id.textView);
        textView.setText("Welcome to the Result Activity");
    }

    @Override
    protected void onResume() {
        super.onResume();

        textView.setText("PushActivity onResume");
    }
}
