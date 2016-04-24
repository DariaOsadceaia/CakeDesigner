package com.cake.grafics;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import static com.cake.others.Disposition.CAKE_COORDINATES_X;
import static com.cake.others.Disposition.CAKE_COORDINATES_Y;

/**
 * Created by Gerika on 20.03.2016.
 */

//This class and his inheritors are only for visual presentation of all Cakecomponents
public class VisualComponent {
    Texture image;
    Rectangle position;
    String form;


    public VisualComponent(){

        position = new Rectangle();
        position.x = CAKE_COORDINATES_X;
        position.y = CAKE_COORDINATES_Y;
    }


    public VisualComponent(Texture t){

        //image of component
        image = t;
        //standart position - rectangle with coordinates
        //width and height from original texture
        position = new Rectangle();
        position.x = CAKE_COORDINATES_X;
        position.y = CAKE_COORDINATES_Y;

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

        //release resourse from image
        image.dispose();
    }






}
