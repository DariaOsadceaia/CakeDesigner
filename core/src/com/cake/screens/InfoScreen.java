package com.cake.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.cake.UI.SecondScreenView;
import com.cake.controller.SecondScreenController;
import com.cake.demo.CakeDemo;
import com.cake.model.SecondScreenModel;

/**
 * Created by Gerika on 26.04.2016.
 */
public class InfoScreen implements Screen {


    final CakeDemo cakeDemo;
    OrthographicCamera camera;
    public SecondScreenController controller;
    SecondScreenView view;
    SecondScreenModel model;

    public InfoScreen(CakeDemo cakeDem){

        this.cakeDemo = cakeDem;
    //    model = new SecondScreenModel();
   //     view = new SecondScreenView();
    //    controller = new SecondScreenController();

        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);


        view = new SecondScreenView();
        controller = new SecondScreenController();

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {


        Gdx.gl.glClearColor(0.9f, 0.7f, 0.6f, 0.5f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // tell the camera to update its matrices.
        camera.update();
        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        cakeDemo.batch.setProjectionMatrix(camera.combined);
        controller.control();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
