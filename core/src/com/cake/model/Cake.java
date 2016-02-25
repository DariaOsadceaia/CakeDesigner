package com.cake.model;

/**
 * Created by Gerika on 21.02.2016.
 */
public class Cake {


  CakeBase cakeBase;
  CakeCream cakeCream;
  Extra extra;
  float cost;





    public Cake(CakeBase b,CakeCream c,Extra e){
        cakeBase = b;
        cakeCream = c;
        extra = e;

    }

    public CakeBase getCakeBase(){
        return cakeBase;

    }
    public CakeCream getCakeCream(){
        return cakeCream;
    }

    public void setCakeBase(CakeBase c){

        cakeBase = c;
    }

    public void setCakeCream(CakeCream c){

        cakeCream = c;
    }
    public Extra getExtra(){
        return extra;

    }
    public void setExtra(Extra e){
        extra = e;
    }

    public void setCost(float c){

        cost = c;
    }

    public float getCost(){

        return cost;
    }

    public float calculate(){

        return cakeBase.getCost()+cakeCream.getCost()+extra.getCost();
    }

}
