package com.iosdevlog.a140tabwidget;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

/**
 * Created by iosdevlog on 2016/10/18.
 */

public class First extends TabActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Resources res = getResources();
        final TabHost tabHost = getTabHost();

        final Intent i1 = new Intent().setClass(this, A_Section.class);
        final TabSpec oneSpec = tabHost.newTabSpec("A").setIndicator("A Section",
                res.getDrawable(R.drawable.ic_action_search))
                .setContent(i1);
        tabHost.addTab(oneSpec);

        final Intent i2 = new Intent().setClass(this, B_Section.class);
        final TabSpec twoSpec = tabHost.newTabSpec("B").setIndicator("B Section",
                res.getDrawable(R.drawable.ic_action_search))
                .setContent(i2);
        tabHost.addTab(twoSpec);

        tabHost.setCurrentTab(1);
    }
}
