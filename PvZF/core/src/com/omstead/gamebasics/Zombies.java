package com.omstead.gamebasics;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.*;

public class Zombies implements IZombie{
	
	static float zombSpeed = -0.35f; 
	private Texture zombText = new Texture("zombie.png");
	private Sprite zombSprite = new Sprite(zombText);
	private int zombHP;
	private Rectangle zombRect = zombSprite.getBoundingRectangle();
	
	

	
	//Attributes
	@Override
	public void move() {
		zombSprite.translateX(zombSpeed);
		
	}

	@Override
	public void attack(Plant plant) {
		plant.setHealth(plant.getHealth()-25);
	
	}
	
	//Getters and Setters
		public Rectangle getZombRect() {
			return zombRect;
		}

		public void setZombRect(Rectangle zombRect) {
			this.zombRect = zombRect;
		}

		public int getZombHP() {
			return zombHP;
		}

		public void setZombHP(int zombHP) {
			this.zombHP = zombHP;
		}

		public Texture getZombText() {
			return zombText;
		}

		public void setZombText(Texture zombText) {
			this.zombText = zombText;
		}

		public Sprite getZombSprite() {
			return zombSprite;
		}

		public void setZombSprite(Sprite zombSprite) {
			this.zombSprite = zombSprite;
		}

	

}
