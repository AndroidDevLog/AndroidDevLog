package com.iosdevlog.a125removelistitems;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        list.add("AAAA");
        list.add("BBBB");
        list.add("CCCC");
        list.add("DDDD");
        list.add("EEEE");

        Button b = (Button) findViewById(R.id.button1);

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (list.size() <= 2) {
                    return;
                }
                list.remove(2);
                for (int i = 0; i < list.size(); i++) {
                    Toast.makeText(getBaseContext(), list.get(i),
                            Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getBaseContext(), "Size : " + list.size(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
