package com.example.fo_sandejas_villanueva;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class HomeScreen extends AppCompatActivity {
    private ProgressBar loveBar;
    private Handler handler = new Handler();
    private int love = 100;

    private ImageView imageView;

    private ImageButton bath;
    private ImageButton feed;
    private ImageButton nap;
    private ImageButton play;

    private MediaPlayer mediaPlayerEat;
    private MediaPlayer mediaPlayerPlay;
    private MediaPlayer mediaPlayerShower;
    private MediaPlayer mediaPlayerSleep;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loveBar = findViewById(R.id.loveMeter);

        imageView = findViewById(R.id.cat_image);

        bath = findViewById(R.id.bath_button);
        feed = findViewById(R.id.eat_button);
        play = findViewById(R.id.play_button);
        nap = findViewById(R.id.nap_button);

        mediaPlayerEat = MediaPlayer.create(this, R.raw.eat);
        mediaPlayerPlay = MediaPlayer.create(this, R.raw.play);
        mediaPlayerShower = MediaPlayer.create(this, R.raw.shower);
        mediaPlayerSleep = MediaPlayer.create(this, R.raw.sleep);

        LoveDecreasing();

        /*buttons*/
        bath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bathCatImage();
                bathCatIncrease();
                playAudio(mediaPlayerShower);
            }
        });

        feed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                feedCatImage();
                feedCatIncrease();
                playAudio(mediaPlayerEat);
            }
        });

        play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                playCatImage();
                playCatIncrease();
                playAudio(mediaPlayerPlay);
            }
        });

        nap.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                sleepCatImage();
                sleepCatIncrease();
                playAudio(mediaPlayerSleep);
            }
        });
    }

    /*image change*/
    private void sleepCatImage(){
        imageView.setImageResource(R.drawable.cat_sleep);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.setImageResource(R.drawable.main_cat);

            }
        }, 2000); // Change back after 2 seconds
    }

    private void playCatImage(){
        imageView.setImageResource(R.drawable.cat_play);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.setImageResource(R.drawable.main_cat);

            }
        }, 2000); // Change back after 2 seconds
    }

    private void feedCatImage(){
        imageView.setImageResource(R.drawable.cat_eat);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.setImageResource(R.drawable.main_cat);

            }
        }, 2000); // Change back after 2 seconds
    }

    private void bathCatImage() {
        imageView.setImageResource(R.drawable.cat_wash);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.setImageResource(R.drawable.main_cat);

            }
        }, 2000); // Change back after 2 seconds
    }

    /*audio*/
    private void playAudio(MediaPlayer mediaPlayer){
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaPlayer.release();
        }
        mediaPlayer.start();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayerEat != null) mediaPlayerEat.release();
        if (mediaPlayerPlay != null) mediaPlayerPlay.release();
        if (mediaPlayerShower != null) mediaPlayerShower.release();
        if (mediaPlayerSleep != null) mediaPlayerSleep.release();
    }

    /*love bar increase*/
    private void feedCatIncrease(){
        love += 5;
        if(love> loveBar.getMax()){
            love = loveBar.getMax();
        }
        loveBar.setProgress(love);
    }
    private void sleepCatIncrease(){
        love += 5;
        if(love> loveBar.getMax()){
            love = loveBar.getMax();
        }
        loveBar.setProgress(love);
    }
    private void playCatIncrease(){
        love += 5;
        if(love> loveBar.getMax()){
            love = loveBar.getMax();
        }
        loveBar.setProgress(love);
    }
    private void bathCatIncrease(){
        love += 5;
        if(love> loveBar.getMax()){
            love = loveBar.getMax();
        }
        loveBar.setProgress(love);
    }

    /*love bar decrease over time*/
    private void LoveDecreasing() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (love > 0) {
                    love--;
                    loveBar.setProgress(love);
                    handler.postDelayed(this, 5000);
                }
            }
        }, 5000);
    }


}