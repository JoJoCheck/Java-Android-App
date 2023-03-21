package com.example.cargame;

import java.util.ArrayList;

public class Game {
    public ArrayList<Obstacle>[] lanes = new ArrayList[3];

    private int gameSpeed;
    private int points;

    private boolean gameIsRunning;

    private Player player;

    public Game(){

        lanes[0] = new ArrayList<>();
        lanes[1] = new ArrayList<>();
        lanes[2] = new ArrayList<>();
        player = new Player();

        gameSpeed = 1;
        points = 0;
        this.loop();
    }

    public void loop() {

        System.out.println("Test");
        try{
            Thread.sleep(1000);
            if (gameIsRunning) loop();
        }catch(InterruptedException ex){
            //do stuff
        }
    }


    public void addObstacle(int lane){

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
                if (obstacle.getPosition() <= 30 && obstacle.getPosition() >= 5){
                    return true;
                }
            }
        }
        return false;
    }
}
