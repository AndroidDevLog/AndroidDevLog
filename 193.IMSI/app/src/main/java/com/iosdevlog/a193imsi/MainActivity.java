package com.iosdevlog.a193imsi;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;
    TelephonyManager tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // IMSI：International Mobile SubscriberIdentification Number
        // 国际移动用户识别码
        text = (TextView) findViewById(R.id.textView2);
        tel = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        if (tel == null) {
            text.setText("no telephony");
            return;
        }
        String imsi = tel.getSubscriberId();
        if (imsi == null) {
            text.setText("unavailable");
        } else {
            text.setText(imsi.toString());
        }
    }
}