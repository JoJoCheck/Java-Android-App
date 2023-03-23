package com.example.cargame;

import android.view.View;

public class Player {
    //0: linke Spur, 1: mittlere Spur, 2: rechte Spur
    private int lane;

    private int id;

    public Player(){
        this.lane = 1;
    }

    public int getLane() {
        return lane;
    }

    public void setLane(int lane) {
        if (lane>=0 && lane<=2) {
            this.lane = lane;
        } else {
            throw new RuntimeException("Spur exisiert nicht!");
        }
    }

    public void moveRight(){
        if (lane==0 || lane==1) {
            this.lane ++;
        }
    }

    public void moveLeft(){
        if (lane==1 || lane==2) {
            this.lane --;
        }
    }
}
