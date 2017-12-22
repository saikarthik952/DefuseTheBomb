package com.example.karthik.defusethebomb;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView diffusedscrew,diy, scoreview, score,tv,tm;

    private Button blue, white, green, yellow;
    private ImageView img;
    private static int scores = 0;
    private static final int highscore = 0;
    MediaPlayer bep,doublebep,bokudan;
    Typeface typeface;
    private final long startTime =6000;
    private final long interval = 1 * 1000;
    private boolean timerStarted = false;
    private CountDownTimer countDownTimer;
    @Override

    protected void onCreate(Bundle savedInstanceState)

    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // reverseTimer(5);

        diffusedscrew = (TextView) findViewById(R.id.diffscrew);
         typeface = Typeface.createFromAsset(getAssets(), "font/BALLSONTHERAMPAGE.ttf");
        diffusedscrew.setTypeface(typeface);
        diy=(TextView)findViewById(R.id.diif);
        diy.setTypeface(typeface);
        bep=MediaPlayer.create(this,R.raw.bep);
        doublebep=MediaPlayer.create(this,R.raw.doublebep);
        scoreview = (TextView) findViewById(R.id.scoreview);
        scoreview.setTypeface(typeface);
        score = (TextView) findViewById(R.id.bombsdiffused);
        score.setTypeface(typeface);
        blue = (Button) findViewById(R.id.button);
        blue.setTypeface(typeface);
        white = (Button) findViewById(R.id.button2);
        white.setTypeface(typeface);
        green = (Button) findViewById(R.id.grn);
        green.setTypeface(typeface);
        yellow = (Button) findViewById(R.id.button3);
        yellow.setTypeface(typeface);
        img = (ImageView) findViewById(R.id.imageView3);
        Random r = new Random();
        final int i1 = r.nextInt(5 - 1) + 1;
        blue.setEnabled(true);
        white.setEnabled(true);
        green.setEnabled(true);
        yellow.setEnabled(true);
        tv=(TextView)findViewById(R.id.timer);
        tv.setTypeface(typeface);
        //0tm=(TextView)findViewById(R.id.tm);
        //tm.setTypeface(typeface);

        countDownTimer = new CountDownTimerActivity(startTime, interval);
        countDownTimer.start();


        bep.start();
        bep.setLooping(true);
        bokudan=MediaPlayer.create(this,R.raw.bokudan);
        bokudan.setLooping(false);

        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bokudan.start();
                bokudan.setLooping(false);
                Random r = new Random();
                final int i1 = r.nextInt(5 - 1) + 1;
                bluelclicked();
                if (i1 == 1) {
                    //exploded
                    doublebep.start();
                    screwedupblink();
                } else {
                    countDownTimer.cancel();
                    //reverseTimer(5);


                    bep.pause();
                    bokudan.start();
                    diffusedblink();


                }


            }


        });
        white.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bokudan.start();
                bokudan.setLooping(false);
                Random r = new Random();
                final int i1 = r.nextInt(5 - 1) + 1;
                whiteclicked();
                if (i1 == 2) {
                    //exploded
                    doublebep.start();
                    screwedupblink();
                } else {
                    countDownTimer.cancel();
                   // reverseTimer(5);

                    bep.pause();
                    bokudan.start();
                    diffusedblink();



                }
            }
        });
        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bokudan.start();
                bokudan.setLooping(false);
                Random r = new Random();
                final int i1 = r.nextInt(5 - 1) + 1;
                yellowclicked();

                if (i1 == 3) {
                    //exploded
                    doublebep.start();
                    screwedupblink();
                } else {
                    countDownTimer.cancel();

                    bep.pause();
                   // reverseTimer(5);
                    bokudan.start();
                    diffusedblink();



                }
            }
        });
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bokudan.start();
                bokudan.setLooping(false);
                Random r = new Random();
                final int i1 = r.nextInt(5 - 1) + 1;
                greenclicked();

                if (i1 == 4) {
                    //exploded
                    doublebep.start();
                    screwedupblink();
                } else {
                    countDownTimer.cancel();

                    bep.pause();
                 //  reverseTimer(5);
                    bokudan.start();
                    diffusedblink();



                }
            }
        });
    }
  /*  public void reverseTimer(int Seconds) {


        new CountDownTimer(Seconds * 1000 + 1000, 1000) {

            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);

                int hours = seconds / (60 * 60);
                int tempMint = (seconds - (hours * 60 * 60));
                int minutes = tempMint / 60;
                seconds = tempMint - (minutes * 60);

                tv.setText("TIME : "
                         + String.format("%02d", seconds));
            }

            public void onFinish() {
                doublebep.start();
                screwedupblink();

            }
        }.start();
    }*/
    public class CountDownTimerActivity extends CountDownTimer {

        public CountDownTimerActivity(long startTime, long interval) {
            super(startTime, interval);
        }

        @Override
        public void onFinish() {
            tv.setText("TIME-0");
            doublebep.start();
          //  timefinish();
            screwedupblink();

        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onTick(long millisUntilFinished) {

            tv.setText("TIME-" + millisUntilFinished/1000);
        }
    }

  /*  private void timefinish() {
        tm.setVisibility(View.VISIBLE);
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(100); //You can manage the time of the blink with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(4);
        diffusedscrew.startAnimation(anim);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                bep.stop();
                blue.setEnabled(false);
                white.setEnabled(false);
                green.setEnabled(false);
                yellow.setEnabled(false);



            }

            @Override
            public void onAnimationEnd(Animation animation) {
                tm.clearAnimation();


                tm.setVisibility(View.INVISIBLE);
                Intent k=new Intent(MainActivity.this,blasting.class);
                doublebep.stop();

                startActivity(k);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }*/


    private void screwedupblink() {
                diffusedscrew.setVisibility(View.VISIBLE);

                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(100); //You can manage the time of the blink with this parameter
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(4);
                diffusedscrew.startAnimation(anim);
                anim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        diy.setVisibility(View.INVISIBLE);

                        bep.stop();
                        blue.setEnabled(false);
                        white.setEnabled(false);
                        green.setEnabled(false);
                        yellow.setEnabled(false);



                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        diffusedscrew.clearAnimation();


                        diffusedscrew.setVisibility(View.INVISIBLE);
                        Intent k=new Intent(MainActivity.this,blasting.class);
                        doublebep.stop();
                        k.putExtra("AnyKeyName", scores);

//Fire that second activity


                        startActivity(k);
                        scores=0;
                        finish();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }



    private void diffusedblink() {
        diy.setVisibility(View.VISIBLE);

        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(150); //You can manage the time of the blink with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(4);
        diy.startAnimation(anim);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                scoring();


            }

            @Override
            public void onAnimationEnd(Animation animation) {
                diy.clearAnimation();
                countDownTimer.start();

                diy.setVisibility(View.INVISIBLE);
                bep.start();
                img.setImageResource(R.drawable.bomb);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


    @Override
    protected void onStart() {

        super.onStart();

    }

    private void scoring() {
        scores++;
        scoreview.setText(""+Integer.toString(scores));
    }

    private void yellowclicked() {
        img.setImageResource(R.drawable.yellow);
    }

    private void whiteclicked() {
        img.setImageResource(R.drawable.white);
    }
    private void greenclicked() {
        img.setImageResource(R.drawable.green);
    }

    private void bluelclicked() {
        img.setImageResource(R.drawable.finall);


    }


    @Override
    protected void onPause() {
        super.onPause();
        bep.pause();
        doublebep.pause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        bep.start();
        doublebep.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bep.stop();
        bep.release();
        doublebep.stop();
        scores=0;
    }

}


