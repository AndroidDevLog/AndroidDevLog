package com.iosdevlog.a91statictimepicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.TimePicker.OnTimeChangedListener;

public class MainActivity extends AppCompatActivity {
    Button pick;
    TimePicker time;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pick = (Button) findViewById(R.id.button1);
        time = (TimePicker) findViewById(R.id.timePicker1);

        time.setOnTimeChangedListener(new OnTimeChangedListener() {

            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(getBaseContext(),"Time is "+hourOfDay+ " : "
                        +minute, Toast.LENGTH_SHORT).show();
            }
        });

        pick.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Time is "+time.getCurrentHour()+
                        " : " +time.getCurrentMinute(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
