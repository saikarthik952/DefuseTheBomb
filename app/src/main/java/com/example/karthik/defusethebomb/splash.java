package com.example.karthik.defusethebomb;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class splash extends AppCompatActivity {
    VideoView mm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mm=(VideoView)findViewById(R.id.videoView);
        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.intro);
        mm.setVideoURI(video);
        mm.start();
        mm.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                nextactivity();
            }
        });
    }

    private void nextactivity() {

        Intent k= new Intent(splash.this,playlogin.class);
        startActivity(k);
        finish();
    }
}
