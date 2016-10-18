package com.iosdevlog.a156staticviewstub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ViewStub stub;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        stub = (ViewStub) findViewById(R.id.viewStub1);
//        View inflated = stub.inflate();

        b = (Button) findViewById(R.id.button1);

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Toast.makeText(getBaseContext(), "View Stub Content Created !!!",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
