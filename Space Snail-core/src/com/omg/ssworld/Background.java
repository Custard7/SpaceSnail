package com.omg.ssworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.omg.drawing.JSActor;
import com.omg.spacesnail.SpaceSnail;

public class Background extends JSActor {

	private int customSpeed = 0;


	private int x;
	private int y;
	private int width;
	private int height;
	
	
	public boolean isActive;
	
	
	

	public Background(BProperties properties) {
		super(new TextureRegion(SpaceSnail.getAssetsManager().getTexture("Stars"),0,0,1,1));
		setRegion(new TextureRegion(SpaceSnail.getAssetsManager().getTexture(properties.getFileName()),0,0,properties.getWidth(),properties.getHeight()));

		setCustomSpeed(properties.getCustomSpeed());

		setScale(properties.getScale());
		setY(properties.getYOffset());
		addTag("Background");
		
		isActive = true;

	}
	
	
	
	@Override
	public void act(float delta) {
		super.act(delta);
		
		if(this.getY() < y - 2560) {
			this.isActive = false;
		}
		
	}
	
	public void setWorldBounds() {
		this.x = WorldData.worldX;
		this.y = WorldData.worldY;
		this.width = WorldData.worldWidth;
		this.height = WorldData.worldHeight;
	}
	
	
	public int getCustomSpeed() {
		return customSpeed;
	}
	
	public void setCustomSpeed(int speed) {
		customSpeed = speed;
	}
}
