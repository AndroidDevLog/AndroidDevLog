package com.iosdevlog.a150viewswitcher;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ViewSwitcher;
import android.os.Handler;
import android.os.Message;

public class MainActivity extends AppCompatActivity {

    //the ViewSwitcher
    private ViewSwitcher switcher;
    private static final int REFRESH_SCREEN = 1;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switcher = (ViewSwitcher) findViewById(R.id.activity_main);
        startScan();
    }

    public void startScan() {

        new Thread() {

            public void run() {

                try {
                    // This is just a tmp sleep so that we can emulate something loading
                    Thread.sleep(5000);
                    // Use this handler so than you can update the UI from a thread
                    Refresh.sendEmptyMessage(REFRESH_SCREEN);
                } catch (Exception e) {
                }
            }
        }.start();
    }

    // Refresh handler, necessary for updating the UI in a/the thread
    Handler Refresh = new Handler() {
        public void handleMessage(Message msg) {

            switch (msg.what) {

                case REFRESH_SCREEN:
                    switcher.showNext();
                    // To go back to the first view, use switcher.showPrevious()
                    break;

                default:
                    break;
            }
        }
    };
}
