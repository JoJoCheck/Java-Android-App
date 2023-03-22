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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*ViewGroup group = findViewById(R.id.cl);
        ImageView original = findViewById(R.id.original_car);
        ViewGroup.LayoutParams layout = original.getLayoutParams();
        int firstLane = 220;
        int id = View.generateViewId();

        ImageView view = new ImageView(this);
        view.setImageResource(R.drawable.auto_blau_final);
        view.setId(id);
        view.setLayoutParams(new ViewGroup.LayoutParams(layout));
        group.addView(view);
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams)view.getLayoutParams();
        params.leftToLeft = group.getId();
        params.topToTop = original.getId();
        view.requestLayout();
        /*ImageView banner = findViewById(R.id.original_car);
        String s = "" + banner.getTranslationZ();
        Toast toast = Toast.makeText(this, s, Toast.LENGTH_SHORT);
        toast.show();*/

        startGame();
    }

    protected void startGame(){
        Button startGameButton = findViewById(R.id.button);
        startGameButton.setOnClickListener(v -> {
            Game game = new Game(this);
        });
    }
}