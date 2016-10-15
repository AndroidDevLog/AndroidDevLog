package com.iosdevlog.a79gettextfrommultiautocompletetextview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MultiAutoCompleteTextView multi;
    Button Get;
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        list.add("Selva");
        list.add("JP");
        list.add("Pons");
        list.add("Boopathy");
        list.add("God");
        list.add("Deepan");
        list.add("Siva");
        list.add("Karthik");

        multi = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView1);
        Get = (Button) findViewById(R.id.button1);

        ArrayAdapter<String> adp = new ArrayAdapter<>
                (this, android.R.layout.simple_dropdown_item_1line, list);

        multi.setAdapter(adp);

        multi.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        multi.setThreshold(1);

        Get.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String[] str = multi.getText().toString().split(", ");

                for (int i = 0; i < str.length; i++) {
                    Toast.makeText(MainActivity.this, str[i], Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
