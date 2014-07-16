package com.omg.screens;

import java.io.IOException;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.omg.drawing.JSActor;
import com.omg.drawing.JSFont;
import com.omg.sfx.LucidSound;
import com.omg.sfx.MusicManager;
import com.omg.sfx.MusicManager.LucidMusic;
import com.omg.sfx.SoundManager;
import com.omg.spacesnail.SpaceSnail;


public class MainMenuScreen implements Screen {

	
	
	 SpaceSnail gameManager;
	
	 MusicManager musicManager;
	 SoundManager soundManager;
	 
	 private Stage stage;
	 private Viewport viewport;
	 JSActor BASENODE;
	 
	 boolean skipIntro = true;
	 

	 JSActor omgLogo;
	 
	 
	 JSActor background;
	 JSActor spaceSnailText;
	 JSActor continueText;
	
	 
	 int kikuTextX = 25;
	 int kikuTextY = 800;
	 int kikuTextInitY = 1300;

	 HashMap<String, Texture> textures;
	 
	 public enum MenuState {
		 
		 logos,
		 transitionIn,
		 open,
		 transitionOut,
		 out
		 
	 }
	 
	 MenuState menuState = MenuState.logos;

	 
	 public MenuState getState() {
		 return menuState;
	 }
	 
	 public void setState(MenuState state) {
		 switch(state) {
	     case logos:
	    	 background.setVisible(false);
	    	 spaceSnailText.setVisible(false);
	    	 continueText.setVisible(false);
	    	 
	    	 omgLogo.setVisible(true);
	    	 
	    	 omgLogo.setColor(omgLogo.getColor().r, omgLogo.getColor().g, omgLogo.getColor().b, 0);
	    	 
	    	 
	    	 omgLogo.addAction(Actions.sequence(
	    			 Actions.fadeIn(1),
	    			 Actions.delay(1),
	    			 Actions.fadeOut(1),
	    			 Actions.run(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							setState(MenuState.transitionIn);
						}
	    				 
	    			 })
	    			 ));

	    	 musicManager.stop();
	    	 
	    	 break;
	     case transitionIn:
	    	 
	    	 
	    	 background.setVisible(true);
	    	 background.setColor(background.getColor().r, background.getColor().g, background.getColor().b, 0);
	    	 
	    	 spaceSnailText.setVisible(true);
	    	 spaceSnailText.setPosition(kikuTextX, kikuTextInitY);
	    	 spaceSnailText.addAction(Actions.sequence(
	    			 Actions.moveTo(kikuTextX, kikuTextY, 3, Interpolation.bounceOut),
	    			 Actions.run(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							background.addAction(Actions.sequence(
									Actions.fadeIn(2, Interpolation.fade),
									Actions.run(new Runnable() {

										@Override
										public void run() {
											// TODO Auto-generated method stub
											setState(MenuState.open);
										}
										
									})
									));
							continueText.addAction(
									Actions.forever(
											Actions.sequence(
													Actions.fadeOut(2, Interpolation.fade),
													Actions.fadeIn(1, Interpolation.fade)
									)));
						}
	    				 
	    			 })
	    			 ));
	    	 
	    	 continueText.setVisible(true);
	    	 continueText.setColor(background.getColor().r, background.getColor().g, background.getColor().b, 0);

	    	 
	    	 omgLogo.setVisible(false);
	    	 
	    	 break;
	     case open:
	    	 
	    	// musicManager.play(LucidMusic.MENU_MUSIC);
	    	 
	    	 background.setVisible(true);
	    	 background.setColor(background.getColor().r, background.getColor().g, background.getColor().b, 1);
	    	
	    	 spaceSnailText.setVisible(true);
	    	 spaceSnailText.setPosition(kikuTextX, kikuTextY);
	    	 
	    	 continueText.setVisible(true);
	    	 continueText.setColor(background.getColor().r, background.getColor().g, background.getColor().b, 1);
	    	 
	    	 omgLogo.setVisible(false);
	    	 
	    	 break;
	     case transitionOut:
	    	 //musicManager.play(LucidMusic.MENU_OUTRO, false);
	    	 
	    	 background.setVisible(true);
	    	 background.setColor(background.getColor().r, background.getColor().g, background.getColor().b, 1);
	    	 
	    	 background.addAction(Actions.sequence(
	    			 Actions.fadeOut(1.5f)
	    			 ));
	    	 
	    	 spaceSnailText.setVisible(true);
	    	 spaceSnailText.setPosition(kikuTextX, kikuTextY);
	    	 
	    	 spaceSnailText.addAction(Actions.sequence(
	    			 Actions.moveTo(kikuTextX, kikuTextInitY, 1.5f, Interpolation.bounceIn),
	    			 Actions.run(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							setState(MenuState.out);
						}
	    				 
	    			 })
	    			 ));
	    	 
	    	 continueText.setVisible(false);
	    	 continueText.setColor(background.getColor().r, background.getColor().g, background.getColor().b, 1);
	    	 
	    	 omgLogo.setVisible(false);
	    	 
	    	 break;
     }
		 
		 
		 menuState = state;
	 }
	 

    // constructor to keep a reference to the main Game class
     public MainMenuScreen(SpaceSnail gameManager){
             this.gameManager = gameManager;
     }
     // constructor to keep a reference to the main Game class
     public MainMenuScreen(SpaceSnail gameManager, boolean skipIntro){
             this.gameManager = gameManager;
             this.skipIntro = skipIntro;
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
	        
	        
	        
	     switch(menuState) {
		     case logos:
		    	 //setState(MenuState.transitionIn);
		    	 
		    	 
		    	 
		    	 break;
		     case transitionIn:

		    	 
		    	 break;
		     case open:
		    	 
		    	 if(Gdx.input.isKeyPressed(Keys.SPACE) || Gdx.input.isTouched())
		 	    	//gameManager.gotoGameScreen();
		 	    {
		 	    	//gameManager.loadScreen(new GameScreen(gameManager));
		    		 setState(MenuState.transitionOut);
		    		// soundManager.play("Begin");
		    		// musicManager.stop();
		 	    }
		    	 break;
		     case transitionOut:
		    	 
		    	 break;
		     case out:
		    	 
		 	     gameManager.loadScreen(new GameScreen(gameManager));
		    	 break;
	     }

	        
	    
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		//stage.setViewport(width, height, true);
		viewport.update(width, height);
	}

	@Override
	public void show() {
  		float w = Gdx.graphics.getWidth();
  		float h = Gdx.graphics.getHeight();
		//float w = GameManager.VIRTUAL_WIDTH;
		//float h = GameManager.VIRTUAL_HEIGHT;
  		//Gdx.gl.glViewport(0, 0, (int)w, (int)h);

  		Gdx.app.log("MONSTER", "w: " + w + " h: " + h);
  		
  	    viewport = new FitViewport(720, 1280);
   	    stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
        
        

        
        textures = new HashMap<String, Texture>();

        
  		BASENODE = new JSActor();
  		stage.addActor(BASENODE);
  		
  		
  		BASENODE.setPosition(-370, -600);
 
  		background = new JSActor(new TextureRegion(new Texture(Gdx.files.internal("Art/UI/mainmenu/SpaceSnailMenu_vertical_back.png")),0,0,720,1280)); //data/splash screen.png
  		background.setPosition(0, 0);
  		BASENODE.addActor(background);
  		
  		spaceSnailText = new JSActor(new TextureRegion(new Texture(Gdx.files.internal("Art/UI/mainmenu/SpaceSnailMenu_vertical_title.png")),0,0,720,439));
  		spaceSnailText.setPosition(kikuTextX,kikuTextY);
  		BASENODE.addActor(spaceSnailText);
  		
  		continueText = new JSActor(new TextureRegion(new Texture(Gdx.files.internal("Art/UI/mainmenu/SpaceSnailMenu_vertical_tap.png")),0,0,445,545));
  		continueText.setPosition(160, 0);
  		BASENODE.addActor(continueText);
  		
  		
  		
  		omgLogo = new JSActor(new TextureRegion(new Texture(Gdx.files.internal("Art/UI/logos/omg_logo.png")),0,0,720,1280));
  		omgLogo.setPosition(0, 0);
  		BASENODE.addActor(omgLogo);
  		

  		
  		
  		
  		
  		
  	// create the music manager service
        musicManager = new MusicManager();
      //  musicManager.setVolume( preferencesManager.getVolume() );
        musicManager.setEnabled( true);
        
        
        
        //musicManager.play(LucidMusic.SWINDLER);

        // create the sound manager service
        soundManager = new SoundManager();
       // soundManager.setVolume( preferencesManager.getVolume() );
        soundManager.setEnabled( true);
      
        //soundManager.load(new LucidSound("sfx/begin.ogg"), "Begin");
        
  		Gdx.app.log("Main Menu", "Showing Main Menu");
		
  		if(skipIntro) {
  			setState(MenuState.open);
  		}
  		else {
  			setState(MenuState.logos);
  		}
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
