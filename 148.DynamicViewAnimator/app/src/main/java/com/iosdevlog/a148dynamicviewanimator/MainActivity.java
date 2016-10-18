package com.iosdevlog.a148dynamicviewanimator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.ViewAnimator;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rl;
    ViewAnimator view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.activity_main);

        view = new ViewAnimator(MainActivity.this);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        params.addRule(RelativeLayout.CENTER_IN_PARENT);

        RelativeLayout.LayoutParams param1 = new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        param1.addRule(RelativeLayout.CENTER_IN_PARENT);

        RelativeLayout.LayoutParams param2 = new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        param2.addRule(RelativeLayout.CENTER_IN_PARENT);

        RelativeLayout.LayoutParams param3 = new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        param3.addRule(RelativeLayout.CENTER_IN_PARENT);

        view.setLayoutParams(params);

        ImageView img = new ImageView(MainActivity.this);
        img.setImageResource(R.drawable.android);

        img.setLayoutParams(param1);

        Button b = new Button(MainActivity.this);
        b.setText("Button");
        b.setLayoutParams(param2);

        TextView tv = new TextView(MainActivity.this);
        tv.setText("Text");
        tv.setTextSize(20);
        tv.setLayoutParams(param3);

        view.addView(img);
        view.addView(b);
        view.addView(tv);

        rl.addView(view);

        Animation inAnim = new AlphaAnimation(0, 1);
        inAnim.setDuration(1000);

        Animation outAnim = new AlphaAnimation(1, 0);
        outAnim.setDuration(1000);

        view.setInAnimation(inAnim);
        view.setOutAnimation(outAnim);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            view.showNext();
        }
        return true;
    }
}
