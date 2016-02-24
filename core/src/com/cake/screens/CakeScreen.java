package com.cake.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.cake.controller.CakeController;
import com.cake.demo.CakeDemo;
import com.cake.model.Cake;
import com.cake.model.CakeBase;
import com.cake.model.CakeCream;
import com.cake.view.CakeBaseRender;

/**
 * Created by Gerika on 22.02.2016.
 */
public class CakeScreen implements Screen {


        final CakeDemo cakeDemo;
        OrthographicCamera camera;

        //CakeBase base;
        CakeController controller;
        CakeBaseRender render;
        Array<Cake> cakes;
        CakeBase current;
        int counter = 0;



    public CakeScreen(CakeDemo cakeDem){
        this.cakeDemo = cakeDem;


        //create and add bases
        cakes = new Array<Cake>();
        cakes.add(new Cake(new CakeBase(new Texture(Gdx.files.internal("limobase.png")),"Lemon"),new CakeCream(new Texture(Gdx.files.internal("milkcream.png")),"Milk Cream")));
        cakes.add(new Cake(new CakeBase(new Texture(Gdx.files.internal("chokobase.png")),"Choko"),new CakeCream(new Texture(Gdx.files.internal("nutscream.png")),"Nuts Cream")));
        cakes.add(new Cake(new CakeBase(new Texture(Gdx.files.internal("chokobase.png")),"Choko with nuts"),new CakeCream(new Texture(Gdx.files.internal("milkcream.png")),"Milk Cream")));
        cakes.add(new Cake(new CakeBase(new Texture(Gdx.files.internal("limobase.png")), "Marcipan"),new CakeCream(new Texture(Gdx.files.internal("milkcream.png")),"Milk Cream")));
        cakes.add(new Cake(new CakeBase(new Texture(Gdx.files.internal("limobase.png")), "Orange fluid"),new CakeCream(new Texture(Gdx.files.internal("milkcream.png")),"Milk Cream")));
        //return any element from Cakebase
      //  current = cakes.first();


        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);


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
        Gdx.gl.glClearColor(0.9f,0.7f,0.6f, 0.5f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // tell the camera to update its matrices.
        camera.update();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        cakeDemo.batch.setProjectionMatrix(camera.combined);

        // begin a new batch and draw the bucket and
        // all drops
        cakeDemo.batch.begin();
        cakeDemo.font.draw(cakeDemo.batch, "Your Base: ", 0, 480);
        cakeDemo.font.draw(cakeDemo.batch,current.getName() ,0,460);
        cakeDemo.batch.draw(current.getImage(),current.getPosition().x,current.getPosition().y);

        // process user input
      /*  if (Gdx.input.justTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            if(touchPos.x<current.getPosition().x&&counter>0){

                counter--;
                current = bases.get(counter);



            }
            if(touchPos.x>current.getPosition().x&&counter<bases.size-1){

                counter++;
                current = bases.get(counter);


            }
            cakeDemo.batch.draw(current.getImage(),current.getPosition().x,current.getPosition().y);
        }
        cakeDemo.batch.end();

*/

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

   /*     for (CakeBase c: bases) {
            c.dispose();
        }*/



    }
}




