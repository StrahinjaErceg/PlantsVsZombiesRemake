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

public abstract class Plant {
	
	private int health;
	private int sunCost;
	private Texture plantText;
	private Sprite plantSprite;
	private String type;
	
	
	//Constuctors
	public Plant(int health, int sunCost, Texture text, String type) {
		setHealth(health);
		setSunCost(sunCost);
		setPlantText(text);
		setType(type);
	}
	
	//Attributes
	
	
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getSunCost() {
		return sunCost;
	}
	public void setSunCost(int sunCost) {
		this.sunCost = sunCost;
	}
	public Texture getPlantText() {
		return plantText;
	}
	public void setPlantText(Texture plantText) {
		this.plantText = plantText;
	}
	public Sprite getPlantSprite() {
		return plantSprite;
	}
	public void setPlantSprite(Sprite plantSprite) {
		this.plantSprite = plantSprite;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}



	

	
	








}
