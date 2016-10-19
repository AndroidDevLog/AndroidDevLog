package com.iosdevlog.a177insertvaluestomysqldatabase;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "tag";
    private static final String MESSAGE = "message";
    private static final String HOST = "http://10.0.0.21/insert.php";

    String name;
    String id;
    InputStream is = null;
    String result = null;
    String line = null;
    int code;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText e_id = (EditText) findViewById(R.id.editText1);
        final EditText e_name = (EditText) findViewById(R.id.editText2);
        Button insert = (Button) findViewById(R.id.button1);

        insert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                id = e_id.getText().toString();
                name = e_name.getText().toString();

                insert();
            }
        });
    }

    public void insert() {
        new Thread(runnable).start();
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            ArrayList<NameValuePair> nameValuePairs = new ArrayList<>();

            nameValuePairs.add(new BasicNameValuePair("id", id));
            nameValuePairs.add(new BasicNameValuePair("name", name));

            try {
                HttpClient httpclient = new DefaultHttpClient();
                // not 127.0.0.1 / localhost , use true ip
                HttpPost httppost = new HttpPost(HOST);
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                HttpResponse response = httpclient.execute(httppost);
                HttpEntity entity = response.getEntity();
                is = entity.getContent();
                Log.i("Pass 1", "connection success ");
            } catch (Exception e) {
                sendMessage("Fail 1", "Invalid IP Address: " + e.toString());
            }

            try {
                BufferedReader reader = new BufferedReader
                        (new InputStreamReader(is, "utf-8"), 8);
                StringBuilder sb = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
                is.close();
                result = sb.toString();
                Log.i("Pass 2", "connection success ");
            } catch (Exception e) {
                sendMessage("Fail 2", e.toString());
            }

            try {
                JSONObject json_data = new JSONObject(result);
                code = (json_data.getInt("code"));

                if (code == 1) {
                    sendMessage("Pass 3", "Inserted Successfully");
                } else {
                    sendMessage("Pass 3", "Sorry, Try Again");
                }
            } catch (Exception e) {
                sendMessage("Fail 3", e.toString());
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
            String tag = data.getString(TAG);
            String message = data.getString(MESSAGE);
            Log.e(tag, message);
            Toast.makeText(getBaseContext(), tag + " : " + message,
                    Toast.LENGTH_SHORT).show();
        }
    };
}
