package com.example.cargame;

import java.util.ArrayList;

public class Game {
    public ArrayList<Obstacle>[] lanes = new ArrayList[3];

    private int gameSpeed;
    private int points;

    public Game(){

        lanes[0] = new ArrayList<>();
        lanes[1] = new ArrayList<>();
        lanes[2] = new ArrayList<>();

        gameSpeed = 1;
        points = 0;
        this.loop();
    }

    public void loop() {

        System.out.println("Test");
        try{

            Thread.sleep(1000);
            loop();
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

}
