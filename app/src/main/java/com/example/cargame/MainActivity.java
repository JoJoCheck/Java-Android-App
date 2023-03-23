package com.example.cargame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        startGame();
    }

    protected void startGame(){
        Button startGameButton = findViewById(R.id.button);
        ImageView logo = findViewById(R.id.appLogo);
        startGameButton.setOnClickListener(v -> {
            logo.setVisibility(View.GONE);
            new Game(this);
        });
    }
}