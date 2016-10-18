package com.iosdevlog.a145stackview;

import android.graphics.drawable.Drawable;

/**
 * Created by iosdevlog on 2016/10/18.
 */

public class StackItem {
    public String text;
    public Drawable img;

    public StackItem(String text, Drawable photo) {
        this.img = photo;
        this.text = text;
    }
}
