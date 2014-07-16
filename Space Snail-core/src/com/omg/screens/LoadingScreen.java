package com.omg.screens;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.omg.drawing.JSActor;
import com.omg.drawing.JSFont;
import com.omg.sfx.MusicManager;
import com.omg.sfx.SoundManager;
import com.omg.spacesnail.SpaceSnail;

public class LoadingScreen implements Screen {

	SpaceSnail gameManager;
	
	 MusicManager musicManager;
	 SoundManager soundManager;
	 
	 private Stage stage;
	 private Viewport viewport;
	 JSActor BASENODE;
	 
	 //JSFont menuText;
	 JSFont touchToContinueText;
	 




	 Loadable screenToLoad;
	 
	 Thread T;
	 

    // constructor to keep a reference to the main Game class
     public LoadingScreen(SpaceSnail gameManager, Loadable screenToLoad){
             this.gameManager = gameManager;
             this.screenToLoad = screenToLoad;
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
	        
	
	    
	    
	    if(!T.isAlive()){
	    	gameManager.setScreen((Screen) screenToLoad);
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
  	    
  	    viewport = new FitViewport(720, 1280);
   	    stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
        
        

        
  		BASENODE = new JSActor();
  		stage.addActor(BASENODE);
  		
  		BASENODE.setPosition(200, -300);
  		
  		/*background = new JSActor(new TextureRegion(new Texture(Gdx.files.internal("data/loading background.png")),0,0,1280,720));
  		background.setPosition(-340, -560);
  		BASENODE.addActor(background);
  		
  		menuText = new JSFont("");
  		menuText.setPosition(100,0);
  		BASENODE.addActor(menuText);
  		*/
  		
  		touchToContinueText = new JSFont("Loading ...");
  		touchToContinueText.setPosition(-50,-100);
  		BASENODE.addActor(touchToContinueText);
  		
  		

  		
  		
  	// create the music manager service
        musicManager = new MusicManager();
      //  musicManager.setVolume( preferencesManager.getVolume() );
        musicManager.setEnabled( true);
        
        //musicManager.play(LucidMusic.SWINDLER);

        // create the sound manager service
        soundManager = new SoundManager();
       // soundManager.setVolume( preferencesManager.getVolume() );
        soundManager.setEnabled( true);
        
        
       // screenToLoad;
        
        T = new Thread(new ScreenLoadThread(screenToLoad));
		T.start();
        
  		
		
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
