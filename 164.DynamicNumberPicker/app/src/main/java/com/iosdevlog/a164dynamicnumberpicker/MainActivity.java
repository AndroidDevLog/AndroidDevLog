package com.iosdevlog.a164dynamicnumberpicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.RelativeLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rl;
    NumberPicker np;
    TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.activity_main);
        tv1 = (TextView) findViewById(R.id.textView2);
        tv2 = (TextView) findViewById(R.id.textView3);

        np = new NumberPicker(MainActivity.this);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        params.addRule(RelativeLayout.CENTER_IN_PARENT);

        np.setLayoutParams(params);
        np.setMinValue(0);
        np.setMaxValue(10);
        np.setWrapSelectorWheel(true);

        rl.addView(np);

        np.setOnValueChangedListener(new OnValueChangeListener() {

            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                String Old = "Old Value : ";
                String New = "New Value : ";

                tv1.setText(Old.concat(String.valueOf(oldVal)));
                tv2.setText(New.concat(String.valueOf(newVal)));
            }
        });
    }
}
