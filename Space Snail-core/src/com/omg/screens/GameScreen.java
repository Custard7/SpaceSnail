package com.omg.screens;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.omg.drawing.JSActor;
import com.omg.gui.HUD;
import com.omg.sfx.MusicManager;
import com.omg.sfx.MusicManager.LucidMusic;
import com.omg.sfx.SoundManager;
import com.omg.spacesnail.SpaceSnail;
import com.omg.ssplayer.Player;
import com.omg.ssworld.CollisionHandler;
import com.omg.ssworld.WorldManager;
import com.omg.ui.ButtonEvent;
import com.omg.ui.JSButton;

public class GameScreen implements Screen, Loadable {

	SpaceSnail gameManager;
	 
	 public SpaceSnail getGameManager() {
		 return gameManager;
	 }
	 
	 MusicManager musicManager;
	 SoundManager soundManager;
	 
	 public SoundManager getSoundManager() {
		 return soundManager;
	 }
	 
	 public MusicManager getMusicManager() {
		 return musicManager;
	 }
	 
	 private Stage stage;
	 private Viewport viewport;
	 World physics_world;
	 
	 public static final float WORLD_TO_BOX = 0.01f;
	 public static final float BOX_TO_WORLD = 100f;
	 Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer();
	 CollisionHandler collisionHandler;

	 HashMap<String, Texture> textures;

	 
	 
	 
	 JSActor BASENODE;
	 
	 Player player;
	 
	 public Player getPlayer() {
		 return player;
	 }
	 
	 HUD worldHUD;
	 WorldManager world;
	 
	 JSButton blastOffBtn;
	 
	 //JSFont distanceCounter;
	 float distanceTraveled = 0.0f;
	 
	 float speedBonus = 2f;
	 
	 
	 
	 
	 
	 
	 
	 public enum GameState {
		 
		 running,

		 
		 
	 }
	 
	 GameState gameState = GameState.running;
	 
	 
	 public GameState getState() {
		 return gameState;
	 }
	 
	 public void setGameState(GameState state) {
		 this.gameState = state;
	 }
	 

     // constructor to keep a reference to the main Game class
      public GameScreen(SpaceSnail gameManager){
              this.gameManager = gameManager;
              
      }
	
      float zoom = 0;
      
	
	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		
		
		OrthographicCamera camera = (OrthographicCamera)stage.getCamera();
		
	
		
		// modify camera here
		physics_world.step(1/60f, 6, 2);
		
				


		 Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	        stage.act(Gdx.graphics.getDeltaTime());
	        stage.draw();
	       

	     
		
		
	   if(Gdx.input.isKeyPressed(Keys.P)) {
		   debugRenderer.setDrawBodies(false);

	   }
	   else if(Gdx.input.isKeyPressed(Keys.O)){
		   debugRenderer.setDrawBodies(true);
	   }

	     
	     debugRenderer.render(physics_world, camera.combined);

	     

	     
	     switch(getState()) {
	     
	     case running:
	    	 
		  	
		  	 
	    	 break;
	   
	     default:
	    	 break;
	     
	     
	     }
	     
	     
	        Table.drawDebug(stage); // This is optional, but enables debug lines for tables.


	}
	

	

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);	
	}

	boolean hasShown = false;
	
	@Override
	public void show() {
		if(!isLoaded())
			load(); 
		
		if(!hasShown) {
			
			float w = Gdx.graphics.getWidth();
	  		float h = Gdx.graphics.getHeight();
		  	    
	  	    viewport = new FitViewport(720, 1280);
	  	    stage = new Stage(viewport);
	        Gdx.input.setInputProcessor(stage);
	  	  
	        debugRenderer.setDrawBodies(false);


	        
	  		physics_world = new World(new Vector2(0,0), true);
	  		collisionHandler = new CollisionHandler();
	  		collisionHandler.setGameScreen(this);
	  		physics_world.setContactListener(collisionHandler);
	  		
	  		
	  		world = new WorldManager();
	  		stage.addActor(world);
	  		
	  		BASENODE = new JSActor();
	  		stage.addActor(BASENODE);
	  		

	  		
	  		//Add INIT
	

	  		player = new Player();
	  		player.setPosition(250, 400);
	  		BASENODE.addActor(player);
	  		
	  		
	  		blastOffBtn = new JSButton("Blast Off");
	  		blastOffBtn.setPosition(300, 1000);
	  		blastOffBtn.setButtonEvent(new ButtonEvent() {

				@Override
				public boolean handle(Event event) {
					// TODO Auto-generated method stub
					return true;
				}

				@Override
				public void onPress() {
					// TODO Auto-generated method stub
					world.setWorldSpeed(10);
					blastOffBtn.addAction(Actions.moveBy(0, 400, 2));
				}
	  			
	  		});
	  		BASENODE.addActor(blastOffBtn);
	  		
	  		
	       
	  		
	  		
	  		
	  		
	  		worldHUD = new HUD();
	  		worldHUD.setGameScreen(this);
	  		BASENODE.addActor(worldHUD);
	  		BASENODE.setPosition(0, 1280);
	  		
	  		//Fade In
	  		BASENODE.setColor(BASENODE.getColor().r, BASENODE.getColor().g, BASENODE.getColor().b, 0);
	  		BASENODE.addAction(
	  				Actions.parallel(
	  		  		Actions.moveTo(0, 0, 1, Interpolation.swingOut),
	  				Actions.fadeIn(2.5f, Interpolation.fade)
	  				));
	  		


	  		
	  		//musicManager.play(LucidMusic.BEN_SOUND);
  		
		}

  		hasShown = true;
  		

	}
	
	private boolean loaded = false;
	public boolean isLoaded() {
		return loaded;
	}
	
	public void load() {
		 
        textures = new HashMap<String, Texture>();
        

       // create the music manager service
       musicManager = new MusicManager();
       //musicManager.setVolume( preferencesManager.getVolume() );
       musicManager.setEnabled( true);
       
       //create the sound manager service
       soundManager = new SoundManager();
       //soundManager.setVolume( preferencesManager.getVolume() );
       soundManager.setEnabled( true);
       
 		
		/* Load Files
       leDataHandler = new LEDataHandler();
       leDataHandler.loadQR("P1_6"); */
       
       //Load Sfx
       //soundManager.load(new LucidSound("sfx/correct.ogg"), "Correct");











       
    //Load Textures 
   	LAssetManager aManager = SpaceSnail.getAssetsManager();
   	aManager.clear();

   	
   	aManager.loadTexture("Art/UI/buttons/uiskin.png", "UISkin");
   	aManager.loadTexture("Art/UI/buttons/ninepatch_gray.png", "9Patch_Gray");

   	aManager.loadTexture("Art/Creatures/bum.png", "Bum");
   	aManager.loadTexture("Art/Snails/snail_purple.png", "Snail Purple");
   	aManager.loadTexture("Art/Snails/snail_shell_purple.png", "SnailShell Purple");





   	aManager.loadTexture("Art/UI/hud/hud_tray.png", "HUD_Tray");
   	aManager.loadTexture("Art/UI/hud/hud_blue.png", "HUD_Progress_Blue");
   	aManager.loadTexture("Art/UI/hud/hud_progress_back.png", "HUD_Progress_Back");
   	
   	
   	aManager.loadTexture("Art/Spaceships/ship_blue.png", "Ship_Blue");
   	aManager.loadTexture("Art/Spaceships/ship_purple.png", "Ship_Purple");
   	aManager.loadTexture("Art/Spaceships/ship_red.png", "Ship_Red");
   	aManager.loadTexture("Art/Spaceships/ship.png", "Ship_Green");
   	
   	aManager.loadTexture("Art/Effects/front_stars.png", "Stars");


   	
   	
   	Gdx.app.log("AssetManager", "BAM!! " + aManager.getDiagnostics());
		loaded = true;
	}
	
	
	
	
	
	
	
	
	

	@Override
	public void hide() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {

		loaded = false;		
	}

	@Override
	public void dispose() {
        stage.dispose();
        
        /*
       	LAssetManager aManager = GameManager.getAssetsManager();
        
    	aManager.unload("data/2_Tile.png");
       	aManager.unload("data/big_pixel_coin.png");
       	aManager.unload("data/background/back_clouds.png");
       	aManager.unload("data/background/front_clouds.png");
       	aManager.unload("data/background/front_f.png");
       	aManager.unload("data/background/mid_f.png");
       	aManager.unload("data/background/back_f.png");
       	aManager.unload("data/background/sky.png");
       	aManager.unload("data/front_stars.png");
       	aManager.unload("data/laser.png");
       	
       	//aManager.clear();
       	 * */
    

	}
	
	
	  
	  String vertexShader = "attribute vec4 a_position;    \n" + 
              "attribute vec4 a_color;\n" +
              "attribute vec2 a_texCoord0;\n" + 
              "uniform mat4 u_worldView;\n" + 
              "varying vec4 v_color;" + 
              "varying vec2 v_texCoords;" + 
              "void main()                  \n" + 
              "{                            \n" + 
              "   v_color = vec4(1, 1, 1, 1); \n" + 
              "   v_texCoords = a_texCoord0; \n" + 
              "   gl_Position =  u_worldView * a_position;  \n"      + 
              "}                            \n" ;
	  String fragmentShader = "#ifdef GL_ES\n" +
                "precision mediump float;\n" + 
                "#endif\n" + 
                "varying vec4 v_color;\n" + 
                "varying vec2 v_texCoords;\n" + 
                "uniform sampler2D u_texture;\n" + 
                "void main()                                  \n" + 
                "{                                            \n" + 
                "  gl_FragColor = v_color * texture2D(u_texture, v_texCoords);\n" + 
                "}";

}
