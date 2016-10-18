package com.iosdevlog.a158moreviewstubs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rl;
    ViewStub stub1, stub2;
    Button b1, b2;
    View inflated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.activity_main);

        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);

        stub1 = (ViewStub) findViewById(R.id.viewStub1);
        stub2 = (ViewStub) findViewById(R.id.viewStub2);

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                inflated = stub1.inflate();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                inflated = stub2.inflate();
            }
        });
    }
}
