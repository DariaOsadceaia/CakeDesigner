package com.cake.controller;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.cake.components.CakeBase;
import com.cake.components.CakeCream;
import com.cake.components.Component;
import com.cake.components.Extra;
import com.cake.grafics.VCakeBase;
import com.cake.grafics.VCakeCream;
import com.cake.grafics.VExtra;

/**
 * Created by Gerika on 24.04.2016.
 */
public class ParametterLoader {

    //exrtract Names from array with Components
    static public String[] extractNamesForComponents(Array<Component> ar) {
        String[] s = new String[ar.size];
        for (int i = 0; i < ar.size; i++) {

            s[i] = ar.get(i).getName();
        }

        return s;
    }


    static public String[] extractNamesForBases(Array<CakeBase> ar) {
        String[] s = new String[ar.size];
        for (int i = 0; i < ar.size; i++) {

            s[i] = ar.get(i).getName();
        }

        return s;
    }

    static public String[] extractNamesForCreams(Array<CakeCream> ar) {
        String[] s = new String[ar.size];
        for (int i = 0; i < ar.size; i++) {

            s[i] = ar.get(i).getName();
        }

        return s;
    }


    static public String[] extractNamesForExtras(Array<Extra> ar) {
        String[] s = new String[ar.size];
        for (int i = 0; i < ar.size; i++) {

            s[i] = ar.get(i).getName();
        }

        return s;
    }

    //---------------------------------------------------------------------------
    //-----------------------------------------------------------------------------


    //this is bad :(
        //need to fix
    static public CakeBase searchBaseForName(Array<CakeBase> ar,String name){
            CakeBase c = new CakeBase(000, "none", new VCakeBase(new Array<Texture>()),00);
        for(int i=0;i<ar.size;i++){

            if(ar.get(i).getName().equals(name)){

                c = ar.get(i);
                return c;
            }
        }

        return c;
    }


    static public CakeCream searchCreamForName(Array<CakeCream> ar,String name){
        CakeCream c = new CakeCream(000, "none", new VCakeCream(new Array<Texture>()),00);
        for(int i=0;i<ar.size;i++){

            if(ar.get(i).getName().equals(name)){

                c = ar.get(i);
                return c;
            }
        }

        return c;
    }

    static public Extra searchExtraForName(Array<Extra> ar,String name){
        Extra c = new Extra(000, "none", new VExtra(new Array<Texture>()),00);
        for(int i=0;i<ar.size;i++){

            if(ar.get(i).getName().equals(name)){

                c = ar.get(i);
                return c;
            }
        }

        return c;
    }
}
