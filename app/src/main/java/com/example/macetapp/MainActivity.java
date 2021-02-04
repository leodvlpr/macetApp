package com.example.macetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;

    //Variables
    Animation topAnim;
    Animation bottomAnim;
    ImageView image;
    View viewLine;
    TextView welcome, to , macetapp, point, slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Animations
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //Hooks
        image = findViewById(R.id.image);
        welcome = findViewById(R.id.welcome);
        to = findViewById(R.id.to);
        macetapp = findViewById(R.id.macetapp);
        point = findViewById(R.id.point);
        slogan = findViewById(R.id.slogan);
        viewLine = findViewById(R.id.viewLine);


        image.setAnimation(bottomAnim);
        welcome.setAnimation(topAnim);
        to.setAnimation(topAnim);
        macetapp.setAnimation(topAnim);
        point.setAnimation(topAnim);
        slogan.setAnimation(topAnim);
        viewLine.setAnimation(topAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }
}