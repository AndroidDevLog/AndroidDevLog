package com.iosdevlog.a129runtimeadditemtogridview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    GridView grid;
    Button add;
    EditText et;
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");
        list.add("Item 4");

        grid = (GridView) findViewById(R.id.gridView1);
        et = (EditText) findViewById(R.id.editText1);
        add = (Button) findViewById(R.id.button1);
        add();

        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                list.add(et.getText().toString());
                add();
            }
        });
    }

    public void add() {
        ArrayAdapter<String> adp = new ArrayAdapter<>(getBaseContext(),
                android.R.layout.simple_dropdown_item_1line, list);
        grid.setAdapter(adp);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                Toast.makeText(getBaseContext(), list.get(arg2),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
