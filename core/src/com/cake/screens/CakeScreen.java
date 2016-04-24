package com.cake.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.cake.controller.FirstScreenController;
import com.cake.demo.CakeDemo;

/**
 * Created by Gerika on 22.02.2016.
 */
public class CakeScreen implements Screen {


        final CakeDemo cakeDemo;
        OrthographicCamera camera;

        FirstScreenController controller;

    public CakeScreen(CakeDemo cakeDem){
        this.cakeDemo = cakeDem;


        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        controller  = new FirstScreenController();



    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        // clear the screen with a color. The
        // arguments to glClearColor are the red, green
        // blue and alpha component in the range [0,1]
        // of the color to be used to clear the screen.
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




