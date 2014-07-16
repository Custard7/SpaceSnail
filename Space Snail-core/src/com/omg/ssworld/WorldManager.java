package com.omg.ssworld;

import com.omg.drawing.JSActor;

public class WorldManager extends JSActor {

	float worldSpeed = 0;
	
	public float getWorldSpeed() {
		return worldSpeed;
	}
	public void setWorldSpeed(float speed) {
		this.worldSpeed = speed;
	}
	
	public WorldManager() {
		super();
		
		BProperties b;
		
		 addBackgroundSpawn(new BackgroundSpawn(this, BProperties.makeProperties("Stars", 1, 0))); 				//Sky Back

		 
		 addTag("WorldManager");
		
	}
	
	
	
	
	public void addBackgroundSpawn(BackgroundSpawn s) {
		float ran_y = WorldData.worldY + WorldData.worldHeight;
		float ran_x = 0;

		s.setY(ran_y);
		s.setX(ran_x);

		addActor(s);


	}
	
	
}
