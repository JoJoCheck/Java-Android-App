package com.example.cargame;

import java.util.Random;

public class Obstacle {
    private int position;

    private int id;

    private int speed;

    private Random random = new Random();

    public Obstacle(){
        setPosition(-200); //fester Wert ganz oben am Bildschrim
        randomSpeed();
    }
    public void setPosition(int position) {
        this.position = position;
    }
    public int getPosition() {
        return position;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public int getSpeed(){
        return speed;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }

    public void randomSpeed(){
        int r = random.nextInt(Game.maxSpeed - Game.minSpeed);

        setSpeed(r + Game.minSpeed);
    }
}
