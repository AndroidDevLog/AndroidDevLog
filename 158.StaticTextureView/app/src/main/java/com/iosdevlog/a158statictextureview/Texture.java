package com.iosdevlog.a158statictextureview;

import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.Gravity;
import android.view.TextureView;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by iosdevlog on 2016/10/18.
 */

public class Texture extends Activity implements TextureView.SurfaceTextureListener {
    TextureView texture;
    Camera c;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textureview);

        texture = (TextureView) findViewById(R.id.textureView1);

        Toast.makeText(getBaseContext(), "TextureView Created", Toast.LENGTH_SHORT).show();
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
