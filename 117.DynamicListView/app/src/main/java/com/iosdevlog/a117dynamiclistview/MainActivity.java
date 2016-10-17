package com.iosdevlog.a117dynamiclistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> li;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.activity_main);
        final RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.leftMargin = 10;
        params.topMargin = 350;

        Button show = (Button) findViewById(R.id.button1);
        final ListView list = new ListView(this);

        li = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            li.add("List " + i);
        }

        show.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ArrayAdapter<String> adp = new ArrayAdapter<>(getBaseContext(),
                        android.R.layout.simple_dropdown_item_1line, li);
                adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

                list.setAdapter(adp);
                list.setLayoutParams(params);

                rl.addView(list);
            }
        });
    }
}
