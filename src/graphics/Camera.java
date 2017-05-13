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
	private int x, y; // middle of screen
	

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
		ImageAdj iA = new ImageAdj();
		
		if(chunks != null){
			int offsetFactor = (int)(chunks[0][0].getImageSize()*scale);
			for(int i = 0; i<chunks.length; i++){
				for(int u = 0; u<chunks[i].length; u++){
					g.drawImage(iA.resize(chunks[i][u].getImage(),scale), offsetFactor*i+getXCalibrated(), offsetFactor*u+getYCalibrated(),null);
				}
			}
		}
		if(entities != null){
			for(Entity e:entities){
				g.drawImage(iA.resize(e.getImage(), scale), (int)(scale*e.getX()+getXCalibrated()), (int)(scale*e.getY()+getYCalibrated()), null);
			}
		}
	}
	private int getXCalibrated(){
		return (int)(this.x*scale)+(Util.getScreenWidth()/2);
	}
	private int getYCalibrated(){
		return (int)(this.y*scale)+(Util.getScreenHeight()/2);
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void addX(int add){
		this.x += add;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void addY(int add){
		this.y += add;
	}
	public double getScale(){
		return scale;
	}
	public void setScale(double scale){
		this.scale = scale;
	}
	public void addScale(double add){
		this.scale += add;
	}
	public void setEntities(Entity[] entities){
		this.entities = entities;
	}
	public Entity[] getEntities(){
		return entities;
	}
	public void setChunks(Chunk[][] chunks){
		this.chunks = chunks;
	}
	public Chunk[][] getChunks(){
		return chunks;
	}

}
