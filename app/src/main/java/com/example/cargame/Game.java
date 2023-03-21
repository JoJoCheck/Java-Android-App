package com.example.cargame;

import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

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


    public Game(ViewGroup group){


        lanes[0] = new ArrayList<>();
        lanes[1] = new ArrayList<>();
        lanes[2] = new ArrayList<>();
        player = new Player();
        this.group = group;
        random = new Random();

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


        moveObstaclesDown();
        carCrash();
        if(time % 10 == 0){
            addObstacleRandom();
        }
    }
    public void moveObstaclesDown(){
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < lanes[i].size(); j++) {
                lanes[i].get(j).setPosition(lanes[i].get(j).getPosition() + gameSpeed);

                //Position die vorherige plus eins setzen
                if(lanes[i].get(j).getPosition() == 2400){
                    removeObstacle(i, lanes[i].get(j));
                    //Objekte wenn sie am Rand sind auf null setzen
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


    public void addObstacle(int lane){
        if(lane < 0 || lane > 2){throw new RuntimeException("nicht vorhandene Lane");}
        Obstacle obst = new Obstacle();
        lanes[lane].add(obst);
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
}
