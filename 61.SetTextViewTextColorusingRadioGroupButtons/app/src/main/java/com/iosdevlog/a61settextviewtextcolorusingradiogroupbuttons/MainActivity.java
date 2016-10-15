package com.iosdevlog.a61settextviewtextcolorusingradiogroupbuttons;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    RadioButton r1;
    TextView t1;
    int pos;
    int pos1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = (RadioGroup) findViewById(R.id.radioGroup1);
        t1 = (TextView) findViewById(R.id.textView1);
        t1.setText("Hello Jelly Bean");
        t1.setTextSize(15);

        r1 = (RadioButton) findViewById(R.id.radio0);
        r1.setChecked(false);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Method 1
                pos = rg.indexOfChild(findViewById(checkedId));

                //Method 2
                pos1 = rg.indexOfChild(findViewById(rg.getCheckedRadioButtonId()));

                switch (pos) {
                    case 0:
                        r1.setChecked(true);
                        Toast.makeText(getBaseContext(), "You have Red Color",
                                Toast.LENGTH_SHORT).show();
                        t1.setTextColor(Color.RED);
                        break;
                    case 1:
                        Toast.makeText(getBaseContext(), "You have Green Color",
                                Toast.LENGTH_SHORT).show();
                        t1.setTextColor(Color.GREEN);
                        break;
                    case 2:
                        Toast.makeText(getBaseContext(), "You have Blue Color",
                                Toast.LENGTH_SHORT).show();
                        t1.setTextColor(Color.BLUE);
                        break;
                    default:
                        //The default selection is RadioButton 1
                        Toast.makeText(getBaseContext(), "You have Red Color",
                                Toast.LENGTH_SHORT).show();
                        t1.setTextColor(Color.RED);
                        break;
                }
            }
        });
    }
}
