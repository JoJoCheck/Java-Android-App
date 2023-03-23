package com.example.cargame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView gifImageView = findViewById(R.id.gif);
        Glide.with(this).asGif().load(R.drawable._a9n).into(gifImageView);
        gifImageView.setVisibility(View.GONE);


        startGame();
    }

    protected void startGame(){
        Button startGameButton = findViewById(R.id.button);
        startGameButton.setOnClickListener(v -> {
            new Game(this);
        });
    }
}