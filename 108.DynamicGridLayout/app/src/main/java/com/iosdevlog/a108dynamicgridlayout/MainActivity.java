package com.iosdevlog.a108dynamicgridlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.ViewGroup.LayoutParams;

public class MainActivity extends AppCompatActivity {
    GridLayout gl;
    TextView[] text;
    int item;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gl = new GridLayout(MainActivity.this);
        gl.setLayoutParams(new LayoutParams
                (LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        gl.setOrientation(GridLayout.HORIZONTAL);
        gl.setColumnCount(3);
        gl.setRowCount(3);

        text = new TextView[9];

        for (int i = 0; i < 9; i++) {
            text[i] = new TextView(MainActivity.this);
            text[i].setLayoutParams(new LayoutParams
                    (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            text[i].setText(String.valueOf(i));
            text[i].setTextSize(25);
            text[i].setPadding(50, 25, 10, 25);
            gl.addView(text[i]);
        }

        setContentView(gl);

        for (item = 0; item < 9; item++) {
            text[item].setOnClickListener(new View.OnClickListener() {

                int pos = item;

                public void onClick(View v) {
                    Toast.makeText(getBaseContext(), pos + " Clicked",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
