package com.cake.model;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Gerika on 21.02.2016.
 */
public class CakeBase {

    //размер объекта
    int radius = 6;

    //координаты
    Vector2 position;
    Circle bounds;
    Color color;
    int hight;

    public CakeBase(Vector2 pos,Color color) {

        this.position = new Vector2();
        this.position = pos;
        this.bounds =  new Circle();
        this.bounds.radius = radius;
        this.color = new Color();
        this.color = color;
        this.hight = 20;

    }

    public CakeBase() {

        this.position = new Vector2();
        this.position = new Vector2(12,13);
        this.bounds =  new Circle();
        this.bounds.radius = radius;
        this.color = new Color();
        this.color = new Color(0, 0, 0, 1);
        this.hight = 20;

    }


    public Circle getBounds() {
        return bounds;

    }

    public Vector2 getPosition() {
        return position;

    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color color){

        this.color = color;
    }

    public int getRadius(){

        return radius;
    }

    public int getHight(){

        return hight;
    }


}
