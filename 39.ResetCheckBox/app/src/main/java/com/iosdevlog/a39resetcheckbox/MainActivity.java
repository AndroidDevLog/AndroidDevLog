package com.iosdevlog.a39resetcheckbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    CheckBox c1, c2, c3;
    Button reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c1 = (CheckBox) findViewById(R.id.checkBox1);
        c2 = (CheckBox) findViewById(R.id.checkBox2);
        c3 = (CheckBox) findViewById(R.id.checkBox3);

        reset = (Button) findViewById(R.id.button1);

        reset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                c1.setChecked(false);
                c2.setChecked(false);
                c3.setChecked(false);
            }
        });
    }
}
