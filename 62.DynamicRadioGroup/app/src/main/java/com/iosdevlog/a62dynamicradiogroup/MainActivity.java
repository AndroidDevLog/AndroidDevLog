package com.iosdevlog.a62dynamicradiogroup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rl;
    RadioGroup rg;
    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;
    int pos;
    int pos1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.activity_main);
        rg = new RadioGroup(this);
        rb1 = new RadioButton(this);
        rb2 = new RadioButton(this);
        rb3 = new RadioButton(this);

        rb1.setText("Radio 1");
        rb2.setText("Radio 2");
        rb3.setText("Radio 3");

        rg.addView(rb1);
        rg.addView(rb2);
        rg.addView(rb3);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        params.leftMargin = 170;
        params.topMargin = 180;

        rg.setLayoutParams(params);

        rl.addView(rg);

        rb1.setChecked(true);

        rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Method 1
                pos = rg.indexOfChild(findViewById(checkedId));

                //Method 2
                pos1 = rg.indexOfChild(findViewById(rg.getCheckedRadioButtonId()));

                switch (pos) {
                    case 0:
                        Toast.makeText(getBaseContext(), "You have Clicked Radio 1",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getBaseContext(), "You have Clicked Radio 2",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getBaseContext(), "You have Clicked Radio 3",
                                Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        //The default selection is RadioButton 1
                        Toast.makeText(getBaseContext(), "You have Clicked Radio 1",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
