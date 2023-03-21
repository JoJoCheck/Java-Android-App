package com.example.cargame;

public class Obstacle {
    private int position;

    public Obstacle(int pos){

        setPosition(pos);
    }
    public void setPosition(int position) {
        this.position = position;
    }
    public int getPosition() {
        return position;
    }
}
