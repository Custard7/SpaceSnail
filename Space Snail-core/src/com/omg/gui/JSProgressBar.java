package com.omg.gui;

import aleksPack10.moved.Drawable;

import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar.ProgressBarStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.omg.drawing.JSActor;
import com.omg.spacesnail.SpaceSnail;

public class JSProgressBar extends JSActor {


	
	ProgressBar progressBar;
	ProgressBarStyle progressBarStyle;
	
	
	public JSProgressBar(int startingValue, int max, int width) {
		super();
		

		
		progressBarStyle = new ProgressBarStyle(new TextureRegionDrawable(new TextureRegion(SpaceSnail.getAssetsManager().getTexture("HUD_Progress_Blue"),0,0,720,40)), new TextureRegionDrawable(new TextureRegion(SpaceSnail.getAssetsManager().getTexture("HUD_Progress_Back"),0,0,20,40)));
		progressBar = new ProgressBar(0, max, 1, false, progressBarStyle);
		progressBar.setWidth(width);
		progressBar.setValue(startingValue);
		addActor(progressBar);

	}
	
	
	public void setValue(int value) {
		progressBar.setValue(value);
	}
	
	

	
	
	
}
