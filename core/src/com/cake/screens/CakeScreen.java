package com.cake.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.cake.demo.CakeDemo;
import com.cake.model.*;

/**
 * Created by Gerika on 22.02.2016.
 */
public class CakeScreen implements Screen {


        final CakeDemo cakeDemo;
        OrthographicCamera camera;

        Array<CakeBase> bases;
        Array<CakeCream> creams;
        Array<Extra> extras;
        Cake current;
        int[] counter;
        Array<Arrow> arrows;
        float totalCost;





    public CakeScreen(CakeDemo cakeDem){
        this.cakeDemo = cakeDem;
        arrows = new Array<Arrow>();
        counter = new int[]{0,0,0};
        totalCost = 0;




        //create and add bases
        bases = new Array<CakeBase>();
        bases.add(new CakeBase(new Texture(Gdx.files.internal("limobase.png")),"Lemon",20.0f));
        bases.add(new CakeBase(new Texture(Gdx.files.internal("chokobase.png")),"Choko",20.0f));
        bases.add(new CakeBase(new Texture(Gdx.files.internal("chokobase.png")),"Choko with nuts",25.0f));
        bases.add(new CakeBase(new Texture(Gdx.files.internal("jel.png")), "Marcipan",30.0f));
        bases.add(new CakeBase(new Texture(Gdx.files.internal("orange.png")), "Orange fluid",20.0f));



        //create and add creams
        creams = new Array<CakeCream>();

        creams.add(new CakeCream(new Texture(Gdx.files.internal("milkcream.png")), "Milk ",10.0f));
        creams.add(new CakeCream(new Texture(Gdx.files.internal("nutscream.png")), "Nuts ",12.0f));
        creams.add(new CakeCream(new Texture(Gdx.files.internal("chokocream.png")), "Chokolate ",15.0f));
        creams.add(new CakeCream(new Texture(Gdx.files.internal("fis.png")), "Pistachio ",25.0f));
        creams.add(new CakeCream(new Texture(Gdx.files.internal("mal.png")), "Strawberry Cream ",12.0f));

        //other design for cake - berrys,nuts...
        extras = new Array<Extra>();
        extras.add(new Extra(new Texture(Gdx.files.internal("cherrys.png")), "Cherry ",7.0f));
        extras.add(new Extra(new Texture(Gdx.files.internal("strawberrys.png")), "Strawberry ",7.0f));
        extras.add(new Extra(new Texture(Gdx.files.internal("zero.png")), "None ",0.0f));


        current = new Cake(bases.get(0),creams.get(0),extras.get(0));

        //for bases
        arrows.add(new Arrow(new Texture(Gdx.files.internal("str4.png")), new Rectangle(20, 420, 25, 35)));
        arrows.add(new Arrow(new Texture(Gdx.files.internal("str4_1.png")), new Rectangle(310, 420, 25, 35)));

        //for creams
        arrows.add(new Arrow(new Texture(Gdx.files.internal("str4.png")), new Rectangle(20, 380, 25, 35)));
        arrows.add(new Arrow(new Texture(Gdx.files.internal("str4_1.png")), new Rectangle(310, 380, 25, 35)));

        //for extras
        arrows.add(new Arrow(new Texture(Gdx.files.internal("str4.png")), new Rectangle(20, 340, 25, 35)));
        arrows.add(new Arrow(new Texture(Gdx.files.internal("str4_1.png")), new Rectangle(310, 340, 25, 35)));



        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);


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

        // begin a new batch and draw the base and cream
        cakeDemo.batch.begin();
        //draw all arrows
        for(Arrow a: arrows) {
            cakeDemo.batch.draw(a.getImage(), a.getPosition().x, a.getPosition().y);

        }
        cakeDemo.font.draw(cakeDemo.batch, "Base: ", 55, 470);
        cakeDemo.font.draw(cakeDemo.batch,current.getCakeBase().getName() ,55,450);
        cakeDemo.batch.draw(current.getCakeBase().getImage(),current.getCakeBase().getPosition().x,current.getCakeBase().getPosition().y);

        cakeDemo.font.draw(cakeDemo.batch, "Cream: ", 55, 430);
        cakeDemo.font.draw(cakeDemo.batch,current.getCakeCream().getName() ,55,410);
        cakeDemo.batch.draw(current.getCakeCream().getImage(),current.getCakeCream().getPosition().x,current.getCakeCream().getPosition().y);

        cakeDemo.font.draw(cakeDemo.batch, "Extra: ", 55, 390);
        cakeDemo.font.draw(cakeDemo.batch,current.getExtra().getName() ,55,370);
        cakeDemo.batch.draw(current.getExtra().getImage(),current.getExtra().getPosition().x,current.getExtra().getPosition().y);


        cakeDemo.font.draw(cakeDemo.batch, "Total cost: "+current.calculate(), 55, 100);


        // process user input
        if (Gdx.input.justTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            for(int i=0;i<arrows.size;i++){
                if(arrows.get(i).getPosition().contains(touchPos.x,touchPos.y)) {
                    if(i==0&&counter[i]>0) {
                        counter[i]--;
                        current.setCakeBase(bases.get(counter[i]));


                    }
                    if(i==1&&counter[i-1]<bases.size-1) {
                        counter[i-1]++;
                        current.setCakeBase(bases.get(counter[i - 1]));

                    }
                    if(i==2&&counter[i-1]>0){
                        counter[i-1]--;
                        current.setCakeCream(creams.get(counter[i - 1]));


                    }
                    if(i==3&&counter[i-2]<creams.size-1) {
                        counter[i-2]++;
                        current.setCakeCream(creams.get(counter[i - 2]));

                    }
                    if(i==4&&counter[i-2]>0) {
                        counter[i-2]--;
                        current.setExtra(extras.get(counter[i - 2]));

                    }
                    if(i==5&&counter[i-3]<extras.size-1) {
                        counter[i-3]++;
                        current.setExtra(extras.get(counter[i - 3]));

                    }




            }

            }

            cakeDemo.batch.draw(current.getCakeBase().getImage(),current.getCakeBase().getPosition().x,current.getCakeBase().getPosition().y);
            cakeDemo.batch.draw(current.getCakeCream().getImage(),current.getCakeCream().getPosition().x,current.getCakeCream().getPosition().y);
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

       for (CakeBase c: bases) {
            c.dispose();
        }
        for (CakeCream c: creams) {
            c.dispose();
        }
        for (Extra c: extras) {
            c.dispose();
        }





    }
}




