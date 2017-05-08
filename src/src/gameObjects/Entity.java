package gameObjects;

import java.awt.Image;

public class Entity {
	
	private long x;
	private long y;
	
	private Image image;
	
	public Entity(long x, long y, Image image){
		this.setX(x);
		this.setY(y);
		this.setImage(image);
	}
	public Entity(Image image){
		this(0,0,image);
	}
	public long getX() {
		return x;
	}
	public void setX(long x) {
		this.x = x;
	}
	public long getY() {
		return y;
	}
	public void setY(long y) {
		this.y = y;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
}
