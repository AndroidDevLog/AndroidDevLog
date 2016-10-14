package com.iosdevlog.a34customdynamicbutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.view.ViewGroup.LayoutParams;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rl;
    Button custom_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.activity_main);
        custom_button = new Button(MainActivity.this);

        RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        param.addRule(RelativeLayout.CENTER_IN_PARENT);

        custom_button.setText("Custom Button");
        custom_button.setPadding(10, 10, 10, 10);
        custom_button.setBackgroundResource(R.drawable.button_style);
        custom_button.setLayoutParams(param);

        custom_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                custom_button.setBackgroundResource(R.drawable.button_clicked);
                Toast.makeText(getBaseContext(), "Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        rl.addView(custom_button);
    }
}
