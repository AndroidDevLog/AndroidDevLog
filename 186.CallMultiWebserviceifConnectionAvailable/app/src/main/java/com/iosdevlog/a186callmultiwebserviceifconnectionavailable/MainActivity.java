package com.iosdevlog.a186callmultiwebserviceifconnectionavailable;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.iosdevlog.a186callmultiwebserviceifconnectionavailable.Constrant.MESSAGE;
import static com.iosdevlog.a186callmultiwebserviceifconnectionavailable.Constrant.RESULT;
import static com.iosdevlog.a186callmultiwebserviceifconnectionavailable.Constrant.TAG;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView name;
    TextView id;
    List<String> list;
    InputStream is = null;

    String ip = "http://10.0.0.21/webservice/";
    String db_result = null;
    String line = null;
    String result = null;
    boolean connection = false;

    // 不好的做法 bad smell.
    String string;
    ArrayList<NameValuePair> nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        id = (TextView) findViewById(R.id.textView2);

        connectionCall();
    }

    private void connectionCall() {
        new Thread(connectionRunnable).start();
    }

    Runnable connectionRunnable = new Runnable() {
        @Override
        public void run() {
            try {
                URL url = new URL(ip);
                executeReq(url);

                connection = true;
                sendMessage(TAG, ip + " HttpURLConnection Available");
                // call webservice activity and get list value

                nm = new ArrayList<>();
                nm.add(new BasicNameValuePair("name", "iOSDevLog"));

                string = ip + "select.php";
                multi_webservice();
            } catch (Exception e) {
                connection = false;
                sendMessage(TAG, "Connection Failed" + e.toString());
            }
        }
    };

    private void executeReq(URL url) throws IOException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setReadTimeout(3000);
        con.setConnectTimeout(3500);
        con.setRequestMethod("GET");
        con.setDoInput(true);

        // Connect
        con.connect();
    }

    private void multi_webservice() {
        new Thread(runnable).start();
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                HttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(string);
                httpPost.setEntity(new UrlEncodedFormEntity(nm));
                HttpResponse response = httpClient.execute(httpPost);
                HttpEntity entity = response.getEntity();
                is = entity.getContent();
            } catch (Exception e) {
                Log.e("Webservice 1", e.toString());
            }
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, "utf-8"), 8);
                StringBuilder sb = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }

                is.close();
                result = sb.toString();

                sendMessage(result);
            } catch (Exception e) {
                Log.e("Webservice 2", e.toString());
            }
        }
    };

    private void sendMessage(String result) {
        Message msg = new Message();
        Bundle data = new Bundle();
        data.putString(RESULT, result);
        msg.setData(data);
        handler.sendMessage(msg);
    }

    public void sendMessage(String tag, String message) {
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
            String result = data.getString(RESULT);
            if (result != null) {
                db_result = result;

                try {
                    JSONObject jo = new JSONObject(db_result);
                    id.setText(jo.getString("id"));
                } catch (Exception e) {
                    Log.e("WebService 6", e.toString());
                    try {
                        JSONArray ja = new JSONArray(db_result);
                        JSONObject jo;

                        list = new ArrayList<>();

                        for (int i = 0; i < ja.length(); i++) {
                            jo = ja.getJSONObject(i);
                            list.add(jo.getString("name"));
                        }
                    } catch (Exception ex) {
                        Log.e("WebService 3", ex.toString());
                    }

                    ArrayAdapter<String> adp = new ArrayAdapter<>
                            (MainActivity.this, android.R.layout.simple_list_item_1, list);
                    name.setAdapter(adp);
                    name.setThreshold(1);

                    name.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        @Override
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                                long arg3) {
                            nm = new ArrayList<>();
                            nm.add(new BasicNameValuePair("name", name.getText().toString()));

                            string = ip + "get.php";
                            multi_webservice();
                        }
                    });
                }

            } else {
                String message = data.getString(MESSAGE);
                String tag = data.getString(TAG);
                Log.e(tag, message);
                Toast.makeText(getBaseContext(), message,
                        Toast.LENGTH_SHORT).show();
            }
        }
    };
}
