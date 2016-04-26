package com.cake.demo;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cake.screens.CakeScreen;
import com.cake.screens.InfoScreen;

public class CakeDemo extends Game {


	public SpriteBatch batch;
	public BitmapFont font;
	public CakeScreen firstScreen;
	public InfoScreen secondScreen;

	@Override
	public void create () {

		batch = new SpriteBatch();

		font = new BitmapFont(Gdx.files.internal("bfont.fnt"));
		firstScreen = new CakeScreen(this);
		secondScreen = new InfoScreen(this);
		this.setScreen(firstScreen);

	}

	@Override
	public void render () {

		super.render();

		if(firstScreen.controller.toSecondScreen){

			firstScreen.controller.toSecondScreen = false;
			this.setScreen(secondScreen);
		}
		if(secondScreen.controller.toprevScreen){

			secondScreen.controller.toprevScreen = false;
			this.setScreen(firstScreen);
		}

	}

	public void dispose() {
		batch.dispose();
		font.dispose();
	}


}
