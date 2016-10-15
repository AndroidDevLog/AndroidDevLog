package com.iosdevlog.a56seekbarwithtextviewinalertbox;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Alert Box");
        alert.setMessage("Edit Text");

        LinearLayout linear = new LinearLayout(this);

        linear.setOrientation(LinearLayout.VERTICAL);
        TextView text = new TextView(this);
        text.setText("Hello Android");
        text.setPadding(10, 10, 10, 10);

        SeekBar seek = new SeekBar(this);

        linear.addView(seek);
        linear.addView(text);

        alert.setView(linear);

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getApplicationContext(), "OK Pressed",
                        Toast.LENGTH_LONG).show();
                finish();
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getApplicationContext(), "Cancel Pressed",
                        Toast.LENGTH_LONG).show();
                finish();
            }
        });

        alert.show();
    }
}
