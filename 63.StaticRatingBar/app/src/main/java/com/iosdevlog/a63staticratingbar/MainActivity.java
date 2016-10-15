package com.iosdevlog.a63staticratingbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RatingBar rr=(RatingBar) findViewById(R.id.ratingBar1);
        final TextView t1=(TextView) findViewById(R.id.textView1);

        rr.setRating((float) 2);
        rr.setStepSize((float) 0.3);

        rr.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                t1.setText(String.valueOf(rating));
            }
        });
    }
}
