package com.iosdevlog.a94staticcalendarview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
import android.widget.Toast;
import android.widget.CalendarView.OnDateChangeListener;

public class MainActivity extends AppCompatActivity {

    CalendarView cal;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cal = (CalendarView) findViewById(R.id.calendarView1);

        cal.setOnDateChangeListener(new OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                Toast.makeText(getBaseContext(), "Selected Date is\n\n"
                                + dayOfMonth + " : " + month + " : " + year,
                        Toast.LENGTH_LONG).show();
            }
        });
    }

}
