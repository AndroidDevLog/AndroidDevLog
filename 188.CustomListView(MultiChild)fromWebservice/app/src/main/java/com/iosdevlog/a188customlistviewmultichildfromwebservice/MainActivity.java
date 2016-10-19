package com.iosdevlog.a188customlistviewmultichildfromwebservice;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
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

import static com.iosdevlog.a188customlistviewmultichildfromwebservice.Constrant.DONE;
import static com.iosdevlog.a188customlistviewmultichildfromwebservice.Constrant.MESSAGE;
import static com.iosdevlog.a188customlistviewmultichildfromwebservice.Constrant.TAG;

public class MainActivity extends ListActivity {
    InputStream is = null;
    String ip = "http://10.0.0.21/webservice/select.php";
    String line = null;
    String result = null;

    public String[] list1, list2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

                list1 = new String[ja.length()];
                list2 = new String[ja.length()];

                for (int i = 0; i < ja.length(); i++) {

                    jo = ja.getJSONObject(i);
                    list1[i] = jo.getString("id");
                    list2[i] = jo.getString("name");
                }
                sendMessage(DONE, "");
            } catch (Exception e) {
                sendMessage("Webservice 3", e.toString());
            }
        }
    };

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
            String message = data.getString(MESSAGE);
            String tag = data.getString(TAG);
            if (tag.equals(DONE)) {
                setListAdapter(new ListViewAct(MainActivity.this, list1, list2));
            } else {
                Log.e(tag, message);
                Toast.makeText(getBaseContext(), message,
                        Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //get selected items
        String selectedValue = (String) getListAdapter().getItem(position);
        Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();
    }

}
