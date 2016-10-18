package com.iosdevlog.a147staticviewanimator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ViewAnimator;

public class MainActivity extends AppCompatActivity {
    ViewAnimator mContainer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initContainer();
    }

    private void initContainer() {
        mContainer = (ViewAnimator) findViewById(R.id.viewAnimator1);

        Animation inAnim = new AlphaAnimation(0, 1);
        inAnim.setDuration(1000);
        Animation outAnim = new AlphaAnimation(1, 0);
        outAnim.setDuration(1000);

        mContainer.setInAnimation(inAnim);
        mContainer.setOutAnimation(outAnim);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            mContainer.showNext();
        }
        return true;
    }
}
