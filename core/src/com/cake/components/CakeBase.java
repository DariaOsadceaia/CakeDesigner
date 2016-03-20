package com.cake.components;

import com.badlogic.gdx.graphics.Texture;
import com.cake.grafics.VCakeBase;

/**
 * Created by Gerika on 21.02.2016.
 */
public class CakeBase extends Component{


    VCakeBase cr;
    String name;
    float cost;



    public CakeBase(Texture t,String n,float c){

        cr = new VCakeBase(t);
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

    public VCakeBase getCakeBaseViewer(){

        return cr;

    }

    public void setCakeBaseViewer(VCakeBase v){

        cr = v;
    }


    public void dispose(){
           cr.dispose();


    }

}
