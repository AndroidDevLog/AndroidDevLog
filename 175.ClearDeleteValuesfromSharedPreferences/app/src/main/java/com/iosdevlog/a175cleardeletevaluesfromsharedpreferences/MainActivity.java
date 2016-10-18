package com.iosdevlog.a175cleardeletevaluesfromsharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences prefs;
    private String prefName = "report";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText e_id = (EditText) findViewById(R.id.editText1);
        final EditText e_name = (EditText) findViewById(R.id.editText2);
        Button save = (Button) findViewById(R.id.button1);
        Button select = (Button) findViewById(R.id.button2);
        Button update = (Button) findViewById(R.id.button3);
        Button clear = (Button) findViewById(R.id.button4);

        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                prefs = getSharedPreferences(prefName, MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();

                //---save the values in the EditText view to preferences---
                editor.putInt("id", Integer.parseInt(e_id.getText().toString()));
                editor.putString("name", e_name.getText().toString());

                //---saves the values---
                editor.commit();

                Toast.makeText(getBaseContext(), "Saved",
                        Toast.LENGTH_SHORT).show();
            }
        });

        select.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                prefs = getSharedPreferences(prefName, MODE_PRIVATE);

                Toast.makeText(getBaseContext(), String.valueOf(prefs.getInt
                        ("id", 100)), Toast.LENGTH_SHORT).show();
                Toast.makeText(getBaseContext(), prefs.getString
                        ("name", "Balaji"), Toast.LENGTH_SHORT).show();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                prefs = getSharedPreferences(prefName, MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();

                //---save the values in the EditText view to preferences---
                editor.putInt("id", Integer.parseInt(e_id.getText().toString()));
                editor.putString("name", e_name.getText().toString());

                //---saves and update the values both are same---
                editor.commit();

                Toast.makeText(getBaseContext(), "Updated Successfully",
                        Toast.LENGTH_SHORT).show();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                prefs = getSharedPreferences(prefName, MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();

                editor.clear();
                editor.commit();
            }
        });
    }
}
