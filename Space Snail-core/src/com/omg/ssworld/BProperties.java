package com.omg.ssworld;


public  class BProperties {

	String fileName;
	int customSpeed;
	float scale;
	int yoffset;

	int width;
	int height;


	public String getFileName() {
		return fileName;
	}

	public int getCustomSpeed() {
		return customSpeed;
	}

	public float getScale() {
		return scale;
	}

	public int getYOffset() {
		return yoffset;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public BProperties() {

	}

	public static BProperties makeProperties(String fileName, int customSpeed, int yOffset) {
		BProperties p = new BProperties();
		p.width = 720;
		p.height = 1280;
		p.customSpeed = customSpeed;
		p.yoffset = yOffset;
		p.fileName = fileName;
		p.scale = 1.0f;

		return p;

	}



}