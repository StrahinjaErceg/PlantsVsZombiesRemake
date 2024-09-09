package com.omstead.gamebasics;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Sun {
	

	static int sunPoints = 0;
	private int sunSpeed = -5;
	private Texture sunTexture = new Texture("suns.png");
	private Sprite sunSprite = new Sprite(sunTexture);
	private int randSunY = (int) ((Math.random()*150) + 50);
	


	

	// Getters and Setters
	public Sprite getSunSprite() {
		return sunSprite;
	}
	public void setSunSprite(Sprite sunSprite) {
		this.sunSprite = sunSprite;
	}
	public Texture getSunTexture() {
		return sunTexture;
	}
	public void setSunTexture(Texture sunTexture) {
		this.sunTexture = sunTexture;
	}
	public int getSunSpeed() {
		return sunSpeed;
	}
	public void setSunSpeed(int sunSpeed) {
		this.sunSpeed = sunSpeed;
	}
	public int getRandSunY() {
		return randSunY;
	}
	public void setRandSunY(int randSunY) {
		this.randSunY = randSunY;
	}
	

	
	
	
	

}
