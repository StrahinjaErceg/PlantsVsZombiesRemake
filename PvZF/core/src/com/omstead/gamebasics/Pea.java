package com.omstead.gamebasics;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Pea {
	
	
	
	
	static int peaSpeed = 2;
	private Texture peaTexture = new Texture("pea.png");
	private Sprite peaSprite = new Sprite(peaTexture);
	private Rectangle peaRect = peaSprite.getBoundingRectangle();
	
	
	
	
	
	
	

	//Getters and Setters
	public Texture getPeaTexture() {
		return peaTexture;
	}
	public void setPeaTexture(Texture peaTexture) {
		this.peaTexture = peaTexture;
	}
	public Sprite getPeaSprite() {
		return peaSprite;
	}
	public void setPeaSprite(Sprite peaSprite) {
		this.peaSprite = peaSprite;
	}
	public Rectangle getPeaRect() {
		return peaRect;
	}
	public void setPeaRect(Rectangle peaRect) {
		this.peaRect = peaRect;
	}
	
	
	
	
}
