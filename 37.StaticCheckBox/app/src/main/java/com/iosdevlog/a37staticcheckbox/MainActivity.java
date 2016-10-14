package com.iosdevlog.a37staticcheckbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox c1, c2, c3;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c1 = (CheckBox) findViewById(R.id.checkBox1);
        c2 = (CheckBox) findViewById(R.id.checkBox2);
        c3 = (CheckBox) findViewById(R.id.checkBox3);

        b = (Button) findViewById(R.id.button1);

        b.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if ((c1.isChecked() == false) && (c2.isChecked() == false) && (c3.isChecked() == false)) {
                    Toast.makeText(getBaseContext(), "None Package Selected",
                            Toast.LENGTH_SHORT).show();
                } else {
                    String str = "";

                    if (c1.isChecked()) {
                        str = "Package 1";
                    }
                    if (c2.isChecked()) {
                        str = str.concat(" Package 2");
                    }
                    if (c3.isChecked()) {
                        str = str.concat(" Package 3");
                    }

                    int i = str.length();
                    String str1 = " are selected";
                    String str2 = " is selected";

                    if (i > 9) {
                        str = str.concat(str1);

                        Toast.makeText(getBaseContext(), str,
                                Toast.LENGTH_SHORT).show();
                    } else {
                        str = str.concat(str2);

                        Toast.makeText(getBaseContext(), str,
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        b.setOnLongClickListener(new View.OnLongClickListener() {

            public boolean onLongClick(View v) {
                c1.setChecked(false);
                c2.setChecked(false);
                c3.setChecked(false);

                Toast.makeText(MainActivity.this, "Long Pressed & Refreshed ChekBoxes", Toast.LENGTH_SHORT).show();

                return true;
            }
        });
    }
}
