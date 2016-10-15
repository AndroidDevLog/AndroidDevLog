package com.iosdevlog.a110dynamictablelayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TableLayout TL;
    TableRow tr1, tr2, tr3;
    TextView t1, t2, dummy;
    EditText et1, et2;
    Button login;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TL = new TableLayout(MainActivity.this);

        tr1 = new TableRow(MainActivity.this);
        tr2 = new TableRow(MainActivity.this);
        tr3 = new TableRow(MainActivity.this);

        t1 = new TextView(MainActivity.this);
        t2 = new TextView(MainActivity.this);
        dummy = new TextView(MainActivity.this);

        et1 = new EditText(MainActivity.this);
        et2 = new EditText(MainActivity.this);

        login = new Button(MainActivity.this);

        t1.setText("Username");
        t1.setTextSize(15);
        t1.setPadding(20, 20, 20, 20);
        tr1.addView(t1);

        et1.setHint("Enter Username");
        et1.setTextSize(15);
        et1.setPadding(20, 20, 20, 20);
        tr1.addView(et1);

        t2.setText("Password");
        t2.setTextSize(15);
        t2.setPadding(20, 20, 20, 20);
        tr2.addView(t2);

        et2.setHint("Enter Password");
        et2.setTextSize(15);
        et2.setPadding(20, 20, 20, 20);
        et2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        tr2.addView(et2);

        tr3.addView(dummy);

        login.setText("Username");
        login.setTextSize(15);
        login.setPadding(20, 20, 20, 20);
        tr3.addView(login);

        TL.addView(tr1);
        TL.addView(tr2);
        TL.addView(tr3);

        setContentView(TL);

        login.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (et1.getText().toString().equals("Balaji") && et2.getText().toString().equals("Android")) {
                    Toast.makeText(getBaseContext(), "Login Successfully !", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getBaseContext(), "Login Failure \n\n Try Again",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
