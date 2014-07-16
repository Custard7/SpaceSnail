package com.omg.spacesnail;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.omg.screens.GameScreen;
import com.omg.screens.LAssetManager;
import com.omg.screens.Loadable;
import com.omg.screens.LoadingScreen;
import com.omg.screens.MainMenuScreen;

public class SpaceSnail extends Game {

	MainMenuScreen menuScreen;
	GameScreen 	   gameScreen;
	
	public static final int VIRTUAL_WIDTH = 720; //1280
	public static final int VIRTUAL_HEIGHT = 1280; //720
	public static final float ASPECT_RATIO =
	        (float)VIRTUAL_WIDTH/(float)VIRTUAL_HEIGHT;
	
	
	
	@Override
	public void create() {
		
		menuScreen = new MainMenuScreen(this);
		gameScreen = new GameScreen(this);
		
		setScreen(gameScreen);
		
	}
	
	
	public void gotoGameScreen(){
		setScreen(gameScreen);
	}
	
	public GameScreen getGameScreen() {
		return gameScreen;
	}
	
	public void loadScreen(Loadable loadable) {
		setScreen(new LoadingScreen(this, loadable));
	}
	
	private static LAssetManager assetManager;
	
	public static LAssetManager getAssetsManager() {
		
		if(assetManager == null) {
			assetManager = new LAssetManager();
			Texture.setAssetManager(assetManager);

		}
		return assetManager;
		
	}

}
