package com.cake.components;

import com.cake.grafics.VisualComponent;

/**
 * Created by Gerika on 20.03.2016.
 */
public class Component {

    VisualComponent visualComponent;

    String name;
    float cost;
    int id;

    public Component(){
        visualComponent = new VisualComponent();
        cost = 0.00f;
        name = "";
        id = 0;
    }

    public Component(int i,String n,VisualComponent t,float c){

        visualComponent = t;
        cost = c;

        name = n;
        id = i;

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

    public VisualComponent getViewer(){

        return visualComponent;

    }

    public void setViewer(VisualComponent v){

        visualComponent = v;
    }

    public int getId(){

        return id;
    }
    public void setId(int i){

        id = i;
    }


    public void dispose(){
        visualComponent.dispose();


    }






}
