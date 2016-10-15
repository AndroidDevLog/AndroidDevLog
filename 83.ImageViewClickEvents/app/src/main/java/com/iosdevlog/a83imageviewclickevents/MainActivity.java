package com.iosdevlog.a83imageviewclickevents;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView img;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.imageView1);

        img.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                img.setImageResource(R.drawable.a2);
                Toast.makeText(getBaseContext(), "Image Clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });

        img.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                img.setImageResource(R.drawable.a3);
                Toast.makeText(getBaseContext(), "Image Long Clicked",
                        Toast.LENGTH_SHORT).show();

                return true;
            }
        });
    }
}
