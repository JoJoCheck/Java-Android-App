package com.example.cargame;

import java.util.ArrayList;

public class Game {
    public ArrayList<Obstacle> firstLane;
    public ArrayList<Obstacle> secondLane;
    public ArrayList<Obstacle> thirdLane;

    private int gameSpeed;
    private int points;

    public Game(){
        firstLane = new ArrayList<>();
        secondLane = new ArrayList<>();
        thirdLane = new ArrayList<>();

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


    public static void main(String[] args) {
        Game game = new Game();
        game.loop();
    }
}
