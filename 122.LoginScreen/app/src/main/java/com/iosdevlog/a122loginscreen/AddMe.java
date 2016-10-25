package com.iosdevlog.a122loginscreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by iosdevlog on 2016/10/25.
 */

public class AddMe extends AppCompatActivity {
    private static final int LOGIN_SUCCESS_3 = 31;
    private static final int LOGIN_FAIL_3 = 32;
    private static final int LOGIN_EXECPTION_1 = 13;
    private static final int LOGIN_EXECPTION_2 = 23;
    private static final int LOGIN_EXECPTION_3 = 33;

    private static final String TAG = "AddMe";
    private static final String MESSAGE = "MESSAGE";

    RelativeLayout rl;
    EditText id, uname, pwd, repwd;

    InputStream is = null;
    String result = null;
    String line = null;
    int code, count;

    List<String> ListID;

    private SharedPreferences prefs;
    private String prefName = "report";

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            GetID();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addme);

        new Thread(runnable).start();

        rl = (RelativeLayout) findViewById(R.id.rl);
        id = (EditText) findViewById(R.id.editText1);
        uname = (EditText) findViewById(R.id.editText2);
        pwd = (EditText) findViewById(R.id.editText3);
        repwd = (EditText) findViewById(R.id.editText4);

        rl.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (uname.getText().toString().equals(""))
                    Toast.makeText(getBaseContext(), "Enter Username",
                            Toast.LENGTH_SHORT).show();

                else if (pwd.getText().toString().equals(""))
                    Toast.makeText(getBaseContext(), "Enter Password",
                            Toast.LENGTH_SHORT).show();

                else if (repwd.getText().toString().equals(""))
                    Toast.makeText(getBaseContext(), "Enter Confirm Password",
                            Toast.LENGTH_SHORT).show();

                else {
                    count = 0;
                    for (int i = 0; i < ListID.size(); i++) {
                        if (ListID.get(i).toString().equals(id.getText().toString())) {
                            count++;
                        }
                    }

                    if (count != 0) {
                        Toast.makeText(getBaseContext(), "This ID is already " +
                                "taken by Someone", Toast.LENGTH_LONG).show();
                        id.setText("");
                    } else {
                        if (pwd.getText().toString().equals(repwd.getText().toString())) {
                            new Thread(addUserRunnable).start();
                        } else {
                            Toast.makeText(getBaseContext(), "Re-Enter the " +
                                    "Password Correctly", Toast.LENGTH_LONG).show();

                            pwd.setText("");
                            repwd.setText("");
                        }
                    }
                }

                return true;
            }
        });
    }

    private void GetID() {
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://10.0.0.21/login/GetID.php");
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
        } catch (Exception e) {
            Log.e("Fail 1", e.toString());
            Toast.makeText(getApplicationContext(), "Invalid IP Address",
                    Toast.LENGTH_LONG).show();
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

            ListID = new ArrayList<String>();

            for (int i = 0; i < jarray.length(); i++) {

                jobject = jarray.getJSONObject(i);
                ListID.add(jobject.getString("id"));
            }
        } catch (Exception e) {
            Log.e("Fail 3", e.toString());
        }
    }

    Runnable addUserRunnable = new Runnable() {
        @Override
        public void run() {
            AddUser();
        }
    };

    private void AddUser() {
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<>();

        nameValuePairs.add(new BasicNameValuePair("id", id.getText().toString()));
        nameValuePairs.add(new BasicNameValuePair("name", uname.getText().toString()));
        nameValuePairs.add(new BasicNameValuePair("pass", pwd.getText().toString()));

        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://10.0.0.21/login/add.php");
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
        } catch (Exception e) {
            sendMessage(LOGIN_EXECPTION_1, "Fail 1", e.toString());
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
            sendMessage(LOGIN_EXECPTION_2, "Fail 2", e.toString());
        }

        try {
            JSONObject jobject = new JSONObject(result);
            code = (jobject.getInt("code"));

            if (code == 1) {
                prefs = getSharedPreferences(prefName, MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();

                //---save the values in the EditText view to preferences---
                editor.putString("id", id.getText().toString());
                editor.putString("name", uname.getText().toString());

                //---saves the values---
                editor.commit();

                handler.sendEmptyMessage(LOGIN_SUCCESS_3);
            } else {
                sendMessage(LOGIN_FAIL_3, "Fail 3", "Sorry, Try Again");
            }
        } catch (Exception e) {
            sendMessage(LOGIN_EXECPTION_3, "Fail 3", e.toString());
        }
    }

    private void sendMessage(int what, String tag, String message) {
        Message msg = new Message();
        Bundle data = new Bundle();
        data.putString(TAG, tag);
        data.putString(MESSAGE, message);
        msg.setData(data);
        msg.what = what;
        handler.sendMessage(msg);
    }

    //定义Handler对象
    private Handler handler = new Handler() {
        @Override
        //当有消息发送出来的时候就执行Handler的这个方法
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //处理UI
            switch (msg.what) {
                case LOGIN_SUCCESS_3:
                    Toast.makeText(getBaseContext(), "Added Successfully",
                            Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(AddMe.this, NextPage.class);
                    startActivity(i);
                    break;
                case LOGIN_FAIL_3:
                    toastMessage(msg);
                    break;
                case LOGIN_EXECPTION_1:
                    toastMessage(msg);
                    break;
                case LOGIN_EXECPTION_2:
                    toastMessage(msg);
                    break;
                case LOGIN_EXECPTION_3:
                    toastMessage(msg);
                    break;
                default:
                    break;
            }
        }
    };

    private void toastMessage(Message msg) {
        Bundle data = msg.getData();
        String message = data.getString(MESSAGE);
        String tag = data.getString(TAG);
        Log.e(tag, message);
        Toast.makeText(getBaseContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(AddMe.this, MainActivity.class));
    }
}
