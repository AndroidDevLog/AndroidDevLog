package com.iosdevlog.a149flipper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    ViewFlipper viewFlipper;
    Button Next, Previous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewFlipper = (ViewFlipper) findViewById(R.id.ViewFlipper01);

        Next = (Button) findViewById(R.id.Next);
        Previous = (Button) findViewById(R.id.Previous);

        Next.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                viewFlipper.showNext();
            }
        });

        Previous.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                viewFlipper.showPrevious();
            }
        });
    }
}
