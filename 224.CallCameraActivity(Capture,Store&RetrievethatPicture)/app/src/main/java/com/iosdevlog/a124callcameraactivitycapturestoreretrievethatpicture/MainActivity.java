package com.iosdevlog.a124callcameraactivitycapturestoreretrievethatpicture;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Button call;
    Button get;

    String filePath;
    File file;
    Uri output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        call = (Button) findViewById(R.id.button1);
        get = (Button) findViewById(R.id.button2);

        filePath = Environment.getExternalStorageDirectory() + "/img1.png";
        file = new File(filePath);
        output = Uri.fromFile(file);

        call.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, output);

                startActivity(cameraIntent);
            }
        });

        get.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent img = new Intent(MainActivity.this, Image.class);
                startActivity(img);
            }
        });
    }
}
