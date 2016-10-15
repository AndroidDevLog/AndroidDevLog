package com.iosdevlog.a92dynamictimepicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.RelativeLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rl;
    TimePicker time;
    Button pick;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.activity_main);
        pick = (Button) findViewById(R.id.button1);

        time = new TimePicker(MainActivity.this);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        params.addRule(RelativeLayout.CENTER_IN_PARENT);

        time.setLayoutParams(params);

        rl.addView(time);

        time.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(getBaseContext(), "Time is " + hourOfDay + " : "
                        + minute, Toast.LENGTH_SHORT).show();
            }
        });

        pick.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Time is " + time.getCurrentHour() +
                        " : " + time.getCurrentMinute(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
