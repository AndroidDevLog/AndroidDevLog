package com.iosdevlog.a40staticradio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.view.ViewGroup.LayoutParams;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rl;
    RadioButton r1, r2;
    ImageView iv1, iv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.activity_main);

        r1 = (RadioButton) findViewById(R.id.radioButton1);
        r2 = (RadioButton) findViewById(R.id.radioButton2);

        iv1 = new ImageView(MainActivity.this);
        iv2 = new ImageView(MainActivity.this);

        RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        params1.leftMargin = 200;
        params1.topMargin = 500;

        iv1.setLayoutParams(params1);
        iv1.setImageResource(R.drawable.yes);
        rl.addView(iv1);
        iv1.setVisibility(View.INVISIBLE);

        iv2.setLayoutParams(params1);
        iv2.setImageResource(R.drawable.no);
        rl.addView(iv2);
        iv2.setVisibility(View.INVISIBLE);

        r1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (r1.isChecked()) {
                    r2.setChecked(false);
                    iv2.setVisibility(View.INVISIBLE);
                    iv1.setVisibility(View.VISIBLE);
                }
            }
        });

        r2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (r2.isChecked()) {
                    r1.setChecked(false);
                    iv1.setVisibility(View.INVISIBLE);
                    iv2.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
