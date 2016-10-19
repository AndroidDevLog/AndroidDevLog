package com.iosdevlog.a182checkurllinkbasedhttpurlconnection;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String MESSAGE = "MESSAGE";
    private static final String ip = "http://iosdevlog.com/";

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.textView2);

        new Thread(runnable).start();
    }

    private void executeReq(URL url) throws IOException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setReadTimeout(3000);
        con.setConnectTimeout(3500);
        con.setRequestMethod("GET");
        con.setDoInput(true);

        // Connect
        con.connect();
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                URL url = new URL(ip);
                executeReq(url);
                sendMessage(TAG, ip + " HttpURLConnection Available");
            } catch (Exception e) {
                sendMessage(TAG, "Connection Failed" + e.toString());
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

    //定义Handler对象
    private Handler handler = new Handler() {
        @Override
        //当有消息发送出来的时候就执行Handler的这个方法
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //处理UI
            Bundle data = msg.getData();
            String message = data.getString(MESSAGE);
            Log.e(TAG, message);
            Toast.makeText(getBaseContext(), message,
                    Toast.LENGTH_SHORT).show();
            text.setText(message);
        }
    };
}
