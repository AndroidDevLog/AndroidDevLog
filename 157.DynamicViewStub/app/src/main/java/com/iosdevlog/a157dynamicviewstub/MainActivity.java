package com.iosdevlog.a157dynamicviewstub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.view.ViewGroup.LayoutParams;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rl;
    ViewStub stub;
    Button b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.activity_main);

        stub = new ViewStub(MainActivity.this);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.topMargin = 100;

        stub.setLayoutParams(params);

        rl.addView(stub);

        stub.setLayoutResource(R.layout.subtree);

        View inflated = stub.inflate();

        b = (Button) findViewById(R.id.button1);

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "View Stub Content Created !!!",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
