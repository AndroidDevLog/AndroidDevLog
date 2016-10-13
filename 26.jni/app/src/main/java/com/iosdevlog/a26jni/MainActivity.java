package com.iosdevlog.a26jni;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Jni jniUtils = new Jni();
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(jniUtils.getJniString());
    }
}
