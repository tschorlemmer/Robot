package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import gameObjects.Chunk;
import gameObjects.Entity;
import gameObjects.Item;
import utility.Util;

public class Camera {
	
	private Chunk[][] chunks;
	private ArrayList<Entity> entities;
	private double scale = 1;
	private int x, y; // middle of screen
	

	public Camera() {
		this(null, null, 0, 0);
	}
	public Camera(Chunk[][] chunks, ArrayList<Entity> entities, int x, int y){
		this.chunks = chunks;
		this.entities = entities;
		this.setX(x);
		this.setY(y);
	}
	public Camera(Chunk[][] chunks, ArrayList<Entity> entities){
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
			int offsetFactor = (int)(Chunk.getImageSize()*scale);
			for(int i = 0; i<chunks.length; i++){
				for(int u = 0; u<chunks[i].length; u++){
					g.drawImage(iA.resize(chunks[i][u].getImage(),scale), offsetFactor*i+getXCalibrated(), offsetFactor*u+getYCalibrated(),null);
				}
			}
		}
		else
			System.out.println("null chunks");
		if(entities != null){
			sortEntities();
			for(Entity e:entities){
				g.drawImage(iA.resize(e.getImage(), scale), (int)(scale*e.getX()+getXCalibrated()), (int)(scale*e.getY()+getYCalibrated()), null);
			}
		}
		else
			System.out.println("null entities");
	}
	private void sortEntities(){
		if(entities.size()>1);
		Entity temp;
        for (int i = 1; i < entities.size(); i++) {
            for(int j = i ; j > 0 ; j--){
                if(entities.get(j).getY() < entities.get(j-1).getY()){
                    temp = entities.get(j);
                    entities.set(j, entities.get(j-1));
                    entities.set(j-1, temp);
                }
            }
        }
	}
	private int getXCalibrated(){
		return (int)((Util.getScreenWidth()/2)-(this.x*scale));
	}
	private int getYCalibrated(){
		return (int)((Util.getScreenHeight()/2)-(this.y*scale));
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
		if(scale < .1)
			scale = .1;
		if(scale > 1.9)
			scale = 1.9;
	}
	public void setEntities(ArrayList<Entity> entities){
		this.entities = entities;
	}
	public ArrayList<Entity> getEntities(){
		return entities;
	}
	public void setChunks(Chunk[][] chunks){
		this.chunks = chunks;
	}
	public Chunk[][] getChunks(){
		return chunks;
	}

}
