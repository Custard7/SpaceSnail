package com.omg.ssworld;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.omg.drawing.JSActor;
import com.omg.gdxlucid.Timer;
import com.omg.spacesnail.SpaceSnail;

public class BackgroundSpawn extends JSActor{

	

	

	Timer timer;

	BProperties bProperties;
	WorldManager manager;

	boolean freezeWorldStopsEverything = false;


	public BackgroundSpawn(WorldManager m, BProperties p) {
		super(new TextureRegion(SpaceSnail.getAssetsManager().getTexture("Stars"),0,0,1,1));

		manager = m;
		init();

		bProperties = p;


	}

	private void init() {

		timer = new Timer();
		timer.start();

		addTag("STATIC");
		addTag("B_Spawn");

	}


	
	@Override
	public void act(float delta) {
		super.act(delta);

		float speed = manager.getWorldSpeed();
		//if(this.getChildren().size <= 3)
			//speed = 1000;


		for(Actor a : this.getChildren()) {

			if(!((JSActor)a).hasTag("STATIC")) {

				int customSpeed = 0;

				if(((JSActor)a).hasTag("Background"))
					customSpeed = ((Background)a).getCustomSpeed();

				if(speed + customSpeed >= 0)
					a.moveBy(0,-(speed + customSpeed));
				else if(speed >= 0)
					a.moveBy(0,-(speed));

			}
		}
	

		boolean canCreate = false;

		if(lastBackground == null){
			//if(timer.getTime()  > (190000.0f / (((float)worldManager.speed)/10.0f) * Gdx.graphics.getDeltaTime())){
				canCreate = true;
			//}

		} else if (lastBackground.getY() + lastBackground.getHeight() < WorldData.worldY + WorldData.worldHeight) {
			canCreate = true;
		}

		//if(timer.getTime()  > (190000.0f / (((float)worldManager.speed)/10.0f) * Gdx.graphics.getDeltaTime())){
		if(canCreate){
			boolean canReuse = false;
			Background b = null;

			for(Actor a : this.getChildren()) {

				if(((JSActor)a).hasTag("Background")) {

					if(!((Background)a).isActive) {
						((Background)a).isActive = true;
						b = ((Background)a);
						canReuse = true;
					}
				}
			}

			if(!canReuse) {

				b = new Background(bProperties);
			}
			addBackground(b, canReuse);			
			timer.reset();

		}



	}


	Background lastBackground;

	public void addBackground(Background b, boolean reuse) {

		b.setWorldBounds();

		if(lastBackground == null) 
		{
			//b.setX(worldManager.getWorldX() + worldManager.getWorldWidth());
			//b.setX(worldManager.getWorldX());
			b.setY(0);
		}
		else
			b.setY(lastBackground.getY() + 600);
		//b.setY((float) (-Math.random() * (height/2)));
		//b.setY(0);

		if(!reuse)
			addActor(b);
		lastBackground = b;

	}
}
