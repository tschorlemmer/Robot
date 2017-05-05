package gameObjects;

import java.awt.Image;

public class Character extends Entity {

	private double angle;
	
	private double xVelocity;
	private double yVelocity;
	private double maxVelocity;
	private double friction;
	private double acceleration;
	private boolean accX, accY;
	
	public Character(double x, double y, Image sprites) {
		super(x, y, sprites);
		this.maxVelocity = 5;
		this.friction = .9;
		this.setAcceleration(1);
		this.accX = false;
		this.accY = false;
	}
	public Character(Image sprites){
		super(sprites);
		this.maxVelocity = 5;
		this.friction = .9;
		this.setAcceleration(1);
		this.accX = false;
		this.accY = false;
	}
	
	
	public double getAngle() {
		return angle;
	}
	public void setAngle(double angle) {
		this.angle = angle;
	}
	public double getxVelocity() {
		return xVelocity;
	}
	public void setxVelocity(double xVelocity) {
		this.xVelocity = xVelocity;
	}
	public void addxVeloity(double add){
		this.xVelocity+= add;
	}
	public double getyVelocity() {
		return yVelocity;
	}
	public void setyVelocity(double yVelocity) {
		this.yVelocity = yVelocity;
	}
	public void addyVeloity(double add){
		this.yVelocity+= add;
	}
	public double getFriction() {
		return friction;
	}
	public void setFriction(double friction) {
		this.friction = friction;
	}
	
	public void updateLocation(){
		if(xVelocity > maxVelocity)
			xVelocity = maxVelocity;
		if(yVelocity > maxVelocity)
			yVelocity = maxVelocity;
		this.addX(xVelocity);
		this.addY(yVelocity);
		
		if(accX)
			xVelocity += acceleration;
		else
			xVelocity *= friction;
		if(accY)
			yVelocity += acceleration;
		else
			yVelocity *= friction;
		
		
	}
	
	public double getAcceleration() {
		return acceleration;
	}
	public void setAcceleration(double acceleration) {
		this.acceleration = acceleration;
	}
	
}
