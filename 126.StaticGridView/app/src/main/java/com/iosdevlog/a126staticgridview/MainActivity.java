package com.iosdevlog.a126staticgridview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> list;
    GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        grid = (GridView) findViewById(R.id.activity_main);

        list.add("Grid 1");
        list.add("Grid 2");
        list.add("Grid 3");
        list.add("Grid 4");
        list.add("Grid 5");
        list.add("Grid 6");
        list.add("Grid 7");
        list.add("Grid 8");
        list.add("Grid 9");

        ArrayAdapter<String> adp = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, list);
        grid.setAdapter(adp);

        grid.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                Toast.makeText(getBaseContext(), list.get(arg2),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
