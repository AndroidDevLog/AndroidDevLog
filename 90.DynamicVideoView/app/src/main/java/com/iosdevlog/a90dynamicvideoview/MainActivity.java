package com.iosdevlog.a90dynamicvideoview;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import android.widget.RelativeLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rl;
    VideoView video;
    MediaController Controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri UriPath = Uri.parse
                ("android.resource://com.iosdevlog.a90dynamicvideoview/"+R.raw.ss);

        rl = (RelativeLayout) findViewById(R.id.activity_main);

        video = new VideoView (MainActivity.this);
        Controller = new MediaController (MainActivity.this);


        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        params.topMargin = 80;
        video.setLayoutParams(params);

        rl.addView(video);

        video.setMediaController(Controller);
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
