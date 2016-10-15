package com.iosdevlog.a45morespinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner sp1, sp2, sp3;
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp1 = (Spinner) findViewById(R.id.spinner1);
        sp2 = (Spinner) findViewById(R.id.spinner2);
        sp3 = (Spinner) findViewById(R.id.spinner3);

        list = new ArrayList<>();
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");
        list.add("Item 4");
        list.add("Item 5");

        final String[] str1 = {"Report 1", "Report 2", "Report 3", "Report 4", "Report 5"};

        ArrayAdapter<String> adp1 = new ArrayAdapter<>
                (this, android.R.layout.simple_dropdown_item_1line, list);

        ArrayAdapter<String> adp2 = new ArrayAdapter<>
                (this, android.R.layout.simple_dropdown_item_1line, str1);

        ArrayAdapter<CharSequence> adp3 = ArrayAdapter.createFromResource
                (this, R.array.str2, android.R.layout.simple_dropdown_item_1line);

        sp1.setAdapter(adp1);
        sp2.setAdapter(adp2);
        sp3.setAdapter(adp3);

        sp1.setOnItemSelectedListener(new OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                Toast.makeText(getBaseContext(), list.get(arg2),
                        Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        sp2.setOnItemSelectedListener(new OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                Toast.makeText(getBaseContext(), str1[arg2],
                        Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        sp3.setOnItemSelectedListener(new OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                String item = sp3.getSelectedItem().toString();
                Toast.makeText(getBaseContext(), item, Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }
}
