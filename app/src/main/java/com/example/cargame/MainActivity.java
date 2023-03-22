package com.example.cargame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startGame();
    }

    protected void startGame(){
        Button startGameButton = findViewById(R.id.button);
        startGameButton.setOnClickListener(v -> {
            Game game = new Game(this);
        });
    }
}