package com.iosdevlog.a127dynamicgridview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rl;
    GridView grid;
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.activity_main);
        grid = new GridView(MainActivity.this);
        list = new ArrayList<>();

        list.add("Dynamic 1");
        list.add("Dynamic 2");
        list.add("Dynamic 3");
        list.add("Dynamic 4");
        list.add("Dynamic 5");
        list.add("Dynamic 6");
        list.add("Dynamic 7");
        list.add("Dynamic 8");
        list.add("Dynamic 9");

        ArrayAdapter<String> adp = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, list);
        grid.setNumColumns(3);
        grid.setBackgroundColor(Color.BLUE);
        grid.setAdapter(adp);
        rl.addView(grid);

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
