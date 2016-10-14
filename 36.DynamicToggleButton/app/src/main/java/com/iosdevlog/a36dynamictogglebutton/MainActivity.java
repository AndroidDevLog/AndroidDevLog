package com.iosdevlog.a36dynamictogglebutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup.LayoutParams;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rl;
    ToggleButton tb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.activity_main);
        tb1 = new ToggleButton (MainActivity.this);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT,  LayoutParams.WRAP_CONTENT);
        params.leftMargin = 180;
        params.topMargin = 300;

        tb1.setLayoutParams(params);

        tb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true) {
                    Toast.makeText(getBaseContext(), "ON State",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getBaseContext(), "OFF State",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        rl.addView(tb1);
    }
}
