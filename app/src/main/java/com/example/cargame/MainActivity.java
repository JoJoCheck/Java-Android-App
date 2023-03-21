package com.example.cargame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startGame();
    }

    protected void startGame(){
        Button startGameButton = findViewById(R.id.button);
        ViewGroup group = findViewById(R.id.cl);
        startGameButton.setOnClickListener(v -> {
            Game game = new Game(group);
            startGameButton.setVisibility(View.GONE);
        });

    }
}