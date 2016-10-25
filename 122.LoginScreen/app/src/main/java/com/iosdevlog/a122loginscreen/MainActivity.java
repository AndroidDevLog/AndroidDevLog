package com.iosdevlog.a122loginscreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int LOGIN_SUCCESS_3 = 31;
    private static final int LOGIN_FAIL_3 = 32;
    private static final int LOGIN_EXECPTION_1 = 13;
    private static final int LOGIN_EXECPTION_2 = 23;
    private static final int LOGIN_EXECPTION_3 = 33;

    private static final String TAG = "MainActivity";
    private static final String MESSAGE = "MESSAGE";
    RelativeLayout rl;
    EditText id, pass;

    InputStream is = null;
    String result = null;
    String line = null;

    private SharedPreferences prefs;
    private String prefName = "report";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.activity_main);
        id = (EditText) findViewById(R.id.editText1);
        pass = (EditText) findViewById(R.id.editText2);

        rl.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View arg0) {
                if (id.getText().toString().equals(""))
                    Toast.makeText(getBaseContext(), "Enter Username",
                            Toast.LENGTH_SHORT).show();

                else if (pass.getText().toString().equals(""))
                    Toast.makeText(getBaseContext(), "Enter Password",
                            Toast.LENGTH_SHORT).show();

                else
                    new Thread(runnable).start();

                return true;
            }
        });
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            login();
        }
    };

    private void login() {
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<>();

        nameValuePairs.add(new BasicNameValuePair("id", id.getText().toString()));

        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://10.0.0.21/login/login.php");
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

            String S_pwd = jobject.getString("pass");
            String S_name = jobject.getString("name");
            String S_id = jobject.getString("id");

            if (S_pwd.equals(pass.getText().toString())) {
                prefs = getSharedPreferences(prefName, MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();

                //---save the values in the EditText view to preferences---
                editor.putString("id", S_id);
                editor.putString("name", S_name);

                //---saves the values---
                editor.commit();

                handler.sendEmptyMessage(LOGIN_SUCCESS_3);
            } else {
                handler.sendEmptyMessage(LOGIN_FAIL_3);
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
                    Toast.makeText(getBaseContext(), "Login Successfully",
                            Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, NextPage.class);
                    startActivity(i);
                    break;
                case LOGIN_FAIL_3:
                    Toast.makeText(getBaseContext(), "Login Failure \n" +
                            "\n Try Again", Toast.LENGTH_LONG).show();

                    id.setText("");
                    pass.setText("");
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.addme:
                finish();
                Intent j = new Intent(MainActivity.this, AddMe.class);
                startActivity(j);
                return true;
        }

        return false;
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
