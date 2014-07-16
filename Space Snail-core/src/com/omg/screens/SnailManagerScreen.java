package com.omg.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.omg.drawing.JSActor;
import com.omg.drawing.JSFont;
import com.omg.gui.JSProgressBar;
import com.omg.sfx.MusicManager;
import com.omg.sfx.SoundManager;
import com.omg.snails.Snail;
import com.omg.spacesnail.SpaceSnail;
import com.omg.ui.ButtonEvent;
import com.omg.ui.JSButton;

public class SnailManagerScreen implements Screen {
	
	SpaceSnail gameManager;
	
	MusicManager musicManager;
	SoundManager soundManager;
	
	public SoundManager getSoundManager() {
		return soundManager;
	}
	 
	private Stage stage;
	private Viewport viewport;
	JSActor BASENODE;
	
	
	Snail snail;
	
	JSFont slimeLabel;
	JSFont witLabel;
	JSFont stokedLabel;
	JSFont charmLabel;
	JSFont selfEsteemLabel;
	JSFont swagLabel;

	
	JSProgressBar slimeProgress;
	JSProgressBar witProgress;
	JSProgressBar stokedProgress;
	JSProgressBar charmProgress;
	JSProgressBar selfEsteemProgress;
	JSProgressBar swagProgress;

	
	JSButton goBack;
	 
	
	GameScreen previousScreen;
	 
	
    // constructor to keep a reference to the main Game class
    public SnailManagerScreen(SpaceSnail gameManager, GameScreen previousScreen){
             this.gameManager = gameManager;             
             this.previousScreen = previousScreen;

             
     }
	
     
     public void returnToGameScreen() {
    	//gameManager.setScreen(previousScreen);
    	 gameManager.gotoGameScreen();
 	}
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 1);
		
		OrthographicCamera camera = (OrthographicCamera)stage.getCamera();
		
		

		camera.position.set(0.0f,0.0f, 0.0f);
		camera.zoom = 1.0f;
		
		
		 Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	        stage.act(Gdx.graphics.getDeltaTime());
	        stage.draw();
	        
	        
	     
	      
		
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
	}

	@Override
	public void show() {
  		float w = Gdx.graphics.getWidth();
  		float h = Gdx.graphics.getHeight();


  	    viewport = new FitViewport(w, h);
   	    stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
        
        
  		BASENODE = new JSActor();
  		stage.addActor(BASENODE);
  		
  		BASENODE.setPosition(-300, 200);
  		
  		
  		snail = previousScreen.getPlayer().getSnail();
  		snail.setScale(1.75f);
  		snail.setPosition(100, -50);
  		BASENODE.addActor(snail);
  		
  		//Slime
  		slimeLabel = new JSFont("Slime " + snail.getSlime());
  		slimeLabel.setPosition(0, -100);
  		BASENODE.addActor(slimeLabel);
  		
  		slimeProgress = new JSProgressBar(snail.getSlime(), 100, 300);
  		slimeProgress.setPosition(0, -100);
  		slimeLabel.addActor(slimeProgress);
  		
  		//Stoked
  		stokedLabel = new JSFont("Stoked " + snail.getStoked());
  		stokedLabel.setPosition(0, -250);
  		BASENODE.addActor(stokedLabel);
  		
  		stokedProgress = new JSProgressBar(snail.getStoked(), 100, 300);
  		stokedProgress.setPosition(0, -100);
  		stokedLabel.addActor(stokedProgress);
  		
  		//Self Esteem
  		selfEsteemLabel = new JSFont("Esteem " + snail.getSelfEsteem());
  		selfEsteemLabel.setPosition(0, -400);
  		BASENODE.addActor(selfEsteemLabel);
  		
  		selfEsteemProgress = new JSProgressBar(snail.getSelfEsteem(), 100, 300);
  		selfEsteemProgress.setPosition(0, -100);
  		selfEsteemLabel.addActor(selfEsteemProgress);
  		
  		
  		//Wit
  		witLabel = new JSFont("Wit " + snail.getWit());
  		witLabel.setPosition(335, -100);
  		BASENODE.addActor(witLabel);
  		
  		witProgress = new JSProgressBar(snail.getWit(), 100, 300);
  		witProgress.setPosition(0, -100);
  		witLabel.addActor(witProgress);
  		
  		//Charm
  		charmLabel = new JSFont("Charm " + snail.getCharm());
  		charmLabel.setPosition(335, -250);
  		BASENODE.addActor(charmLabel);
  		
  		charmProgress = new JSProgressBar(snail.getCharm(), 100, 300);
  		charmProgress.setPosition(0, -100);
  		charmLabel.addActor(charmProgress);
  		
  		//Swag
  		swagLabel = new JSFont("Swag " + snail.getSwag());
  		swagLabel.setPosition(335, -400);
  		BASENODE.addActor(swagLabel);
  		
  		swagProgress = new JSProgressBar(snail.getSwag(), 100, 300);
  		swagProgress.setPosition(0, -100);
  		swagLabel.addActor(swagProgress);
  		
  		
  		
  		goBack = new JSButton("Go Back");
  		goBack.setPosition(75, -600);
  		goBack.setButtonEvent(new ButtonEvent() {

			@Override
			public boolean handle(Event event) {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public void onPress() {
				// TODO Auto-generated method stub
				returnToGameScreen();
			}
  			
  			
  		});
  		BASENODE.addActor(goBack);
  		
  		
  	    //create the music manager service
        musicManager = new MusicManager();
        //musicManager.setVolume( preferencesManager.getVolume() );
        musicManager.setEnabled( true);
        
        //musicManager.play(LucidMusic.SWINDLER);

        //create the sound manager service
        soundManager = new SoundManager();
        //soundManager.setVolume( preferencesManager.getVolume() );
        soundManager.setEnabled( true);	
		
	}

	@Override
	public void hide() {
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
	public void dispose() {
		// TODO Auto-generated method stub
		stage.dispose();
	}

	
}
