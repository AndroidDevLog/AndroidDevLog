package com.iosdevlog.a230shaketocallnextpageactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class NextPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_page);
    }

    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(NextPage.this, MainActivity.class));
    }
}
