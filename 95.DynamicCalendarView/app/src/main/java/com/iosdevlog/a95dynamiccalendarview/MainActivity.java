package com.iosdevlog.a95dynamiccalendarview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.RelativeLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rl;
    CalendarView cal;

    @SuppressLint({ "NewApi", "NewApi" })
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.activity_main);

        cal = new CalendarView(MainActivity.this);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
                (LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

        params.topMargin = 100;
        cal.setLayoutParams(params);

        rl.addView(cal);

        cal.setOnDateChangeListener(new OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                Toast.makeText(getBaseContext(),"Selected Date is\n\n"
                                +dayOfMonth+" : "+month+" : "+year ,
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
