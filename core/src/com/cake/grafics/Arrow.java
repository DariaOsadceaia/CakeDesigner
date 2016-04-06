package com.cake.grafics;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Gerika on 25.02.2016.
 */
public class Arrow {

    Texture image;
    Rectangle position;


    public Arrow(Texture t,Rectangle p){

        image = t;
        position = p;

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



    public void dispose(){
        image.dispose();


    }


}

