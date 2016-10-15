package com.iosdevlog.a84staticimagebutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton imgbutton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgbutton  = (ImageButton) findViewById(R.id.imageButton1);

        imgbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                imgbutton.setImageResource(R.drawable.a2);
                Toast.makeText(getBaseContext(), "ImageButton Clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });

        imgbutton.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                imgbutton.setImageResource(R.drawable.a3);
                Toast.makeText(getBaseContext(), "ImageButton Long Clicked",
                        Toast.LENGTH_SHORT).show();

                return true;
            }
        });
    }

}
