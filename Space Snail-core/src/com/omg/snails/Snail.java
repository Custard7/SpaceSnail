package com.omg.snails;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.omg.drawing.JSActor;
import com.omg.spacesnail.SpaceSnail;

public class Snail extends JSActor {

	
	JSActor snail;
	
	
	public JSActor getSnail() {
		return snail;
	}
	public void setSnail(JSActor snail) {
		this.snail = snail;
	}
	

	public int getSlime() {
		return slime;
	}
	public void setSlime(int slime) {
		this.slime = slime;
	}
	public int getWit() {
		return wit;
	}
	public void setWit(int wit) {
		this.wit = wit;
	}
	public int getStoked() {
		return stoked;
	}
	public void setStoked(int stoked) {
		this.stoked = stoked;
	}
	public int getCharm() {
		return charm;
	}
	public void setCharm(int charm) {
		this.charm = charm;
	}
	public int getSelfEsteem() {
		return selfEsteem;
	}
	public void setSelfEsteem(int selfEsteem) {
		this.selfEsteem = selfEsteem;
	}
	public int getSwag() {
		return swag;
	}
	public void setSwag(int swag) {
		this.swag = swag;
	}

	protected int slime = 0;
	protected int wit = 20;
	protected int stoked = 40;
	protected int charm = 23;
	protected int selfEsteem = 5;
	protected int swag = 5;
	
	
	public Snail() {
		
		snail = new JSActor(new TextureRegion(SpaceSnail.getAssetsManager().getTexture("Snail Purple"),0,0,216,177));
		addActor(snail);
		
	}
	
	
}
