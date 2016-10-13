package com.iosdevlog.a26jni;

/**
 * Created by iosdevlog on 2016/10/13.
 */

public class Jni {
    public native String getJniString();

    static {
        System.loadLibrary("JNI"); //和生成so文件的名字对应。
    }
}
