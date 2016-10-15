package com.iosdevlog.a75dynamicautocompletetextview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rl;
    AutoCompleteTextView auto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String str[] = {"Arun", "Mathev", "Vishnu", "Vishal", "Arjun",
                "Arul", "Balaji", "Babu", "Boopathy", "Godwin", "Nagaraj"};

        rl = (RelativeLayout) findViewById(R.id.activity_main);

        auto = new AutoCompleteTextView(MainActivity.this);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        params.leftMargin = 80;
        params.topMargin = 200;

        auto.setLayoutParams(params);
        auto.setEms(10);

        ArrayAdapter<String> adp = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, str);

        auto.setThreshold(1);
        auto.setAdapter(adp);

        rl.addView(auto);
    }
}
