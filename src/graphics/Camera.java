package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import gameObjects.Chunk;
import gameObjects.Entity;
import utility.Util;

public class Camera {
	
	private Chunk[][] chunks;
	private Entity[] entities;
	private double scale = 1;
	private int x, y;

	public Camera() {
		this(null, null, 0, 0);
	}
	public Camera(Chunk[][] chunks, Entity[] entities, int x, int y){
		this.chunks = chunks;
		this.entities = entities;
		this.setX(x);
		this.setY(y);
	}
	public Camera(Chunk[][] chunks, Entity[] entities){
		this(chunks, entities, 0, 0);
	}
	
	public Image getView(){
		BufferedImage bi = new BufferedImage(Util.getScreenWidth(),Util.getScreenHeight(),BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.getGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, bi.getWidth(), bi.getHeight());
		drawView(g);
		return bi;
	}
	
	private void drawView(Graphics g){
		if(chunks != null){
			int offsetFactor = chunks[0][0].getImageSize();
			for(int i = 0; i<chunks.length; i++){
				for(int u = 0; u<chunks[i].length; u++){
					g.drawImage(chunks[i][u].getImage(), offsetFactor*i+this.x, offsetFactor*u+this.y,null);
				}
			}
		}
		if(entities != null){
			for(Entity e:entities){
				g.drawImage(e.getImage(), (int)(e.getX()+x), (int)(e.getY()+y), null);
			}
		}
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

}
