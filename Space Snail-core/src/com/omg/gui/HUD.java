package com.omg.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.omg.drawing.JSActor;
import com.omg.drawing.JSFont;
import com.omg.filemanagement.QRSet.QROptions;
import com.omg.screens.GameScreen;
import com.omg.screens.SnailManagerScreen;
import com.omg.sfx.MusicManager.LucidMusic;
import com.omg.spacesnail.SpaceSnail;
import com.omg.ui.ButtonEvent;
import com.omg.ui.JSButton;

public class HUD extends JSActor {

	
	GameScreen gameScreen;
	
	JSActor hudTray;
	JSProgressBar distanceProgressBar;
	
	JSButton captainButton;
	JSButton snailButton;
	
	public void setGameScreen(GameScreen screen){
		this.gameScreen = screen;
	}

	

	
	
	
	public HUD() {
		super();
		
		
		
		hudTray = new JSActor(new TextureRegion(SpaceSnail.getAssetsManager().getTexture("HUD_Tray"),0,0,740,257));
		hudTray.setPosition(0, 0);
		addActor(hudTray);
		
		distanceProgressBar = new JSProgressBar(0,1000,720);
		distanceProgressBar.setPosition(0, 257);
		addActor(distanceProgressBar);
		
		captainButton = new JSButton("", "Bum");
		captainButton.setPosition(65, 50);
		captainButton.setScale(1.5f);
		captainButton.setButtonEvent(new ButtonEvent() {

			@Override
			public boolean handle(Event event) {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public void onPress() {
				// TODO Auto-generated method stub
				Gdx.app.log("HUD", "Player button pressed");
			}
			
			
		});
		addActor(captainButton);
		
		
		snailButton = new JSButton("", "Snail Purple");
		snailButton.setPosition(500, 50);
		snailButton.setScale(1.0f);
		snailButton.setButtonEvent(new ButtonEvent() {

			@Override
			public boolean handle(Event event) {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public void onPress() {
				// TODO Auto-generated method stub
				Gdx.app.log("HUD", "Snail button pressed");
				gameScreen.getGameManager().setScreen(new SnailManagerScreen(gameScreen.getGameManager(), gameScreen));
			}
			
			
		});
		addActor(snailButton);
		
		/*
		Skin skinA = new Skin();
		skinA.add("up", new Texture("data/ui/pause_button.png"));
		skinA.add("down", new Texture("data/ui/pause_button_down.png"));
		
		TextureRegion upRegionA = skinA.getRegion("up");
		TextureRegion downRegionA = skinA.getRegion("down");

		ButtonStyle styleA = new ButtonStyle();
		styleA.up = new TextureRegionDrawable(upRegionA);
		styleA.down = new TextureRegionDrawable(downRegionA);
	
		
		pauseButton = new Button(styleA);
		pauseButton.addListener(new ChangeListener() {
			@Override
			public void changed (ChangeEvent event, Actor actor) {
				//System.out.println("Changed!");
				Gdx.app.log("HUD", "Pause Pressed");

				setPaused(true);

			}
		});
		
		pauseButton.setPosition(-1050, 1000);
		
		
		this.addActor(pauseButton);
		
		
		Skin skinB = new Skin();
		skinB.add("up", new Texture("data/ui/paused.png"));
		skinB.add("down", new Texture("data/ui/paused.png"));
		
		TextureRegion upRegionB = skinB.getRegion("up");
		TextureRegion downRegionB = skinB.getRegion("down");

		ButtonStyle styleB = new ButtonStyle();
		styleB.up = new TextureRegionDrawable(upRegionB);
		styleB.down = new TextureRegionDrawable(downRegionB);
	
		
		pausedDialogue = new Button(styleB);
		pausedDialogue.addListener(new ChangeListener() {
			@Override
			public void changed (ChangeEvent event, Actor actor) {
				//System.out.println("Changed!");
				Gdx.app.log("HUD", "Unpaused");

				setPaused(false);

			}
		});
		
		pausedDialogue.setPosition(-200, 250);
		
		
		this.addActor(pausedDialogue);
		
		setPaused(false);*/
		
	}
	
	
	@Override
	public void act(float delta) {
		super.act(delta);
		

		
	}
	
	
}

