package com.iosdevlog.a170staticabsolutelayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ToggleButton tg1 = (ToggleButton) findViewById(R.id.toggleButton1);
        final ToggleButton tg2 = (ToggleButton) findViewById(R.id.toggleButton2);

        Button b = (Button) findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(tg1.isChecked())
                    Toast.makeText(getBaseContext(), "Toggle Button 1" +
                            "\n \n \t is Checked", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getBaseContext(), "Toggle Button 1" +
                            "\n \n is not Checked", Toast.LENGTH_SHORT).show();
            }
        });

        b.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                if(tg2.isChecked())
                    Toast.makeText(getBaseContext(), "Toggle Button 2" +
                            "\n \n \t is Checked", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getBaseContext(), "Toggle Button 2" +
                            "\n \n is not Checked", Toast.LENGTH_SHORT).show();

                return true;
            }
        });
    }
}
