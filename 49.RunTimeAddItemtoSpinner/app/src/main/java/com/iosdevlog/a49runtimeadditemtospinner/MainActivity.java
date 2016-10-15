package com.iosdevlog.a49runtimeadditemtospinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner sp;
    EditText et;
    List<String> li;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        li = new ArrayList<>();
        li.add("Item 1");
        li.add("Item 2");
        li.add("Item 3");

        sp = (Spinner) findViewById(R.id.spinner1);
        Button b = (Button) findViewById(R.id.button1);
        et = (EditText) findViewById(R.id.editText1);

        add();

        b.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                li.add(et.getText().toString());
                et.setText(null);
                add();
            }
        });
    }

    private void add() {
        ArrayAdapter<String> adp = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, li);
        sp.setAdapter(adp);
    }
}
