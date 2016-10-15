package com.iosdevlog.a70dynamicedittext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.RelativeLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rl;
    Button b;

    EditText et1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.activity_main);
        b = (Button) findViewById(R.id.button1);

        et1 = new EditText(MainActivity.this);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        params.leftMargin = 80;
        params.topMargin = 180;

        et1.setLayoutParams(params);

        et1.setHint("EditText");
        et1.setEms(10);

        rl.addView(et1);

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), et1.getText().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
