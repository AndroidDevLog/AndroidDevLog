package com.iosdevlog.a192imei;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TelephonyManager tel;
    TextView imei;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // IMEI：International Mobile Equipment Identity
        // 国际移动设备身份码
        tel = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        imei = (TextView) findViewById(R.id.textView2);
        imei.setText(tel.getDeviceId().toString());
    }
}
