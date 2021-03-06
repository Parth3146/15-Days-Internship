package com.example.practiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide();

        setContentView(R.layout.activity_splash);


        mediaPlayer = MediaPlayer.create(SplashActivity.this, R.raw.scambgm);
        mediaPlayer.start();

        Thread thread = new Thread() {
          public void run() {
              try {
                  sleep(10000);
              } catch (Exception e) {
                  e.printStackTrace();
              } finally {
                  Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                  startActivity(intent);
              }
          }
        };
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.release();
        finish();
    }
}