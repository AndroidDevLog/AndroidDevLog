package com.iosdevlog.a77multiautocompletetextview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] str = {"Andoid", "Jelly Bean", "Froyo",
                "Ginger Bread", "Eclipse Indigo", "Eclipse Juno"};

        MultiAutoCompleteTextView mt = (MultiAutoCompleteTextView)
                findViewById(R.id.multiAutoCompleteTextView1);

        mt.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        ArrayAdapter<String> adp = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, str);

        mt.setThreshold(1);
        mt.setAdapter(adp);
    }
}
