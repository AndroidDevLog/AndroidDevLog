package com.iosdevlog.a93staticdatepicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatePicker date;
    Button pick;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date = (DatePicker) findViewById(R.id.datePicker1);
        pick = (Button) findViewById(R.id.button1);

        pick.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Date is : " +
                        date.getDayOfMonth() + "-"+ (date.getMonth()+1) +
                        "-"+ date.getYear(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
