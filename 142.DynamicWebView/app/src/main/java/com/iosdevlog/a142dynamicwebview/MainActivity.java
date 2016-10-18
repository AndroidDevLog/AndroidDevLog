package com.iosdevlog.a142dynamicwebview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linear;
    EditText URL;
    Button Go;
    WebView Browser;

    private class WebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linear = (LinearLayout) findViewById(R.id.activity_main);
        URL = (EditText) findViewById(R.id.URL);
        Go = (Button) findViewById(R.id.Go);
        Browser = new WebView(MainActivity.this);
        linear.addView(Browser);
        Browser.setWebViewClient(new WebClient());

        Browser.loadUrl("http://www.iosdevlog.com");

        Go.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Browser.setWebViewClient(new WebClient());
                Browser.loadUrl("http://" + URL.getText().toString());
            }
        });
    }
}
