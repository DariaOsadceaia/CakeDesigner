package com.cake.model;

import com.badlogic.gdx.utils.Array;
import com.cake.components.Cake;
import com.cake.components.CakeBase;
import com.cake.components.CakeCream;
import com.cake.components.Extra;

/**
 * Created by Gerika on 22.04.2016.
 */
public class FirstScreenModel {

    //This class contains all some stuff from logic of first screen with all its parametters

    //arrays contain parametters
    public Array<CakeBase> bases;
    public Array<CakeCream> creams;
    public Array<Extra> extras;


    public Cake current;


    public FirstScreenModel(Array<CakeBase> b,Array<CakeCream> c,Array<Extra> e) {

        //they get data from database
        bases = b;
        creams = c;
        extras = e;

        //keep all chosen parametters
        current = new Cake(bases.get(0), creams.get(0), extras.get(0));


    }

    public float getCost(){
        return current.calculate();

    }




}
