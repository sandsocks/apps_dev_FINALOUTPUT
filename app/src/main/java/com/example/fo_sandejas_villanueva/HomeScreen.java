package com.example.fo_sandejas_villanueva;

import android.annotation.SuppressLint;
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

        LoveDecreasing();

        bath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bathCat();
            }
        });
    }

    private void bathCat() {
        imageView.setImageResource(R.drawable.cat_wash);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.setImageResource(R.drawable.main_cat);
            }
        }, 2000); // Change back after 2 seconds
    }

    private void LoveDecreasing() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (love > 0) {
                    love--;
                    loveBar.setProgress(love);
                    handler.postDelayed(this, 5000); // Decrease love every 5 seconds
                }
            }
        }, 5000);
    }
}