package com.iosdevlog.a42resetradiobuttons;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton rb;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rb = (RadioButton) findViewById(R.id.radioButton1);

        b = (Button) findViewById(R.id.button1);

        b.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                rb.setChecked(false);
                Toast.makeText(getBaseContext(), "Reseted",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
