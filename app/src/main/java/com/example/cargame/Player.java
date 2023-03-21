package com.example.cargame;

public class Player {
    //1: linke Spur, 2: mittlere Spur, 3: rechte Spur
    private int lane;

    public Player(){
        this.lane = 2;
    }

    public int getLane() {
        return lane;
    }

    public void setLane(int lane) {
        if (lane>=1 && lane<=3) {
            this.lane = lane;
        } else {
            throw new RuntimeException("Spur exisiert nicht!");
        }
    }

    public void moveRigth(){
        if (lane==1 || lane==2) {
            this.lane ++;
        }
    }

    public void moveLeft(){
        if (lane==2 || lane==3) {
            this.lane --;
        }
    }
}
