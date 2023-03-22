package com.example.cargame;

public class Obstacle {
    private int position;

    private int id;

    public Obstacle(){
        //setPosition(-100); //fester Wert ganz oben am Bildschrim
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
}
