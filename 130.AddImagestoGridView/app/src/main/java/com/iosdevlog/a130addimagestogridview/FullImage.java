package com.iosdevlog.a130addimagestogridview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by iosdevlog on 2016/10/18.
 */

public class FullImage extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full);

        // get intent data
        Intent i = getIntent();

        // Selected image id
        int position = i.getExtras().getInt("id");
        ImageAdapter imageAdapter = new ImageAdapter(this);

        ImageView imageView = (ImageView) findViewById(R.id.full_image_view);
        imageView.setImageResource(imageAdapter.mThumbIds[position]);
    }
}
