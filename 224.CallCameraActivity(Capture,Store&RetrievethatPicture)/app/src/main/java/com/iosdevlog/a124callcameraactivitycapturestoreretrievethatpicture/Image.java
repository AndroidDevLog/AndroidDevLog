package com.iosdevlog.a124callcameraactivitycapturestoreretrievethatpicture;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by iosdevlog on 2016/10/25.
 */

public class Image extends AppCompatActivity {
    ImageView img;

    String filePath;
    File file;
    Uri output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        filePath = Environment.getExternalStorageDirectory() + "/img1.png";
        file = new File(filePath);
        output = Uri.fromFile(file);

        img = new ImageView(Image.this);
        img.setImageURI(output);

        setContentView(img);
    }
}
