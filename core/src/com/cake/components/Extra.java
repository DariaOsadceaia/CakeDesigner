package com.cake.components;

import com.badlogic.gdx.graphics.Texture;
import com.cake.grafics.VExtra;

/**
 * Created by Gerika on 25.02.2016.
 */
public class Extra {


    String name;
    float cost;
    VExtra vExtra;



    public Extra(Texture t,String n,float c){

        vExtra = new VExtra(t);
        cost = c;



        name = n;

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

    public void setExtraViewer(VExtra v){

        vExtra = v;
    }

    public VExtra getExtraViewer(){return vExtra;}

    public void dispose(){
        vExtra.dispose();


    }

}




