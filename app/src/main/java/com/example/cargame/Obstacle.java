package com.example.cargame;

public class Obstacle {
    private int position;

    public Obstacle(){
        setPosition(200); //fester Wert ganz oben am Bildschrim
    }
    public void setPosition(int position) {
        this.position = position;
    }
    public int getPosition() {
        return position;
    }
}
