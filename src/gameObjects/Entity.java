package gameObjects;

import java.awt.Image;
import java.util.ArrayList;

import graphics.Sprite;

public class Entity {
	
	private double x;
	private double y;
	
	private Image image;
	private int selectedSprite;
	
	public Entity(double x, double y, Image sprites){
		this.selectedSprite = 0;
		this.x = x;
		this.y = y;
		this.image = sprites;
	}
	public Entity(Image sprites){
		this(0,0,sprites);
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void addX(double x){
		this.x += x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void addY(double y){
		this.y += y;
	}
	public Image getImage() {
		return image;
	}
}
