package com.iosdevlog.a38dynamiccheckbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.view.ViewGroup.LayoutParams;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rl;
    CheckBox c1, c2, c3;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rl = (RelativeLayout) findViewById(R.id.activity_main);

        c1 = new CheckBox(MainActivity.this);
        c2 = new CheckBox(MainActivity.this);
        c3 = new CheckBox(MainActivity.this);

        b = new Button(MainActivity.this);

        c1.setText("Package 1");
        c2.setText("Package 2");
        c3.setText("Package 3");

        b.setText("Proceed");

        RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params1.leftMargin = 150;
        params1.topMargin = 170;

        RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params2.leftMargin = 150;
        params2.topMargin = 235;

        RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params3.leftMargin = 150;
        params3.topMargin = 300;

        RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params4.leftMargin = 150;
        params4.topMargin = 400;

        c1.setLayoutParams(params1);
        c2.setLayoutParams(params2);
        c3.setLayoutParams(params3);

        b.setLayoutParams(params4);

        rl.addView(c1);
        rl.addView(c2);
        rl.addView(c3);

        rl.addView(b);

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

                Toast.makeText(getBaseContext(), "Long Pressed & Refreshed ChekBoxes", Toast.LENGTH_SHORT).show();

                return true;
            }
        });
    }
}
