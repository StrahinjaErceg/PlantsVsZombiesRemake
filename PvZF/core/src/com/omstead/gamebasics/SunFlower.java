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
import java.util.*;


public class SunFlower extends Plant{

	
	private long sunTimeLaps;
	private long sunPreviousTime = System.currentTimeMillis();
	private ArrayList<Sun> groundSuns = new ArrayList<Sun>();
	
	

	
	
	
	
	//Constructors
	public SunFlower(int health, int sunCost, Texture text, String type) {
		super(health, sunCost, text, type);
	}
	
	
	
	
	//Attributes
	public void dropSun(float x, float y) {
		if(sunTimeLaps > 7500) {
			sunTimeLaps = 0;
			Sun s1= new Sun();
			s1.getSunSprite().setPosition(x, y);
			groundSuns.add(s1);
			
		}
		
	}
	



	//Getters and Setters
	public long getSunTimeLaps() {
		return sunTimeLaps;
	}
	public void setSunTimeLaps(long sunTimeLaps) {
		this.sunTimeLaps = sunTimeLaps;
	}
	public long getSunPreviousTime() {
		return sunPreviousTime;
	}
	public void setSunPreviousTime(long sunPreviousTime) {
		this.sunPreviousTime = sunPreviousTime;
	}
	public ArrayList<Sun> getGroundSuns() {
		return groundSuns;
	}
	public void setGroundSuns(ArrayList<Sun> groundSuns) {
		this.groundSuns = groundSuns;
	}





	
	
	
	
	
	
	

	
	
	

	
	

	
	
	
}
