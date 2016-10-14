package com.iosdevlog.a33customstaticbutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button custom_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        custom_button = (Button) findViewById(R.id.button1);

        custom_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                custom_button.setBackgroundResource(R.drawable.button_clicked);
                Toast.makeText(getBaseContext(), "Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
