package com.iosdevlog.a151viewswitcherwithmanualcontrols;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    ViewSwitcher switcher;
    Button Next, Previous;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switcher = (ViewSwitcher) findViewById(R.id.activity_main);

        Next = (Button) findViewById(R.id.Next);
        Previous = (Button) findViewById(R.id.Previous);

        Next.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                new AnimationUtils();
                switcher.setAnimation(AnimationUtils.makeInAnimation
                        (getBaseContext(), true));
                switcher.showNext();
            }
        });

        Previous.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                new AnimationUtils();
                switcher.setAnimation(AnimationUtils.makeInAnimation
                        (getBaseContext(), true));
                switcher.showPrevious();
            }
        });
    }
}
