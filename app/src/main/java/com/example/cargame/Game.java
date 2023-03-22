package com.example.cargame;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class Game {
    public ArrayList<Obstacle>[] lanes = new ArrayList[3];

    private int gameSpeed;
    private int points;

    private Timer timer = new Timer();

    private boolean gameIsRunning;

    private int time;

    private Player player;

    public ViewGroup group;
    public Random random = new Random();

    private Activity activity;

    private ImageView original;
    private ViewGroup.LayoutParams layout;

    private int firstLane = 220;
    private int secondLane = firstLane+300;
    private int thirdLane = secondLane+300;


    public Game(Activity activity){

        lanes[0] = new ArrayList<>();
        lanes[1] = new ArrayList<>();
        lanes[2] = new ArrayList<>();
        this.group = activity.findViewById(R.id.cl);
        this.activity = activity;
        time = 0;
        gameSpeed = 3;
        points = 0;
        gameIsRunning = true;
     //   group.removeView(group.findViewById(R.id.button));
        buttonChange();

        original = group.findViewById(R.id.original_car);
        layout = original.getLayoutParams();
        createPlayer();
        movePlayerLeft();
        movePlayerRight();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (gameIsRunning) loop();
            }
        }, 0, 1000/30);
    }

    public void loop() {

        time++;

        addPoint();
        moveObstaclesDown();
        carCrash();
        if(time % 100 == 0){
            addObstacleRandom();
        }

        updateAll();

    }
    public void moveObstaclesDown(){
        for(int j = 0; j< 3; j++) {
            for (int i = 0; i < lanes[j].size(); i++) {
                lanes[j].get(i).setPosition(lanes[j].get(i).getPosition() + gameSpeed);
                //Position die vorherige plus Speed setzen
                if(lanes[j].get(i).getPosition() == 2400){
                    removeObstacle(j, lanes[j].get(i));
                    //Objekte wenn sie am Rand sind entfernen
                }
            }
        }
    }
    public void movePlayerRight(){
        Button moveRightButton = group.findViewById(R.id.rightbutton);
        moveRightButton.setOnClickListener (v -> {
            player.moveRight();
        } );
    }
    public void movePlayerLeft(){
        Button moveLeftButton = group.findViewById(R.id.leftbutton);
        moveLeftButton.setOnClickListener(v -> {
            player.moveLeft();
        } );
    }
    public void addPoint(){
        activity.runOnUiThread(
                () -> {
                    TextView number = group.findViewById(R.id.pointScore);
                    setPoints(getPoints()+1);
                    number.setText(Integer.toString(getPoints()));
                }
        );
    }


    public void addObstacle(int lane){
        if(lane < 0 || lane > 2){throw new RuntimeException("nicht vorhandene Lane");}
        int id = View.generateViewId();
        Obstacle obst = new Obstacle();
        obst.setId(id);
        lanes[lane].add(obst);

        activity.runOnUiThread(
                () -> {
                    ImageView view = new ImageView(group.getContext());
                    switch (random.nextInt(4)){
                        case 0:
                            view.setImageResource(R.drawable.auto_blau_final);
                            break;
                        case 1:
                            view.setImageResource(R.drawable.auto_gr_n);
                            break;
                        case 2:
                            view.setImageResource(R.drawable.auto_rot_final);
                            break;
                        case 3:
                            view.setImageResource(R.drawable.auto_grau);
                            break;
                    }
                    view.setId(id);
                    view.setLayoutParams(new ViewGroup.LayoutParams(this.layout));
                    group.addView(view);
                    ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams)view.getLayoutParams();
                    params.leftToLeft = group.getId();
                    params.topToTop = original.getId();
                    switch (lane){
                        case 0:
                            params.leftMargin = firstLane;
                            break;
                        case 1:
                            params.leftMargin = secondLane;
                            break;
                        case 2:
                            params.leftMargin = thirdLane;
                            break;
                    }
                    view.requestLayout();
                }
        );

    }
    public void addObstacleRandom(){
        addObstacle(random.nextInt(3));
    }
    public void removeObstacle(int lane, Obstacle obst){
        lanes[lane].remove(obst);
    }

    public int getGameSpeed() {
        return gameSpeed;
    }

    public void setGameSpeed(int gameSpeed) {
        this.gameSpeed = gameSpeed;
    }

    public int getPoints(){
        return points;
    }

    public void setPoints(int points){
        this.points = points;
    }

    public void carCrash() {
        if (collision()) {
            gameIsRunning = false;
            System.out.println(" -- Crash -- ");
            Button restart = group.findViewById(R.id.button);
            restart.setText("Restart");
            restart.setVisibility(View.VISIBLE);
            new Game(activity);
        }



    }

    public boolean collision(){
        for (int i = 0; i < lanes.length; i++){
            if (player.getLane() != i) continue;
            for(Obstacle obstacle : lanes[i]){
                if (obstacle.getPosition() <= 2000 && obstacle.getPosition() >= 2200){
                    return true;
                }
            }
        }
        return false;
    }

    public View findViewOfObstacle(Obstacle obst){
        return group.findViewById(obst.getId());
    }

    public void updateAll(){

        for(int i = 0; i < lanes.length; i++){
            for (int j = 0; j < lanes[i].size(); j++){
                Obstacle o = lanes[i].get(j);
                if (findViewOfObstacle(o) == null) continue;
                findViewOfObstacle(o).setY(o.getPosition());

            }
        }

        ImageView playerView = group.findViewById(player.getId());
        switch (player.getLane()){
            case 0: playerView.setX(firstLane);
            break;
            case 1: playerView.setX(secondLane);
            break;
            case 2: playerView.setX(thirdLane);
        }


    }

    public void buttonChange(){
        Button startGameButton = group.findViewById(R.id.button);
        Button leftButton = group.findViewById(R.id.leftbutton);
        Button rightButton = group.findViewById(R.id.rightbutton);
        startGameButton.setVisibility(View.GONE);
        leftButton.setVisibility(View.VISIBLE);
        rightButton.setVisibility(View.VISIBLE);

    }


    public void createPlayer(){

        int id = View.generateViewId();
        this.player = new Player();
        player.setId(id);
        player.setLane(2);

        activity.runOnUiThread(
                () -> {
                    ImageView view = new ImageView(group.getContext());
                    view.setImageResource(R.drawable.player_rennauto);

                    view.setId(id);
                    view.setLayoutParams(new ViewGroup.LayoutParams(this.layout));
                    group.addView(view);
                    ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams)view.getLayoutParams();
                    params.leftToLeft = group.getId();
                    params.topToTop = original.getId();

                    params.leftMargin = secondLane;

                    view.requestLayout();
                }
        );
    }
}
