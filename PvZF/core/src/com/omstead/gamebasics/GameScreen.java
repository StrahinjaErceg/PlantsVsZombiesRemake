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

public class GameScreen implements Screen, InputProcessor {
	GameClass game;
	Sprite backgroundSprite;
	
	//Mouse
	int mouseX;
	int mouseY;
	
	//Time
	long timeLapse;
	long previousTime;
	
	long waveTimeLapse;
	long wavePreviousTime;
	
	
	//Array
	ArrayList<Sun> sunList = new ArrayList<Sun>();
	
	//Interface For Cards
	Sprite brownBox;
	Sprite sunPointsSp;
	
	//Card Sprite
	Sprite peaShooterCard;
	Sprite peaShooterGrayCard;
	Sprite sunFlowerCard;
	Sprite sunFlowerGrayCard;
	Sprite walnutCard;
	Sprite walnutGrayCard;	
	Sprite sunPointsSunSp;
	
	
	//Plant Stuff
	ArrayList<Plant> tempPlants = new ArrayList<Plant>();
	ArrayList<Plant> plantList = new ArrayList<Plant>();
	
	
	//Dragging Plants Boolean
	Boolean makeSunFlower = false;
	Boolean moveSunFlower = false;
	
	Boolean makePeaShooter = false;
	Boolean movePeaShooter = false;
	
	Boolean makeWalnut = false;
	Boolean moveWalnut = false;
	
	
	//Grid stuff
	Plant[][] grid = new Plant[5][9];
	
	//Keep the x and y coordinates of grid positions
	int[][] gridX = {{292, 370, 450, 535, 615, 700, 775, 855, 946},
			         {292, 370, 450, 535, 615, 700, 775, 855, 946},
			         {292, 370, 450, 535, 615, 700, 775, 855, 946},
			         {292, 370, 450, 535, 615, 700, 775, 855, 946},
			         {292, 370, 450, 535, 615, 700, 775, 855, 946}};
	
	
	
	int[][] gridY = {{470, 470, 470, 470, 470, 470, 470, 470, 470},
					 {372, 372, 372, 372, 372, 372, 372, 372, 372},
					 {273, 273, 273, 273, 273, 273, 273, 273, 273},
					 {174, 174, 174, 174, 174, 174, 174, 174, 174}, 
					 {77, 77, 77, 77, 77, 77, 77, 77, 77}};
	
	
	//Writing 
	BitmapFont font;
	BitmapFont fontW;
	
	
	//Zombie Stuff
	ArrayList<IZombie> zList = new ArrayList<IZombie>();
	
	
	
	//Waves
	boolean wave = true;
	
	
	//ArrayLsit of peas
	ArrayList<Sprite> totalPeas = new ArrayList<Sprite>();
	
	//Explosion Sprite
	Sprite explosionSprite;
	Boolean explosionBool = false;
	
	//Wave Counter
	int waveCounter = 1;
	

	
	
	
	
	
	
	public GameScreen(GameClass game) {
		this.game = game;
	}
	
	@Override
	public void show () {
		
		//Setting The Background
		Texture backText = new Texture("PvZMap.jpg");	
		backgroundSprite = new Sprite(backText);			
		backgroundSprite.setPosition(0, 0);	
		
		// Initiate Time
		previousTime = System.currentTimeMillis(); 
		wavePreviousTime = System.currentTimeMillis(); 
		
		//Making Menu Sprite
		Texture brownBoxText = new Texture("brownBox.jpg");	
		brownBox = new Sprite(brownBoxText);				
		brownBox.setPosition(45, 50);	
		
		Texture sunPointsText = new Texture("sunPointScreen.jpg");	
		sunPointsSp = new Sprite(sunPointsText);				
		sunPointsSp.setPosition(52, 496);
		
		Texture sunPointsSunText = new Texture("suns.png");	
		sunPointsSunSp = new Sprite(sunPointsSunText);				
		sunPointsSunSp.setPosition(64, 505);


		//Making Card Sprites
		Texture peaShooterGrayCardText = new Texture("peaShooterGrayCard.png");	
		peaShooterGrayCard = new Sprite(peaShooterGrayCardText);				
		peaShooterGrayCard.setPosition(60,365);	
		
		Texture sunFlowerGrayCardText = new Texture("sunFlowerGrayCard.png");	
		sunFlowerGrayCard = new Sprite(sunFlowerGrayCardText);				
		sunFlowerGrayCard.setPosition(60, 225);	
		
		Texture walnutGrayCardText = new Texture("walnutGrayCard.png");	
		walnutGrayCard = new Sprite(walnutGrayCardText);				
		walnutGrayCard.setPosition(60, 75);	
		
		//Font stuff
		font = new BitmapFont();
		fontW = new BitmapFont();
		
		//ColourCards
		Texture sunFlowerCardText = new Texture("sunFlowerCard.png");	
		sunFlowerCard = new Sprite(sunFlowerCardText);				
		sunFlowerCard.setPosition(60, 225);	
		
		Texture walnutCardText = new Texture("walnutCard.png");	
		walnutCard = new Sprite(walnutCardText);				
		walnutCard.setPosition(60, 75);	
	

		Texture peaShooterCardText = new Texture("peaShooterCard.png");	
		peaShooterCard = new Sprite(peaShooterCardText);				
		peaShooterCard.setPosition(60,365);	
		
		
		
		
		
	}

	
	@Override
	public void render (float delta) {
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//Timer Stuff
		timeLapse += System.currentTimeMillis() - previousTime; 
		previousTime = System.currentTimeMillis(); 
		
		
	
		
		//Mouse Tracker
		int mouseX = Gdx.input.getX();
		int mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();
		
		
		
		//Sun Stuff
		if(timeLapse > 3500) {
			timeLapse = 0;
			
			Sun s1 = new Sun();
			s1.getSunSprite().setPosition((int)((Math.random()*720) + 252), (int)(Math.random() + 650));
			sunList.add(s1);
		}
		
		for(int i= sunList.size()-1; i >= 0; i--) {
			sunList.get(i).getSunSprite().translateY(sunList.get(i).getSunSpeed());
			
			//Stops sun at random point
			if(sunList.get(i).getSunSprite().getY() < sunList.get(i).getRandSunY() ) {
				sunList.get(i).getSunSprite().translateY(-(sunList.get(i).getSunSpeed()));
			}
			
			//Detects if mouse touches the sun and adds points
			if(moveWalnut == false && movePeaShooter == false && moveSunFlower == false && mouseX > sunList.get(i).getSunSprite().getX() && mouseX < sunList.get(i).getSunSprite().getX() + 64 && mouseY > sunList.get(i).getSunSprite().getY() && mouseY < sunList.get(i).getSunSprite().getY() + 64) {
				sunList.remove(i);
				Sun.sunPoints += 25;
			}
		} 
		
		//SunPoints
		String tempString = "" + Sun.sunPoints;
		CharSequence str = tempString;
		font.setColor(0, 0, 0, 1);
		

		
		//Spawn SunFlower
		if(Sun.sunPoints >= 50 && mouseX > 60 && mouseX < 130 && mouseY > 228 && mouseY < 330) {
			if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
				makeSunFlower = true;
	
			}
		}
		
		if(makeSunFlower) {
			Plant p1 = new SunFlower(100, 50, new Texture("sunFlower.png"), "SunFlower");
			p1.setPlantSprite(new Sprite(p1.getPlantText()));
			
			tempPlants.add(p1);
			
			moveSunFlower = true;
			makeSunFlower = false;	
		}
		
		if(moveSunFlower && Gdx.input.isButtonPressed(Input.Buttons.LEFT) ) {
			tempPlants.get(tempPlants.size() - 1).getPlantSprite().setPosition((float) (mouseX - 0.5 * tempPlants.get(tempPlants.size() - 1).getPlantSprite().getWidth()), (float) (mouseY - 0.5 * tempPlants.get(tempPlants.size() - 1).getPlantSprite().getHeight()));
		}
		
		if(moveSunFlower && !Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			int tempMouseX = Gdx.input.getX();
			int tempMouseY = Gdx.graphics.getHeight() - Gdx.input.getY();
			int tempXDiff = 10000;
			int tempYDiff = 10000;
			int tempI = 0;
			int tempJ = 0;
			
			for(int i = 0; i < gridX.length; i++) {
				for(int j = 0; j < gridX[i].length; j++) {
					
					if((Math.abs(gridX[i][j]- tempMouseX)) < tempXDiff ) {
						tempXDiff = (Math.abs(gridX[i][j]- tempMouseX));
						tempJ = j;
						
					}
				}
				
			}
			
			for(int i = 0; i < gridY.length; i++) {
				for(int j = 0; j < gridY[i].length; j++) {
					
					if((Math.abs(gridY[i][j] - tempMouseY)) < tempYDiff ) {
						tempYDiff = (Math.abs(gridY[i][j]- tempMouseY));
						tempI = i;
					
					}
				}
				
			}
			
			if(grid[tempI][tempJ] == null) {
				grid[tempI][tempJ] = new SunFlower(200, 50, new Texture("sunFlower.png"), "SunFlower");
				grid[tempI][tempJ].setPlantSprite(new Sprite(grid[tempI][tempJ].getPlantText()));
				grid[tempI][tempJ].getPlantSprite().setPosition(gridX[tempI][tempJ] - 50, gridY[tempI][tempJ] - 50);
				Sun.sunPoints -= 50;
			
				
			}
			
			tempPlants.remove(tempPlants.size() - 1);
			moveSunFlower = false;
		}
		
		
		
		
		//Spawn PeaShooter
		if(Sun.sunPoints >= 100 && mouseX > 60 && mouseX < 130 && mouseY > 368 && mouseY < 468) {
			if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
				makePeaShooter = true;
			
			}
		}
		
		if(makePeaShooter) {
			Plant p1 = new PeaShooter(100, 50, new Texture("peaShooter.png"), "PeaShooter");
			p1.setPlantSprite(new Sprite(p1.getPlantText()));
			
			tempPlants.add(p1);
			
			movePeaShooter = true;
			makePeaShooter= false;	
		}
		
		if(movePeaShooter && Gdx.input.isButtonPressed(Input.Buttons.LEFT) ) {
			tempPlants.get(tempPlants.size() - 1).getPlantSprite().setPosition((float) (mouseX - 0.5 * tempPlants.get(tempPlants.size() - 1).getPlantSprite().getWidth()), (float) (mouseY - 0.5 * tempPlants.get(tempPlants.size() - 1).getPlantSprite().getHeight()));
		}
		
		if(movePeaShooter && !Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			int tempMouseX = Gdx.input.getX();
			int tempMouseY = Gdx.graphics.getHeight() - Gdx.input.getY();
			int tempXDiff = 10000;
			int tempYDiff = 10000;
			int tempI = 0;
			int tempJ = 0;
			
			for(int i = 0; i < gridX.length; i++) {
				for(int j = 0; j < gridX[i].length; j++) {
					
					if((Math.abs(gridX[i][j]- tempMouseX)) < tempXDiff ) {
						tempXDiff = (Math.abs(gridX[i][j]- tempMouseX));
						tempJ = j;
						
					}
				}
				
			}
			
			for(int i = 0; i < gridY.length; i++) {
				for(int j = 0; j < gridY[i].length; j++) {
					
					if((Math.abs(gridY[i][j] - tempMouseY)) < tempYDiff ) {
						tempYDiff = (Math.abs(gridY[i][j]- tempMouseY));
						tempI = i;
						
					}
				}
				
			}
			
			if(grid[tempI][tempJ] == null) {
				grid[tempI][tempJ] = new PeaShooter(600, 50, new Texture("peaShooter.png"), "PeaShooter");
				grid[tempI][tempJ].setPlantSprite(new Sprite(grid[tempI][tempJ].getPlantText()));
				grid[tempI][tempJ].getPlantSprite().setPosition(gridX[tempI][tempJ] - 50, gridY[tempI][tempJ] - 50);
				Sun.sunPoints -= 100;
				
			}
			
			tempPlants.remove(tempPlants.size() - 1);
			movePeaShooter = false;
		}
		
		
		
		//Spawn Walnuts
		if(Sun.sunPoints >= 50 && mouseX > 60 && mouseX < 130 && mouseY > 78 && mouseY < 180) {
			if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
				makeWalnut = true;
			}
		}
		
		if(makeWalnut) {
			Plant p1 = new Walnut(100, 50, new Texture("walnut1.png"), "Walnut");
			p1.setPlantSprite(new Sprite(p1.getPlantText()));
			
			tempPlants.add(p1);
			
			moveWalnut = true;
			makeWalnut = false;	
		}
		
		if(moveWalnut && Gdx.input.isButtonPressed(Input.Buttons.LEFT) ) {
			tempPlants.get(tempPlants.size() - 1).getPlantSprite().setPosition((float) (mouseX - 0.5 * tempPlants.get(tempPlants.size() - 1).getPlantSprite().getWidth()), (float) (mouseY - 0.5 * tempPlants.get(tempPlants.size() - 1).getPlantSprite().getHeight()));
		}
		
		if(moveWalnut && !Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			int tempMouseX = Gdx.input.getX();
			int tempMouseY = Gdx.graphics.getHeight() - Gdx.input.getY();
			int tempXDiff = 10000;
			int tempYDiff = 10000;
			int tempI = 0;
			int tempJ = 0;
			
			for(int i = 0; i < gridX.length; i++) {
				for(int j = 0; j < gridX[i].length; j++) {
					
					if((Math.abs(gridX[i][j]- tempMouseX)) < tempXDiff ) {
						tempXDiff = (Math.abs(gridX[i][j]- tempMouseX));
						tempJ = j;
						
					}
				}
				
			}
			
			for(int i = 0; i < gridY.length; i++) {
				for(int j = 0; j < gridY[i].length; j++) {
					
					if((Math.abs(gridY[i][j] - tempMouseY)) < tempYDiff ) {
						tempYDiff = (Math.abs(gridY[i][j]- tempMouseY));
						tempI = i;
						
					}
				}
				
			}
			
			if(grid[tempI][tempJ] == null) {
				grid[tempI][tempJ] = new Walnut(2000, 50, new Texture("walnut1.png"), "Walnut");
				grid[tempI][tempJ].setPlantSprite(new Sprite(grid[tempI][tempJ].getPlantText()));
				grid[tempI][tempJ].getPlantSprite().setPosition(gridX[tempI][tempJ] - 50, gridY[tempI][tempJ] - 50);
				Sun.sunPoints -= 50;
				
			}
			
			tempPlants.remove(tempPlants.size() - 1);
			moveWalnut = false;
		}
		
		
		
		
		//Code for making suns from the SunFlowers
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] != null && grid[i][j].getType().equalsIgnoreCase("SunFlower")) {
					
					((SunFlower) grid[i][j]).setSunTimeLaps(((SunFlower) grid[i][j]).getSunTimeLaps() + System.currentTimeMillis() - ((SunFlower) grid[i][j]).getSunPreviousTime()); 
					((SunFlower) grid[i][j]).setSunPreviousTime(System.currentTimeMillis());
					
					
					((SunFlower) grid[i][j]).dropSun(grid[i][j].getPlantSprite().getX(), grid[i][j].getPlantSprite().getY());
					
					
					for(int k = 0; k < ((SunFlower)grid[i][j]).getGroundSuns().size(); k++) {
						if(moveWalnut == false && movePeaShooter == false && moveSunFlower == false && mouseX > ((SunFlower)grid[i][j]).getGroundSuns().get(k).getSunSprite().getX() && mouseX < ((SunFlower)grid[i][j]).getGroundSuns().get(k).getSunSprite().getX() + 64 && mouseY > ((SunFlower)grid[i][j]).getGroundSuns().get(k).getSunSprite().getY() && mouseY < ((SunFlower)grid[i][j]).getGroundSuns().get(k).getSunSprite().getY() + 64) {
							((SunFlower)grid[i][j]).getGroundSuns().remove(k);
							Sun.sunPoints += 25;
							
						}
					}
					
					//Sun and Zombie Collision
					Rectangle sunFlowerRect = ((SunFlower) grid[i][j]).getPlantSprite().getBoundingRectangle();
					
					for(int l = zList.size() -1; l >= 0; l--) {
						Rectangle zombRect = ((Zombies) zList.get(l)).getZombSprite().getBoundingRectangle();							
						if(sunFlowerRect.overlaps(zombRect)) {
							((Zombies) zList.get(l)).getZombSprite().translateX(-Zombies.zombSpeed);
							(grid[i][j]).setHealth((grid[i][j]).getHealth() - 25);
						}
				
					}
				}
			}		
		}
		
		
		//Code for making peas from PeaShooter shoot
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] != null && grid[i][j].getType().equalsIgnoreCase("PeaShooter")) {
					
					((PeaShooter) grid[i][j]).setPeaTimeLaps(((PeaShooter) grid[i][j]).getPeaTimeLaps() + System.currentTimeMillis() - ((PeaShooter) grid[i][j]).getPeaPreviousTime()); 
					((PeaShooter) grid[i][j]).setPeaPreviousTime(System.currentTimeMillis());
					
					
					((PeaShooter) grid[i][j]).createPeas(grid[i][j].getPlantSprite().getX() + 44, grid[i][j].getPlantSprite().getY()+62);
					
					
					
					for(int k = ((PeaShooter)grid[i][j]).getPeas().size() - 1; k >= 0; k--) {
						((PeaShooter)grid[i][j]).getPeas().get(k).getPeaSprite().translateX(Pea.peaSpeed);
						
						//Zombie and Bullets Collisions
						if(((PeaShooter) grid[i][j]).getPeas().get(k) != null) {
							Rectangle peaRect = ((PeaShooter)grid[i][j]).getPeas().get(k).getPeaSprite().getBoundingRectangle();
							for(int l = zList.size() -1; l >= 0; l--) {
								Rectangle zombRect = ((Zombies) zList.get(l)).getZombSprite().getBoundingRectangle();							
								if(peaRect.overlaps(zombRect)) {
									((PeaShooter)grid[i][j]).getPeas().remove(k);
									((Zombies) zList.get(l)).setZombHP(((Zombies) zList.get(l)).getZombHP() - 25);
									break;
								}
								
								if(((PeaShooter)grid[i][j]).getPeas().get(k).getPeaSprite().getX() >= 980) {
									((PeaShooter)grid[i][j]).getPeas().remove(k);
									break;
								}
								
						
							}
						}
						
						
					}
					
					
					//Zombie and the plant Peashooter Collision
					Rectangle peaShooterRect = ((PeaShooter) grid[i][j]).getPlantSprite().getBoundingRectangle();
					
					for(int l = zList.size() -1; l >= 0; l--) {
						Rectangle zombRect = ((Zombies) zList.get(l)).getZombSprite().getBoundingRectangle();							
						if(peaShooterRect.overlaps(zombRect)) {
							((Zombies) zList.get(l)).getZombSprite().translateX(-Zombies.zombSpeed);
							((Zombies) zList.get(l)).attack(grid[i][j]);
							
						}
				
					}
				}
			}
		}
		
		//Making the walnuts do  their thing
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] != null && grid[i][j].getType().equalsIgnoreCase("Walnut")) {
					
					Rectangle walnutRect = ((Walnut) grid[i][j]).getPlantSprite().getBoundingRectangle();
					
					for(int l = zList.size() -1; l >= 0; l--) {
						Rectangle zombRect = ((Zombies) zList.get(l)).getZombSprite().getBoundingRectangle();							
						if(walnutRect.overlaps(zombRect)) {
							((Zombies) zList.get(l)).getZombSprite().translateX(-Zombies.zombSpeed);
							((Zombies) zList.get(l)).attack(grid[i][j]);
							System.out.format("%d%n",((Walnut) grid[i][j]).getHealth());
							
						}
				
					}
				}
			}
		}
		
		// Spawn waves of zombies
		if(wave == true) {
			for(int i = 0; i < 20; i++) {
				if(waveCounter == 1) {
					IZombie z = new Zombies();
					((Zombies) z).setZombHP(50);
					int tempNum = (int)((Math.random()*5) + 1);
					switch (tempNum) {
					 case 1:
					    ((Zombies) z).getZombSprite().setPosition((float)((Math.random()*5550) + 3150), 430);
					    zList.add(z);
					    break;
					 case 2:
						((Zombies) z).getZombSprite().setPosition((float)((Math.random()*5550) + 3150), 330);
						zList.add(z);
					    break;
					 case 3:
						((Zombies) z).getZombSprite().setPosition((float)((Math.random()*5550) + 3150), 230);
						zList.add(z);
					    break;
					 case 4:
						((Zombies) z).getZombSprite().setPosition((float)((Math.random()*5550) + 3150), 130);
						zList.add(z);
					    break;
					 case 5:
						((Zombies) z).getZombSprite().setPosition((float)((Math.random()*5550) + 3150), 30);
						zList.add(z);
						break;
					}
				}
				
				if(waveCounter == 2) {
					IZombie z = new Zombies();
					((Zombies) z).setZombHP(125);
					int tempNum = (int)((Math.random()*5) + 1);
					switch (tempNum) {
					 case 1:
					    ((Zombies) z).getZombSprite().setPosition((float)((Math.random()*5550) + 3150), 430);
					    zList.add(z);
					    break;
					 case 2:
						((Zombies) z).getZombSprite().setPosition((float)((Math.random()*5550) + 3150), 330);
						zList.add(z);
					    break;
					 case 3:
						((Zombies) z).getZombSprite().setPosition((float)((Math.random()*5550) + 3150), 230);
						zList.add(z);
					    break;
					 case 4:
						((Zombies) z).getZombSprite().setPosition((float)((Math.random()*5550) + 3150), 130);
						zList.add(z);
					    break;
					 case 5:
						((Zombies) z).getZombSprite().setPosition((float)((Math.random()*5550) + 3150), 30);
						zList.add(z);
						break;
					}
				}
				
				
				if(waveCounter == 3) {
					IZombie z = new Zombies();
					((Zombies) z).setZombHP(150);
					int tempNum = (int)((Math.random()*5) + 1);
					switch (tempNum) {
					 case 1:
					    ((Zombies) z).getZombSprite().setPosition((float)((Math.random()*5550) + 3150), 430);
					    zList.add(z);
					    break;
					 case 2:
						((Zombies) z).getZombSprite().setPosition((float)((Math.random()*5550) + 3150), 330);
						zList.add(z);
					    break;
					 case 3:
						((Zombies) z).getZombSprite().setPosition((float)((Math.random()*5550) + 3150), 230);
						zList.add(z);
					    break;
					 case 4:
						((Zombies) z).getZombSprite().setPosition((float)((Math.random()*5550) + 3150), 130);
						zList.add(z);
					    break;
					 case 5:
						((Zombies) z).getZombSprite().setPosition((float)((Math.random()*5550) + 3150), 30);
						zList.add(z);
						break;
					}
				}
				
				
				
				if(waveCounter == 4) {
					IZombie z = new Zombies();
					((Zombies) z).setZombHP(175);
					int tempNum = (int)((Math.random()*5) + 1);
					switch (tempNum) {
					 case 1:
					    ((Zombies) z).getZombSprite().setPosition((float)((Math.random()*5550) + 3150), 430);
					    zList.add(z);
					    break;
					 case 2:
						((Zombies) z).getZombSprite().setPosition((float)((Math.random()*5550) + 3150), 330);
						zList.add(z);
					    break;
					 case 3:
						((Zombies) z).getZombSprite().setPosition((float)((Math.random()*5550) + 3150), 230);
						zList.add(z);
					    break;
					 case 4:
						((Zombies) z).getZombSprite().setPosition((float)((Math.random()*5550) + 3150), 130);
						zList.add(z);
					    break;
					 case 5:
						((Zombies) z).getZombSprite().setPosition((float)((Math.random()*5550) + 3150), 30);
						zList.add(z);
						break;
					}
				}
				
				
				
				if(i == 19) {
					wave = false;
				}
				
			
			}
			Zombies.zombSpeed -= 0.75f;
		}
		
		
		waveTimeLapse += System.currentTimeMillis() - wavePreviousTime; 
		wavePreviousTime = System.currentTimeMillis(); 
		
		
		
		//Wave repete wave
		if(waveTimeLapse > 70000) {
			waveTimeLapse = 0;
			waveCounter += 1;
			wave = true;
			System.out.format("one peiace");
		}
		
		
		//Wave Title
		CharSequence str1 = "Wave 1:";
		CharSequence str2 = "Wave 2:";
		CharSequence str3 = "Wave 3:";
		CharSequence str4 = "Wave 4: ";
		
		

		
		//Game end condition
		for(int i = zList.size() - 1; i >=0; i--) {
			if(((Zombies) zList.get(i)).getZombSprite().getX() < 220 ) {
				((Zombies) zList.get(i)).getZombSprite().translateX(-Zombies.zombSpeed);
				zList.remove(i);
				game.setScreen(new EndScreen(game));
			}
		}
		
		if(waveCounter == 5 || waveCounter == -5) {
			game.setScreen(new WinEndScreen(game));
		}
		
		

			
		//Move and remove zombies
		for(int i = 0; i < zList.size(); i++) {
			((Zombies) zList.get(i)).move();
				
			if(((Zombies) zList.get(i)).getZombHP() <= 0) {
				zList.remove(i);
			}
		}
		
		
		
		
		
		//Removes Plants
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] != null) {
					if((grid[i][j]).getHealth() <= 0) {
						(grid[i][j]) = null;
					}
				}
			}
		
		}
		
		//Sun Cap
		if(Sun.sunPoints >= 500) {
			Sun.sunPoints -= 25;
		}



		//Batch
		game.batch.begin();
		
		//Draws Background
		backgroundSprite.draw(game.batch);
		
		
		//Draws Menu
		brownBox.draw(game.batch);
		peaShooterGrayCard.draw(game.batch);
		sunFlowerGrayCard.draw(game.batch);
		walnutGrayCard.draw(game.batch);
		sunPointsSp.draw(game.batch);
		sunPointsSunSp.draw(game.batch);
		
		
		
		//Draw Plants Moving
		for(int i = 0; i < tempPlants.size(); i++) {
			tempPlants.get(i).getPlantSprite().draw(game.batch);
		} 
		
		//Draw Plants Not Moving
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] != null) {
					grid[i][j].getPlantSprite().draw(game.batch);
				}
			}
			
		}
		
		
		
		//Draws the suns spawg from plants
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] != null && grid[i][j].getType().equalsIgnoreCase("SunFlower") ) {
					for(int k = 0; k < ((SunFlower)grid[i][j]).getGroundSuns().size(); k++) {
						if(((SunFlower) grid[i][j]).getGroundSuns().get(k) != null) {
							((SunFlower)grid[i][j]).getGroundSuns().get(k).getSunSprite().draw(game.batch);
						
						}
					}
					
				}
			}
		}
		
		//Draws the peas from peaShooter
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] != null && grid[i][j].getType().equalsIgnoreCase("PeaShooter") ) {
					for(int k = 0; k < ((PeaShooter)grid[i][j]).getPeas().size(); k++) {
						if(((PeaShooter) grid[i][j]).getPeas().get(k) != null) {
							((PeaShooter)grid[i][j]).getPeas().get(k).getPeaSprite().draw(game.batch);
						
						}
					}
					
				}
			}
		}
		
		
		//Draws Suns
		for(int i = 0; i < sunList.size(); i++) {
			if(sunList.get(i) != null) {
				sunList.get(i).getSunSprite().draw(game.batch);
			}
		} 
		
		
		
		
		
		//Drawing the coloured menu cards
		if(Sun.sunPoints >= 50) {
			sunFlowerCard.draw(game.batch);
			walnutCard.draw(game.batch);
		}
		if(Sun.sunPoints >= 100) {
			peaShooterCard.draw(game.batch);
		}
		
		for(int i = 0; i < zList.size(); i++) {
			if(((Zombies) zList.get(i)) != null) {
				((Zombies) zList.get(i)).getZombSprite().draw(game.batch);
			}
		}
		
		

		
		//Drawing Font
		font.draw(game.batch, str, 114, 510);
		
		fontW.setColor(0, 0, 0, 1);
		if(waveCounter == 1) {
			fontW.draw(game.batch, str1, 55, 510);
		}
		
		if(waveCounter == 2) {
			fontW.draw(game.batch, str2, 55, 510);
		}
		
		if(waveCounter == 3) {
			fontW.draw(game.batch, str3, 55, 510);
		}
		
		if(waveCounter == 4) {
			fontW.draw(game.batch, str4, 55, 510);
		}
		
		
				
		
		game.batch.end();
	}
	
	
	

	

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}

