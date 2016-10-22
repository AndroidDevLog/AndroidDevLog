package com.iosdevlog.a205getgooglemapapikey;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // keytool -list -keystore ~/.android/debug.keystore
        WebView webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl("http://www.sampleprogramz.com/android/gmap.php");
    }
}
