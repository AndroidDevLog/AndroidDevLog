package com.iosdevlog.a136efttorightslidingdrawer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    /**
     * Called when the activity is first created.
     */
    CheckBox cb1, cb2, cb3;
    int key = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Transparent popup = (Transparent) findViewById(R.id.popup_window);
        popup.setVisibility(View.GONE);

        final Button btn = (Button) findViewById(R.id.handle);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (key == 0) {
                    key = 1;
                    popup.setVisibility(View.VISIBLE);
                    //	btn.setBackgroundResource(R.drawable.ic_launcher);
                } else if (key == 1) {
                    key = 0;
                    popup.setVisibility(View.GONE);
                    //	btn.setBackgroundResource(R.drawable.ic_action_search);
                }
            }
        });
    }
}
