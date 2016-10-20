package com.iosdevlog.a195simtype;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TelephonyManager tel;
    TextView text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tel = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        text = (TextView) findViewById(R.id.textView2);

        text.setText("Operator Code : " + tel.getSimOperator().toString()
                + "\nOperator Name : " + tel.getSimOperatorName().toString()
                + "\nCountry ISO : " + tel.getSimCountryIso().toString());
    }
}
