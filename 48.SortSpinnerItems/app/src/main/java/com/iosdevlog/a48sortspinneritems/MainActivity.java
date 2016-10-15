package com.iosdevlog.a48sortspinneritems;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int position=0;
    String val=null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner sp=(Spinner) findViewById(R.id.spinner1);

        final List<String> list=new ArrayList<String>();

        list.add("A");
        list.add("V");
        list.add("Z");
        list.add("S");
        list.add("F");
        list.add("Q");
        list.add("E");
        list.add("G");
        list.add("H");
        list.add("K");

        // Sort List Items
        Collections.sort(list);

        final ArrayAdapter<String> adp= new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,list);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adp);

        sp.setOnItemSelectedListener(new OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int pos, long arg3) {
                position=pos;
                val=sp.getSelectedItem().toString();
                // You can insert your code...
                Toast.makeText(MainActivity.this, val, Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }
}
