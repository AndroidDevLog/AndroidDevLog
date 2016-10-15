package com.iosdevlog.a85dynamicimagebutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rl;
    ImageButton imgbutton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.activity_main);

        imgbutton = new ImageButton (MainActivity.this);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        params.addRule(RelativeLayout.CENTER_IN_PARENT);

        imgbutton.setLayoutParams(params);
        imgbutton.setImageResource(R.drawable.a1);

        rl.addView(imgbutton);

        imgbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                imgbutton.setImageResource(R.drawable.a2);
                Toast.makeText(getBaseContext(), "ImageButton Clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });

        imgbutton.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                imgbutton.setImageResource(R.drawable.a4);
                Toast.makeText(getBaseContext(), "ImageButton Long Clicked",
                        Toast.LENGTH_SHORT).show();

                return true;
            }
        });
    }
}
