package com.cake.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Gerika on 21.02.2016.
 */
public class CakeBase {


    Texture image;
    Rectangle position;
    String name;
    float cost;



    public CakeBase(Texture t,String n,float c){

        image = t;
        cost = c;

        // create a Rectangle to logically represent the bucket
        position = new Rectangle();
        position.x = 800 / 2 - 400 / 2; // center the bucket horizontally
        position.y = 400 / 2 - 250 / 2; // bottom left corner of the bucket is 20 pixels above
        // the bottom screen edge
       // basePosition.width = 64;
       // basePosition.height = 64;

        name = n;

    }

    public Texture getImage(){

        return image;
    }
    public Rectangle getPosition(){
        return position;
    }

    public void setPosition(Rectangle r){

        position = r;

    }
    public void setImage(Texture t){

        image = t;
    }

    public String getName(){

        return name;
    }
    public void setName(String n){
        name = n;

    }

    public void setCost(float c){

        cost = c;
    }

    public float getCost(){

        return cost;
    }


    public void dispose(){
            image.dispose();


    }

}
