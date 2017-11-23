package com.iosdevlog.a191selectdatafromwebserviceifhttpurlconnectionavailableorselectdatafromsqlitedbifhttpurlconnectionisnotavailable;

import android.app.ListActivity;
import android.database.Cursor;
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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends ListActivity {
    private static final String TAG = "MainActivity";
    InputStream is = null;
    String ip = "http://10.0.0.21/webservice/select.php";
    String line = null;
    String result = null;
    public String[] list1, list2;

    SQLiteDB sqlite_obj;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sqlite_obj = new SQLiteDB(MainActivity.this);

        try {
            URL url = new URL(ip);
            connectionCall();
            Toast.makeText(getBaseContext(), "Data from Webservice", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            sqlitecall();
            Toast.makeText(getBaseContext(), "Data from SQLite DB", Toast.LENGTH_SHORT).show();
        }
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
            } catch (Exception e) {
                Log.e(TAG, "Connection Failed" + e.toString());
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
        // web
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
            } catch (Exception e) {
                Log.e("Webservice 2", e.toString());
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
            } catch (Exception e) {
                Log.e("Webservice 3", e.toString());
            }

            sqlite_obj.open();

            sqlite_obj.deleteAll();

            for (int i = 0; i < list1.length; i++) {
                sqlite_obj.insert(list1[i].toString(), list2[i].toString());
            }

            sqlite_obj.close();

            handler.sendEmptyMessage(0);
        }
    };

    //定义Handler对象
    private Handler handler = new Handler() {
        @Override
        //当有消息发送出来的时候就执行Handler的这个方法
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            setListAdapter(new ListViewAct(MainActivity.this, list1, list2));
        }
    };

    private void sqlitecall() {
        sqlite_obj.open();
        Cursor c = sqlite_obj.getAllData();

        list1 = new String[c.getCount()];
        list2 = new String[c.getCount()];

        if (c.moveToFirst()) {
            int i = 0;
            do {
                DisplayContact(c, i);
                i++;
            } while (c.moveToNext());
        }

        sqlite_obj.close();

        setListAdapter(new ListViewAct(this, list1, list2));
    }

    private void DisplayContact(Cursor c, int i) {
        list1[i] = c.getString(0);
        list2[i] = c.getString(1);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //get selected items
        String selectedValue = (String) getListAdapter().getItem(position);
        Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();
    }
}
