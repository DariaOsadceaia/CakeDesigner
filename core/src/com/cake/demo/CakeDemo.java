package com.cake.demo;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cake.screens.CakeScreen;

public class CakeDemo extends Game {


	public SpriteBatch batch;
	public BitmapFont font;

	@Override
	public void create () {

		batch = new SpriteBatch();
		// Use LibGDX's default Arial font.
		font = new BitmapFont();
		this.setScreen(new CakeScreen(this));

	}

	@Override
	public void render () {

		super.render();

	}

	public void dispose() {
		batch.dispose();
		font.dispose();
	}


}
