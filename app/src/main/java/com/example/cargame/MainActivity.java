package com.example.cargame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;


public class MainActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView gifImageView = findViewById(R.id.gif);
        Glide.with(this).asGif().load(R.drawable._a9n).into(gifImageView);


        startGame();
    }

    protected void startGame(){
        Button startGameButton = findViewById(R.id.button);
        startGameButton.setOnClickListener(v -> {
            new Game(this);
        });
    }
}