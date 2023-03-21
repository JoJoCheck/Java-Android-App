package com.example.cargame;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Obstacle{
    private float position;
    ImageView car;

    public Obstacle(){
        setPosition(200); //fester Wert ganz oben am Bildschrim
    public Obstacle(ViewGroup viewGroup){
        this.car = viewGroup.findViewById(R.id.car);
        setPosition(0); //fester Wert ganz oben am Bildschrim
    }
    public void setPosition(float position) {
        this.car.setY(position);
    }
    public float getPosition() {
        return this.car.getY();
    }
}
