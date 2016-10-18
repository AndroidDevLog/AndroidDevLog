package com.iosdevlog.a128gridviewcreationbymoreways;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    GridView grid1, grid2, grid3;
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        grid1 = (GridView) findViewById(R.id.gridView1);
        grid2 = (GridView) findViewById(R.id.gridView2);
        grid3 = (GridView) findViewById(R.id.gridView3);

        list = new ArrayList<>();
        list.add("Grid 7");
        list.add("Grid 8");
        list.add("Grid 9");
        list.add("Grid 10");
        list.add("Grid 11");
        list.add("Grid 12");

        final String[] str2 =
                {
                        "Grid 13",
                        "Grid 14",
                        "Grid 15",
                        "Grid 16",
                        "Grid 17",
                        "Grid 18"
                };

        final ArrayAdapter<CharSequence> adp1 = ArrayAdapter.createFromResource(this,
                R.array.str1, android.R.layout.simple_dropdown_item_1line);
        grid1.setAdapter(adp1);

        ArrayAdapter<String> adp2 = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, list);
        grid2.setAdapter(adp2);

        ArrayAdapter<String> adp = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, str2);
        grid3.setAdapter(adp);

        grid1.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(getBaseContext(), adp1.getItem(arg2),
                        Toast.LENGTH_SHORT).show();
            }
        });

        grid2.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(getBaseContext(), list.get(arg2),
                        Toast.LENGTH_SHORT).show();
            }
        });

        grid2.setOnItemLongClickListener(new OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(getBaseContext(), list.get(arg2),
                        Toast.LENGTH_SHORT).show();

                // If You return false it will obey the both
                //setOnItemClickListener and setOnItemLongClickListener
                //Otherwise it only for setOnItemLongClickListener..

                return true;
            }
        });

        grid3.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(getBaseContext(), str2[arg2],
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
