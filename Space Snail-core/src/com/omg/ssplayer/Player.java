package com.omg.ssplayer;

import aleksPack10.moved.objects.Button;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.omg.snails.Snail;

public class Player extends Spaceship {

	Snail snail;
	
	public Snail getSnail() {
		return snail;
	}
	
	
	public Player() {
		super(ShipType.Blue);
		
		snail = new Snail();
		
	}
	
	
	@Override
	public void act(float delta) {
		super.act(delta);
		
		
		if(Gdx.input.isKeyPressed(Keys.R)) {
			setType(ShipType.Red);
		}
	}

}
