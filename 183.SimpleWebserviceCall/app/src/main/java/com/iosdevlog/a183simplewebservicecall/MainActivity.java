package com.iosdevlog.a183simplewebservicecall;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String MESSAGE = "MESSAGE";
    private static final String ip = "http://10.0.0.21/webservice/select.php";

    Spinner spin;
    InputStream is = null;

    String line = null;
    String result = null;

    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spin = (Spinner) findViewById(R.id.spinner1);

        // call webservice activity and get list value
        webserviceCall();
    }

    private void webserviceCall() {
        new Thread(runnable).start();
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                HttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(ip);
                HttpResponse response = httpClient.execute(httpPost);
                HttpEntity entity = response.getEntity();
                is = entity.getContent();
            } catch (Exception e) {
                sendMessage("Webservice 1", e.toString());
            }

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, "utf-8"), 8);
                StringBuilder sb = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }

                is.close();
                result = sb.toString();
            } catch (Exception e) {
                sendMessage("Webservice 2", e.toString());
            }

            try {
                JSONArray ja = new JSONArray(result);
                JSONObject jo;

                list = new ArrayList<>();

                for (int i = 0; i < ja.length(); i++) {

                    jo = ja.getJSONObject(i);
                    list.add(jo.getString("name"));
                }
                sendMessage("Webservice 3", "Done");
            } catch (Exception e) {
                sendMessage("Webservice 3", e.toString());
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
            String tag = data.getString(TAG);
            Log.e(tag, message);
            Toast.makeText(getBaseContext(), message,
                    Toast.LENGTH_SHORT).show();

            if (message == "Done") {
                // set list into ArrayAdapter
                ArrayAdapter<String> adp = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, list);
                // Set Adapter value into Spinner
                spin.setAdapter(adp);
            }
        }
    };
}
