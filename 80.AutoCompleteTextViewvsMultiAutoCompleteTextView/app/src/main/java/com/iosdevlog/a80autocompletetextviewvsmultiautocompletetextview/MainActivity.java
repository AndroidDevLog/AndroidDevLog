package com.iosdevlog.a80autocompletetextviewvsmultiautocompletetextview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		/*AutoCompleteTextView*/

        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.autoCompleteTextView1);

        String[] days= new String[]{"Monday","Tuesday",
                "Wednesday","Thursday","Friday","Saturday","Sunday"};

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, days);

        textView.setThreshold(1);
        textView.setAdapter(adapter1);

		/*MultiAutoCompleteTextView*/

        MultiAutoCompleteTextView textView1 = (MultiAutoCompleteTextView)
                findViewById(R.id.multiAutoCompleteTextView1);

        textView1.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        String[] friends= new String[]{"Balaji","Nagaraj","Ponnaiah",
                "Selva","JP","Boopathy","Naveen","Arul",
                "Godwin","Vinoth","Pradeep","Deepan"};

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, friends);

        textView1.setThreshold(1);
        textView1.setAdapter(adapter2);
    }
}
