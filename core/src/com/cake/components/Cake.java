package com.cake.components;

/**
 * Created by Gerika on 21.02.2016.
 */
public class Cake {


  CakeBase cakeBase;
  CakeCream cakeCream;
  Extra extra;

  boolean isTiersApart;
  int countOfTiers;
  //CakeForm form;
  float weight;
  int countOfCakes;


    public Cake(CakeBase b,CakeCream c,Extra e){
        cakeBase = b;
        cakeCream = c;
        extra = e;
        weight = 1;
        countOfTiers = 1;
        countOfCakes = 1;

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





    public float calculate(){

        return cakeBase.getCost()+cakeCream.getCost()+extra.getCost();
    }


    public void setTiersApart(boolean t){

        isTiersApart= t;
    }

    public boolean isTiersApart(){

        return isTiersApart;
    }

    public int getCountOfTiers(){

        return countOfTiers;
    }

    public void setCountOfTiers(int c){

        countOfTiers = c;
    }

    public void setCountOfCakes(int c){

        countOfCakes = c;
    }

    public int getCountOfCakes(){

        return countOfCakes;
    }

    public float getWeight(){

        return weight;
    }

    public void setWeight(int w){
        weight = w;

    }

}
