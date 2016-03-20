package com.cake.components;

import com.badlogic.gdx.graphics.Texture;
import com.cake.grafics.VCakeCream;

/**
 * Created by Gerika on 24.02.2016.
 */
public class CakeCream {

        String name;
        float cost;
        VCakeCream cakeCreamViewer;


    public CakeCream(Texture t,String n,float c){

        cakeCreamViewer = new VCakeCream(t);
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


    public void setCakeCreamViewer(VCakeCream c){
        cakeCreamViewer = c;
    }

    public VCakeCream getCakeCreamViewer(){
        return cakeCreamViewer;
    }


    public void dispose(){
        cakeCreamViewer.dispose();


    }

}

