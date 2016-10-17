package com.iosdevlog.a118runtimeadditemtolistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> li;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        li = new ArrayList<>();
        li.add("List 1");
        li.add("List 2");
        li.add("List 3");

        final Button show = (Button) findViewById(R.id.button1);
        final EditText et = (EditText) findViewById(R.id.editText1);
        list = (ListView) findViewById(R.id.listView1);

        add();

        show.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                li.add(et.getText().toString());
                et.setText(null);
                add();
            }
        });
    }

    public void add() {
        ArrayAdapter<String> adp = new ArrayAdapter<>
                (getBaseContext(), R.layout.list, li);
        list.setAdapter(adp);
    }
}
