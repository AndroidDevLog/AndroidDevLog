package com.iosdevlog.a21imageviewscaletype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
    }

    public void changeImageViewScaleType(View view) {
        imageView.setScaleType(ImageView.ScaleType.valueOf(((Button) view).getText().toString()));
    }
}
