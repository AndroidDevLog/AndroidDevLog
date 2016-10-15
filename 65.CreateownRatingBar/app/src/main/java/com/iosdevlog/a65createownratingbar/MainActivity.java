package com.iosdevlog.a65createownratingbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rl;
    EditText star, step;
    Button create;
    RatingBar rating;

    int numStar;
    float stepSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.activity_main);
        star = (EditText) findViewById(R.id.editText1);
        step = (EditText) findViewById(R.id.editText2);

        create = (Button) findViewById(R.id.button1);

        create.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                numStar = Integer.parseInt(star.getText().toString());
                stepSize = Float.parseFloat(step.getText().toString());

                Create_RatingBar();
            }
        });
    }

    private void Create_RatingBar() {

        rl.removeView(rating);
        rating = new RatingBar(MainActivity.this);

        rating.setStepSize(stepSize);
        rating.setNumStars(numStar);

        RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        param.addRule(RelativeLayout.CENTER_HORIZONTAL);
        param.topMargin = 900;

        rating.setLayoutParams(param);
        rl.addView(rating);
    }
}
