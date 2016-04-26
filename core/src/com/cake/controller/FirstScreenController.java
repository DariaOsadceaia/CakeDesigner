package com.cake.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.cake.UI.FirstScreenView;
import com.cake.model.FirstScreenModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static com.cake.DataBaseWorker.BasesTableEditor.readBasesTable;
import static com.cake.DataBaseWorker.CreamsTableEditor.readCreamsTable;
import static com.cake.DataBaseWorker.ExtrasTableEditor.readExtrasTable;
import static com.cake.controller.ParametterLoader.*;

/**
 * Created by Gerika on 22.04.2016.
 */
public class FirstScreenController {

    FirstScreenView view;
    FirstScreenModel model;
    Stage stage;

    public boolean toSecondScreen = false;


    public ChangeListener baseSelectBoxListener;
    public ChangeListener creamSelectBoxListener;
    public ChangeListener extraSelectBoxListener;

    public ChangeListener nextScreenButtonListener;




    public FirstScreenController(){



        //here load data from database
        try {
            Class.forName("org.sqlite.JDBC");

            Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement stat = conn.createStatement();

            model = new FirstScreenModel(readBasesTable(conn,stat),readCreamsTable(conn, stat),readExtrasTable(conn, stat));
            model.bases = readBasesTable(conn,stat);
            model.creams = readCreamsTable(conn, stat);
            model.extras = readExtrasTable(conn, stat);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        view = new FirstScreenView(model.bases,model.creams,model.extras);

        stage = view.stage;
        //Gdx.input.setInputProcessor(stage);
        baseSelectBoxListener = new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //here to change image of base


                //and chande current cake
                model.current.setCakeBase(searchBaseForName(model.bases, (String) view.baseSelectBox.getSelected()));
            }
        };

        creamSelectBoxListener = new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //here to change image
                //and change current cake
                model.current.setCakeCream(searchCreamForName(model.creams, (String) view.creamSelectBox.getSelected()));



            }
        };

        extraSelectBoxListener = new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //here  changes image
                //and changes current cake
                model.current.setExtra(searchExtraForName(model.extras, (String) view.extrasSelectBox.getSelected()));

            }
        };


        nextScreenButtonListener = new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                toSecondScreen = true;

            }
        };


        //extract names to SelectBoxes

        view.baseSelectBox.setItems(extractNamesForBases(model.bases));
        view.baseSelectBox.addListener(baseSelectBoxListener);

        view.creamSelectBox.setItems(extractNamesForCreams(model.creams));
        view.creamSelectBox.addListener(creamSelectBoxListener);

        view.extrasSelectBox.setItems(extractNamesForExtras(model.extras));
        view.extrasSelectBox.addListener(extraSelectBoxListener);

        view.nextScreenButton.addListener(nextScreenButtonListener);


    }


    public void control(){

        Gdx.input.setInputProcessor(stage);

        Gdx.gl.glClearColor(0.85f, 0.7f, 0.6f, 0.5f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        view.baseImage.setDrawable(view.skin.getDrawable("base" + model.current.getCakeBase().getId() + "_0"));
        view.creamImage.setDrawable(view.skin.getDrawable("cream" + model.current.getCakeCream().getId()+"_0"));
        view.extraImage.setDrawable(view.skin.getDrawable("extra" + model.current.getExtra().getId() + "_0"));
        view.priceLabel.setText("Price: " + model.current.calculate());
        model.current.setCountOfCakes((int) view.countOfCakesSlider.getValue());
        model.current.setCountOfTiers((int) view.countOfTiers.getValue());
        model.current.setWeight(view.weightSlider.getValue());

        view.forCakeSliderLabel.setText(" "+model.current.getCountOfCakes());
        view.forTierSliderLabel.setText(" " + model.current.getCountOfTiers());
        view.forWeightSliderLabel.setText(" " + model.current.getWeight());

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();




        //super.render(); // important!

    }






}
