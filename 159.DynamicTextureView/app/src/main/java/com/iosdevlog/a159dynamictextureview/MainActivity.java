package com.iosdevlog.a159dynamictextureview;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements TextureView.SurfaceTextureListener {
    RelativeLayout rl;
    Button b;
    TextureView texture;
    Camera c;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.activity_main);
        b = (Button) findViewById(R.id.button1);

        texture = new TextureView(MainActivity.this);

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
                        (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

                params.topMargin = 250;

                texture.setLayoutParams(params);

                rl.addView(texture);

                Toast.makeText(getBaseContext(), "TextureView Created",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width,
                                          int height) {

        c = Camera.open();
        Camera.Size size = c.getParameters().getPreviewSize();

        texture.setLayoutParams(new FrameLayout.LayoutParams(
                size.width, size.height, Gravity.CENTER));

        try {
            c.setPreviewTexture(surface);
        } catch (IOException e) {
            e.printStackTrace();
        }

        c.startPreview();

        texture.setAlpha(0.5f);
        texture.setRotation(45.0f);
    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {

        c.stopPreview();
        c.release();

        return true;
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width,
                                            int height) {
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
    }
}
