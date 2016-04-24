package com.cake.others;

/**
 * Created by Gerika on 17.03.2016.
 */
public class Disposition {

    public static int SCREEN_WIDTH = 800;
    public static int SCREEN_HEIGHT = 400;

    public static float CAKE_COORDINATES_X = SCREEN_WIDTH / 2 - SCREEN_HEIGHT / 2;
    public static float CAKE_COORDINATES_Y = SCREEN_HEIGHT / 2 - 250 / 2;


    public int getCAKE_COORDINATES_XInt(){

        return SCREEN_WIDTH / 2;
    }

    public int getCAKE_COORDINATES_YInt(){

        return SCREEN_HEIGHT / 2;
    }



}
