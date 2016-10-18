package com.iosdevlog.a141staticwebview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    /**
     * Called when the activity is first created.
     */

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        URL = (EditText) findViewById(R.id.URL);
        Go = (Button) findViewById(R.id.Go);
        Browser = (WebView) findViewById(R.id.WebEngine);
        Browser.loadUrl("iosdevlog.com/");

        Go.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Browser.setWebViewClient(new WebClient());
                Browser.loadUrl("http://" + URL.getText().toString());
            }
        });
    }
}
