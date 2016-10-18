package com.iosdevlog.a172storeinsertvaluestosharedpreferences;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText e_id=(EditText) findViewById(R.id.editText1);
        final EditText e_name=(EditText) findViewById(R.id.editText2);
        Button save=(Button) findViewById(R.id.button1);

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
    }
}
