package com.example.cargame;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

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
    public Random random;

    private Activity activity;


    public Game(Activity activity){


        lanes[0] = new ArrayList<>();
        lanes[1] = new ArrayList<>();
        lanes[2] = new ArrayList<>();
        player = new Player();
        this.group = activity.findViewById(R.id.cl);
        this.activity = activity;
        time = 0;
        gameSpeed = 1;
        points = 0;
        gameIsRunning = true;

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (gameIsRunning) loop();
            }
        }, 10, 1000/30);
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
        EditText number = group.findViewById(R.id.editTextNumber2);
        points++;
        number.setText(Integer.toString(points));
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
                    view.setImageResource(R.drawable.auto);
                    view.setId(id);
                    group.addView(view);
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
            for (int j = 0; j < lanes[i].size(); i++){
                Obstacle o = lanes[i].get(j);

                findViewOfObstacle(o).setY(o.getPosition());

            }
        }

    }

}
