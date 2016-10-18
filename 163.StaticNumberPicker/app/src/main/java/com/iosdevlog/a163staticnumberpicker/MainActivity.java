package com.iosdevlog.a163staticnumberpicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.NumberPicker.OnValueChangeListener;

public class MainActivity extends AppCompatActivity {
    NumberPicker np;
    TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        np = (NumberPicker) findViewById(R.id.numberPicker1);
        tv1 = (TextView) findViewById(R.id.textView2);
        tv2 = (TextView) findViewById(R.id.textView3);

        np.setMinValue(0);
        np.setMaxValue(10);
        np.setWrapSelectorWheel(false);

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
