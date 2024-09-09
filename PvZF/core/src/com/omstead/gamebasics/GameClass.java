package com.omstead.gamebasics;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameClass extends Game {
	SpriteBatch batch;
	

	
	
	@Override
	public void create () {
		setScreen(new StartScreen(this));
		batch = new SpriteBatch(); 

		
	}
	
	
	@Override
	public void render () {
		super.render();
		
	}

	
	
}

