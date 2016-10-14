package com.iosdevlog.a41dynamicradiobutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.view.ViewGroup.LayoutParams;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rl;
    RadioButton rb1, rb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.activity_main);

        rb1 = new RadioButton(MainActivity.this);
        rb2 = new RadioButton(MainActivity.this);

        rb1.setText("RadioButton 1");
        rb2.setText("RadioButton 2");

        RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(
                (int) LayoutParams.WRAP_CONTENT, (int) LayoutParams.WRAP_CONTENT);
        params1.leftMargin = 130;
        params1.topMargin = 170;

        RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(
                (int) LayoutParams.WRAP_CONTENT, (int) LayoutParams.WRAP_CONTENT);
        params2.leftMargin = 130;
        params2.topMargin = 270;

        rb1.setLayoutParams(params1);
        rb2.setLayoutParams(params2);

        rl.addView(rb1);
        rl.addView(rb2);

        rb1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (rb1.isChecked()) {
                    rb2.setChecked(false);
                    Toast.makeText(getBaseContext(), "RadioButton 1 Selected",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        rb2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (rb2.isChecked()) {
                    rb1.setChecked(false);
                    Toast.makeText(getBaseContext(), "RadioButton 2 Selected",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
