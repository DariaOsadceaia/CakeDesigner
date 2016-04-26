package com.cake.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.cake.UI.SecondScreenView;
import com.cake.model.SecondScreenModel;



/**
 * Created by Gerika on 26.04.2016.
 */
public class SecondScreenController {

    Stage stage;
    SecondScreenView view;
    SecondScreenModel model;
    TextField.TextFieldListener nameListener;
    ChangeListener prevButtonListener;
    public boolean toprevScreen=false;


    public  SecondScreenController(){



        view = new SecondScreenView();
        model = new SecondScreenModel();

        stage = view.stage;
        //Gdx.input.setInputProcessor(stage);
        nameListener = new TextField.TextFieldListener() {
            @Override
            public void keyTyped(TextField textField, char c) {

               textField.getOnscreenKeyboard().show(true);

            }
        };

        prevButtonListener = new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                toprevScreen = true;
            }

        };



        view.nameField.setTextFieldListener(nameListener);
        view.previousScreenButton.addListener(prevButtonListener);





    }

    public void control(){

        Gdx.input.setInputProcessor(stage);

        Gdx.gl.glClearColor(0.85f, 0.7f, 0.6f, 0.5f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();



    }

}
