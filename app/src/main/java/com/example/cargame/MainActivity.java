package com.example.cargame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView auto1;
    private ImageView auto2;
    private ViewGroup.LayoutParams layout;
    private ImageView original;

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