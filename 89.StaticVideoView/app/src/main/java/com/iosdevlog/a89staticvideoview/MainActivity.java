package com.iosdevlog.a89staticvideoview;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView video;
    MediaController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri UriPath = Uri.parse
                ("android.resource://com.iosdevlog.a89staticvideoview/" + R.raw.ss);

        video = (VideoView) findViewById(R.id.videoView1);
        controller = new MediaController(MainActivity.this);

        video.setMediaController(controller);
        video.setVideoURI(UriPath);

        video.requestFocus();
        video.start();

        /*MediaController already has all the features to control the Video.
         * If you want to stop the video in programatically, follow below code :
         *
         * 		if(video.isPlaying()==true)
         * 		{
         * 			video.stopPlayback();
         * 			video.clearFocus();
         * 		}
         *
         */
    }
}
