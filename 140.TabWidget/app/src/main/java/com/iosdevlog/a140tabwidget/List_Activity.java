package com.iosdevlog.a140tabwidget;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

/**
 * Created by iosdevlog on 2016/10/18.
 */

public abstract class List_Activity extends Activity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ArrayAdapter<String> adp = new ArrayAdapter<>(this,
                R.layout.list_item, R.id.demo);

        for (int i = 0; i < 15; i++) {
            adp.add(getName() + " : " + i);
        }
        setContentView(R.layout.list_view);
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adp);

        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                Toast.makeText(getApplicationContext(), adp.getItem(arg2),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public abstract String getName();
}
