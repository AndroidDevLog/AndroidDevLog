package com.iosdevlog.a88mediaplayeraudio;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer media;
    Button start, stop;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.button1);
        stop = (Button) findViewById(R.id.button2);

        media = MediaPlayer.create(getBaseContext(), R.raw.xiyouji);

        start.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (media.isPlaying() == false) {
                    media.start();
                }

                play();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (media.isPlaying() == true) {
                    media.stop();
                }

                play();
            }
        });
    }

    public void play() {
        boolean play = media.isPlaying();

        if (play == true) {
            Toast.makeText(getBaseContext(), "Song is Playing",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getBaseContext(), "Song is not Playing",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
