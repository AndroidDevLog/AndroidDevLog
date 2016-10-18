package com.iosdevlog.a130addimagestogridview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.activity_main);

        // Instance of ImageAdapter Class
        gridView.setAdapter(new ImageAdapter(this));

        // On Click event for Single Gridview Item

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                // Sending image id to FullScreenActivity
                Intent i = new Intent(getApplicationContext(), FullImage.class);
                // passing array index
                i.putExtra("id", position);
                startActivity(i);
            }
        });
    }
}
