package com.iosdevlog.a232edittextdependuponspinnerfrommysqldb;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int SPINNER_VALUES_CALL = 1;
    private static final int GET_EDITTEXT_VALUE = 2;
    Spinner spinner;
    EditText text;

    InputStream is = null;
    String result = null;
    String line = null;

    List<String> list;

    int selectedIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner1);
        text = (EditText) findViewById(R.id.editText1);

        SpinnerValuesCall();
    }

    private void setAdapter() {
        ArrayAdapter<String> adp = new ArrayAdapter<>
                (this, android.R.layout.simple_dropdown_item_1line, list);
        adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spinner.setAdapter(adp);

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                selectedIndex = arg2;
                onItemSelectedCall();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
    }

    private void SpinnerValuesCall() {
        new Thread(runnable).start();
    }

    private void onItemSelectedCall() {
        new Thread(onItemSelectedRunnable).start();
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            SpinnerValues();
        }
    };

    Runnable onItemSelectedRunnable = new Runnable() {
        @Override
        public void run() {
            String item = getEditTextValue(selectedIndex);
            Message msg = new Message();
            Bundle data = new Bundle();
            data.putString("item", item);
            msg.what = GET_EDITTEXT_VALUE;
            msg.setData(data);
            handler.sendMessage(msg);
        }
    };

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SPINNER_VALUES_CALL:
                    setAdapter();
                    break;
                case GET_EDITTEXT_VALUE:
                    Bundle data = msg.getData();
                    String item = data.getString("item");
                    text.setText(item);
                    break;
                default:
                    break;
            }
        }
    };

    private void SpinnerValues() {
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://10.0.2.2/edittext/select.php");
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
        } catch (Exception e) {
            Log.e("Fail 1", e.toString());
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
        } catch (Exception e) {
            Log.e("Fail 2", e.toString());
        }

        try {

            JSONArray jarray = new JSONArray(result);
            JSONObject jobject = null;

            list = new ArrayList<>();

            for (int i = 0; i < jarray.length(); i++) {

                jobject = jarray.getJSONObject(i);
                list.add(jobject.getString("id"));
            }

            handler.sendEmptyMessage(SPINNER_VALUES_CALL);
        } catch (Exception e) {
            Log.e("Fail 3", e.toString());
        }
    }

    private String getEditTextValue(int arg) {
        String item = null;

        ArrayList<NameValuePair> nameValuePairs = new ArrayList<>();

        nameValuePairs.add(new BasicNameValuePair("id", list.get(arg).toString()));

        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://10.0.2.2/edittext/getText.php");
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
        } catch (Exception e) {
            Log.e("Fail 1", e.toString());
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
        } catch (Exception e) {
            Log.e("Fail 2", e.toString());
        }

        try {
            JSONObject jobject = new JSONObject(result);

            item = jobject.getString("uname");
        } catch (Exception e) {
            Log.e("Fail 3", e.toString());
        }

        return item;
    }
}
