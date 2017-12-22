package com.example.karthik.defusethebomb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

public class blasting extends AppCompatActivity {
    private VideoView videoview;
    TextView m,n,score,highscore,det;
    Button mm,retry;


 int k,scores,highscores=0;
    SharedPreferences mSharedPrefs;
    SharedPreferences.Editor mPrefsEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blasting);
        int data = getIntent().getExtras().getInt("AnyKeyName");

        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/BALLSONTHERAMPAGE.ttf");
        m=(TextView)findViewById(R.id.sc);
        m.setTypeface(typeface);
        n=(TextView)findViewById(R.id.hs);
        n.setTypeface(typeface);
        score=(TextView)findViewById(R.id.sscore);
        score.setTypeface(typeface);
        highscore=(TextView)findViewById(R.id.highscore);
        highscore.setTypeface(typeface);
        mm=(Button)findViewById(R.id.mm);
        retry=(Button)findViewById(R.id.retry);
        mm.setTypeface(typeface);
        retry.setTypeface(typeface);
        det=(TextView)findViewById(R.id.det);;
        det.setTypeface(typeface);

        score.setText(String.valueOf(data));

        videoview = (VideoView) findViewById(R.id.videoView);
        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.blasting);
        final int duration = 5000;
        final int colorFrom = Color.parseColor("#10000000");
        final int colorTo = Color.parseColor("#000000");
        ColorDrawable[] color = {new ColorDrawable(colorFrom), new ColorDrawable(colorTo)};
        TransitionDrawable transition = new TransitionDrawable(color);
        videoview.setBackground(transition);
        transition.startTransition(duration);
        videoview.setVideoURI(video);
        videoview.start();
        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

            }
        });
        //videoview.start();
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoview.stopPlayback();
                 scores=0;
                Intent k= new Intent(blasting.this,MainActivity.class);
                startActivity(k);
                finish();
            }
        });
        mm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoview.stopPlayback();
                scores=0;
                Intent m=new Intent(blasting.this,playlogin.class);
                startActivity(m);
                finish();
            }
        });


    }




    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
