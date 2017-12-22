package com.example.karthik.defusethebomb;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

public class playlogin extends AppCompatActivity {

    private Button  play, rules, about;
    MediaPlayer mp,btnsnd;
    AlertDialog.Builder builder;
    TextView m,n;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlogin);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/BALLSONTHERAMPAGE.ttf");
        mp = new MediaPlayer();
        btnsnd=new MediaPlayer();
        btnsnd=MediaPlayer.create(this,R.raw.bokudan);
        mp = MediaPlayer.create(this, R.raw.beep);
        mp.start();
        mp.setLooping(true);
        m=(TextView)findViewById(R.id.textView);
        m.setTypeface(typeface);
        n=(TextView)findViewById(R.id.textView3);
        n.setTypeface(typeface);
        play = (Button) findViewById(R.id.play);
        play.setTypeface(typeface);
        rules = (Button) findViewById(R.id.rules);
        rules.setTypeface(typeface);
        about = (Button) findViewById(R.id.aboutus);
        about.setTypeface(typeface);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnsnd.start();
                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(100); //You can manage the time of the blink with this parameter
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(4);
                play.startAnimation(anim);
                 anim.setAnimationListener(new Animation.AnimationListener() {
                     @Override
                     public void onAnimationStart(Animation animation) {

                     }

                     @Override
                     public void onAnimationEnd(Animation animation) {
                         btnsnd.setLooping(false);
                         mp.stop();
                         Intent m = new Intent(playlogin.this, MainActivity.class);

                         startActivity(m);
                         finish();


                     }

                     @Override
                     public void onAnimationRepeat(Animation animation) {

                     }
                 });



            }
        });
        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnsnd.start();
                btnsnd.setLooping(false);


                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(playlogin.this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(playlogin.this);
                }
                builder.setTitle("Rules");

                builder.setMessage("1. This is a Bomb Defuse Game where the Bomb contains 4 Wires\n2.Those 4 Wires  are responsible \t" +
                        "for the bomb Blast\n 3. You need to guess which wire will cause to Blast and you to click the coloured button to cut the Wire\n" +
                        "4. In case the wire which you have chosen doesn't contain the trigger then you have Diffused it and you gain 1 Point and the Bomb is respawned again\n5." +
                        "In case, thr wire which you have chosen has the Trigger then\nYOU SCREWED UP BIG TIME !! ");

                builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        btnsnd.start();
                        btnsnd.setLooping(false);
                        // continue with delete
                    }
                })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                btnsnd.start();
                                btnsnd.setLooping(false);
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }

        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnsnd.start();
                btnsnd.setLooping(false);
                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                homeIntent.addCategory( Intent.CATEGORY_HOME );
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.pause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mp.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp.stop();
        mp.release();
    }


}
