package com.omg.spacesnail.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.omg.spacesnail.SpaceSnail;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Space Snail";
		config.height = 1280;
		config.width = 720;
		new LwjglApplication(new SpaceSnail(), config);
	}
}
