package com.iosdevlog.a51spinnersfromedittext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> li;
    Spinner sp1, sp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        li = new ArrayList<>();

        li.add("Data 1");
        li.add("Data 2");

        sp1 = (Spinner) findViewById(R.id.spinner1);
        sp2 = (Spinner) findViewById(R.id.spinner2);
        Button b = (Button) findViewById(R.id.button1);
        final EditText et = (EditText) findViewById(R.id.editText1);

        call();

        b.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                li.add(et.getText().toString());
                et.setText(null);
                call();
            }
        });
    }

    public void call() {
        ArrayAdapter<String> adp = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, li);
        sp1.setAdapter(adp);
        sp2.setAdapter(adp);
        sp1.setSelection((li.size() - 1));

        sp1.setOnItemSelectedListener(new OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                sp2.setSelection(arg2);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

    }
}
