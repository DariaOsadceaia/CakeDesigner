package com.cake.model;

/**
 * Created by Gerika on 21.02.2016.
 */
public class Cake {


  CakeBase cakeBase;
  CakeCream cakeCream;

    public Cake(CakeBase b,CakeCream c){
        cakeBase = b;
        cakeCream = c;


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

}
