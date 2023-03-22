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

        original = findViewById(R.id.original_car);

        layout = original.getLayoutParams();

        auto1 = new ImageView(this);
        auto1.setImageResource(R.drawable.auto_gr_n);
        auto2 = new ImageView(this);
        auto2.setImageResource(R.drawable.auto_gr_n);

        auto1.setX(-50);
        auto1.setId(View.generateViewId());
        //auto2.setX(300);
        String s = "" + layout.width;
        Toast toast = Toast.makeText(this, s, Toast.LENGTH_SHORT);
        toast.show();

        auto1.setLayoutParams(new ViewGroup.LayoutParams(layout));
        auto2.setLayoutParams(new ViewGroup.LayoutParams(layout));

        ConstraintLayout constraintLayout = findViewById(R.id.cl);
        constraintLayout.addView(auto1);
        constraintLayout.addView(auto2);

        int firstLane = 220;
        int secondLane = firstLane+300;
        int thirdLane = secondLane+300;

        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams)auto1.getLayoutParams();
        params.leftToLeft = constraintLayout.getId();
        params.topToTop = original.getId();
        params.leftMargin = secondLane;
        auto1.requestLayout();

        startGame();
    }

    protected void startGame(){
        Button startGameButton = findViewById(R.id.button);
        startGameButton.setOnClickListener(v -> {
            Game game = new Game(this);
        });
    }
}