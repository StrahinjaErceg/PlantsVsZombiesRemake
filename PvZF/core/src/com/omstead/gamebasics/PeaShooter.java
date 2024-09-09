package com.omstead.gamebasics;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

public class PeaShooter extends Plant{
	
	private long peaTimeLaps;
	private long peaPreviousTime = System.currentTimeMillis();
	private ArrayList<Pea> peas = new ArrayList<Pea>();
	
	
	
	//Contructor
	public PeaShooter(int health, int sunCost, Texture text, String type) {
		super(health, sunCost, text, type);
	}

	
	
	//Attributes
	public void createPeas(float x, float y) {
		if(peaTimeLaps >= 1700) {
			peaTimeLaps = 0;
			Pea p1 = new Pea();
			p1.getPeaSprite().setPosition(x, y);
			peas.add(p1);
		}
		
	}
	
	
	
	// Getters and Setters
	public long getPeaTimeLaps() {
		return peaTimeLaps;
	}

	public void setPeaTimeLaps(long peaTimeLaps) {
		this.peaTimeLaps = peaTimeLaps;
	}

	public long getPeaPreviousTime() {
		return peaPreviousTime;
	}

	public void setPeaPreviousTime(long peaPreviousTime) {
		this.peaPreviousTime = peaPreviousTime;
	}

	public ArrayList<Pea> getPeas() {
		return peas;
	}

	public void setPeas(ArrayList<Pea> peas) {
		this.peas = peas;
	}
	
	
	
	
	
	
	
	

	
	

}
