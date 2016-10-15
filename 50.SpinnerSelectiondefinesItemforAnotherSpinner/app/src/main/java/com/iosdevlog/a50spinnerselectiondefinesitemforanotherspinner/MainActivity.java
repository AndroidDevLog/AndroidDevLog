package com.iosdevlog.a50spinnerselectiondefinesitemforanotherspinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner sp1, sp2;
    ArrayAdapter<String> adp1, adp2;
    List<String> l1, l2;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l1 = new ArrayList<>();

        l1.add("A");
        l1.add("B");

        sp1 = (Spinner) findViewById(R.id.spinner1);
        sp2 = (Spinner) findViewById(R.id.spinner2);

        adp1 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, l1);
        adp1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp1.setAdapter(adp1);

        sp1.setOnItemSelectedListener(new OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                pos = arg2;

                add();
            }

            private void add() {
                switch (pos) {
                    case 0:
                        l2 = new ArrayList<>();
                        l2.add("A 1");
                        l2.add("A 2");

                        adp2 = new ArrayAdapter<>(MainActivity.this,
                                android.R.layout.simple_dropdown_item_1line, l2);
                        sp2.setAdapter(adp2);

                        select();

                        break;

                    case 1:
                        l2 = new ArrayList<>();
                        l2.add("B 1");
                        l2.add("B 2");

                        adp2 = new ArrayAdapter<>(MainActivity.this,
                                android.R.layout.simple_dropdown_item_1line, l2);
                        sp2.setAdapter(adp2);

                        select();

                        break;
                }
            }

            private void select() {
                sp2.setOnItemSelectedListener(new OnItemSelectedListener() {

                    public void onItemSelected(AdapterView<?> arg0, View arg1,
                                               int arg2, long arg3) {
                        Toast.makeText(getBaseContext(), l2.get(arg2),
                                Toast.LENGTH_SHORT).show();
                    }

                    public void onNothingSelected(AdapterView<?> arg0) {
                    }
                });
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }
}
