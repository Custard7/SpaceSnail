package com.omg.ssplayer;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.omg.drawing.JSActor;
import com.omg.spacesnail.SpaceSnail;

public class Spaceship extends JSActor {

	
	public enum ShipType {
		
		Blue,
		Purple,
		Green,
		Red
		
	}
	
	ShipType type = ShipType.Blue;
	
	public ShipType getType() {
		return type;
	}
	public void setType(ShipType type) {
		this.type = type;
		this.setRegion(new TextureRegion(SpaceSnail.getAssetsManager().getTexture("Ship_" + type.toString()),0,0,256,256));

	}
	
	
	
	public Spaceship(ShipType type) {
		super(new TextureRegion(SpaceSnail.getAssetsManager().getTexture("Ship_Blue"),0,0,256,256));
		
		setType(type);
	}
	
}
