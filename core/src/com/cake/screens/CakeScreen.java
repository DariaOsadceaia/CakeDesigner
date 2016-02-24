package com.cake.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.cake.controller.CakeController;
import com.cake.demo.CakeDemo;
import com.cake.view.CakeBaseRender;

import java.awt.*;

/**
 * Created by Gerika on 22.02.2016.
 */
public class CakeScreen implements Screen {


        final CakeDemo cakeDemo;
        OrthographicCamera camera;

        //CakeBase base;
        CakeController controller;
        CakeBaseRender render;
        Texture chokobase;
        Texture limobase;
        Rectangle base;


    private int width, height;


    public CakeScreen(CakeDemo cakeDem){
        this.cakeDemo = cakeDem;
        chokobase = new Texture(Gdx.files.internal("chokobase.png"));
        limobase = new Texture(Gdx.files.internal("limobase.png"));

        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);


        // create a Rectangle to logically represent the bucket
        base = new Rectangle();
        base.x = 800 / 2 - 100 / 2; // center the bucket horizontally
        base.y = 400 / 2 - 64 / 2; // bottom left corner of the bucket is 20 pixels above
        // the bottom screen edge
        base.width = 64;
        base.height = 64;

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        // clear the screen with a dark blue color. The
        // arguments to glClearColor are the red, green
        // blue and alpha component in the range [0,1]
        // of the color to be used to clear the screen.
        Gdx.gl.glClearColor(0.2f, 0.1f, 0.2f, 0.2f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // tell the camera to update its matrices.
        camera.update();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        cakeDemo.batch.setProjectionMatrix(camera.combined);

        // begin a new batch and draw the bucket and
        // all drops
        cakeDemo.batch.begin();
        cakeDemo.font.draw(cakeDemo.batch, "Your Cake: ", 0, 480);
        cakeDemo.batch.draw(chokobase, base.x, base.y);

        // process user input
        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            cakeDemo.batch.draw(limobase, base.x, base.y);
        }
        cakeDemo.batch.end();



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


        chokobase.dispose();
        limobase.dispose();

    }
}




