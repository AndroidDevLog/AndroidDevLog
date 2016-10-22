package com.iosdevlog.a200sendsms;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.telephony.SmsManager;

public class MainActivity extends AppCompatActivity {
    Button Send;
    EditText Phone, Msg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Phone = (EditText) findViewById(R.id.editText1);
        Msg = (EditText) findViewById(R.id.editText2);

        Send = (Button) findViewById(R.id.button1);
        Send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendSMS(Phone.getText().toString(), Msg.getText().toString());
            }
        });
    }

    public void sendSMS(String phoneNumber, String message) {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
    }
}
