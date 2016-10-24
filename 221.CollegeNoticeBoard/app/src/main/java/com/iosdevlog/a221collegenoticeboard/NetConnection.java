package com.iosdevlog.a221collegenoticeboard;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by iosdevlog on 2016/10/22.
 */


public class NetConnection extends Activity {
    private static final String TAG = "NetConnection";
    private static final String MESSAGE = "MESSAGE";
    private SharedPreferences prefs;
    private String prefName = "report";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Thread(runnable).start();
    }

    Runnable runnable = new Runnable() {
        public void run() {
            try {
                prefs = getSharedPreferences(prefName, MODE_PRIVATE);
                String net_ip = prefs.getString("ip", "http://10.0.0.21/cnb/");

                URL url = new URL(net_ip);
                executeReq(url);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("connection", 1);
                editor.commit();

                finish();
                startActivity(new Intent(NetConnection.this, CNB_Login.class));
            } catch (Exception e) {
                sendMessage(getApplicationContext().toString(), "Check Network Connection and IP Address");

                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("connection", 0);
                editor.commit();

                finish();
                startActivity(new Intent(NetConnection.this, CNB_Login.class));
            }
        }
    };

    private void sendMessage(String tag, String message) {
        Message msg = new Message();
        Bundle data = new Bundle();
        data.putString(TAG, tag);
        data.putString(MESSAGE, message);
        msg.setData(data);
        handler.sendMessage(msg);
    }

    private Handler handler = new Handler() {
        //当有消息发送出来的时候就执行Handler的这个方法
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle data = msg.getData();
            String message = data.getString(MESSAGE);
            String tag = data.getString(TAG);
            Log.e(tag, "handleMessage: " + message );
            Toast.makeText(NetConnection.this, message, Toast.LENGTH_SHORT).show();
        }
    };
    

    public void executeReq(URL urlObject) throws IOException {

        HttpURLConnection conn = null;
        conn = (HttpURLConnection) urlObject.openConnection();
        conn.setReadTimeout(30000);//milliseconds
        conn.setConnectTimeout(3500);//milliseconds
        conn.setRequestMethod("GET");
        conn.setDoInput(true);

        // Start connect
        conn.connect();
        InputStream response = conn.getInputStream();
        Log.d("Response:", response.toString());
    }
}