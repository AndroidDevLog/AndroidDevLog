package com.iosdevlog.a72edittextclickevents;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void call() {
        Toast.makeText(getBaseContext(), "Hi", Toast.LENGTH_LONG).show();
        //insert your codes here..
    }

    public void cal() {
        Toast.makeText(getBaseContext(), "Hello", Toast.LENGTH_LONG).show();
        //insert your codes here..
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText ed1=(EditText)findViewById(R.id.editText1);
        final EditText ed2=(EditText)findViewById(R.id.editText2);

        ed1.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                call();
                return false;
            }
        });

        ed2.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                cal();
                return false;
            }
        });
    }
}
