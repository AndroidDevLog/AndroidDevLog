package com.iosdevlog.a122loginscreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

/**
 * Created by iosdevlog on 2016/10/25.
 */

public class NextPage extends AppCompatActivity {
    TextView text;
    String welcome, name, id;

    private SharedPreferences prefs;
    private String prefName = "report";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.nextpage);

        prefs = getSharedPreferences(prefName, MODE_PRIVATE);
        name = prefs.getString("name", "Balaji");
        id = prefs.getString("id", "082IT111");

        welcome = "Welcome <font color = '#4169E1'> " + name + "</font>";

        text = (TextView) findViewById(R.id.textView1);
        text.setText(Html.fromHtml(welcome));
    }

    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(NextPage.this, MainActivity.class));
    }
}
