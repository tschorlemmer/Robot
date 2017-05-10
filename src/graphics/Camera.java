package graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import gameObjects.Chunk;
import gameObjects.Entity;
import utility.Util;

public class Camera {
	
	private Chunk[][] chunks;
	private Entity[] entities;
	private double zoom = 1;

	public Camera() {
		chunks = null;
		entities = null;
	}
	
	public Image getView(){
		BufferedImage bi = new BufferedImage(Util.getScreenWidth(),Util.getScreenHeight(),BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.getGraphics();
		drawView(g);
		return bi;
	}
	
	private void drawView(Graphics g){
		
	}

}
