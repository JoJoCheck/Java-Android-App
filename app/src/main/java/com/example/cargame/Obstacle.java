package com.example.cargame;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Obstacle{
    private float position;

    public Obstacle(){
        setPosition(0); //fester Wert ganz oben am Bildschrim
    }
    public void setPosition(float position) {
        this.position = position;
    }
    public float getPosition() {
        return this.position;
    }
}
