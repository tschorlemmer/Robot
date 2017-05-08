package gameObjects;

import java.awt.Image;

public class Character extends Entity {

	private double angle;
	
	private double xVelocity;//2d velocities of the character
	private double yVelocity;
	private double maxVelocity;//maximum velocity of character in x and y direction
	private double friction;//defines how quickly the object stops moving ***LOWER THE VALUE - GREATER THE FRICTION
	private double acceleration;//defines how quickly an object starts moving
	private boolean moveUp, moveDown, moveLeft, moveRight;
	
	public Character(double x, double y, Image sprites) {
		super(x, y, sprites);
		setDefaultMovement();
	}
	public Character(Image sprites){
		super(sprites);
		setDefaultMovement();
	}
	
	private void setDefaultMovement(){//default movement values, can be changed through getters and setters
		this.maxVelocity = 20;
		this.friction = .8;
		this.setAcceleration(1);
		this.moveUp = false;
		this.moveDown = false;
		this.moveLeft = false;
		this.moveRight = false;
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
		
		if(moveRight && moveLeft)//check for horizontal movement cancellation ie - user going left and right at same time
			xVelocity *= friction;
		else if(moveRight){//if moving right
				if(acceleration > -(xVelocity-xVelocity*friction))//check to see if friction or acceleration will change velocity quicker
					xVelocity += acceleration;//adds to velocity
				else
					xVelocity *= friction;//use friction
			}
		else if(moveLeft){//if moving left, uses same concepts as above
			if(acceleration > (xVelocity-xVelocity*friction))
				xVelocity -= acceleration;
			else
				xVelocity *= friction;
		}
		else{//if not moving
			xVelocity *= friction;
		}
		
		
		if(moveUp && moveDown)//check for vert. movement cancellation
			yVelocity *= friction;	
		else if(moveUp){//if moving up
			if(acceleration > (yVelocity-yVelocity*friction))
				yVelocity -= acceleration;
			else
				yVelocity *= friction;
		}
		else if(moveDown){//if moving down
			if(acceleration > -(yVelocity-yVelocity*friction))
				yVelocity += acceleration;
			else
				yVelocity *= friction;
		}
		else{//if not moving
			yVelocity *= friction;
		}
		
		
		if(xVelocity > maxVelocity)//check to see if object is moving too fast
			xVelocity = maxVelocity;
		if(yVelocity > maxVelocity)
			yVelocity = maxVelocity;
		
		this.addX(xVelocity);//moving the object by adding velocity values to the x and y position
		this.addY(yVelocity);
	}
	
	public double getAcceleration() {
		return acceleration;
	}
	public void setAcceleration(double acceleration) {
		this.acceleration = acceleration;
	}
	public boolean isMoveUp() {
		return moveUp;
	}
	public void setMoveUp(boolean moveUp) {
		this.moveUp = moveUp;
	}
	public boolean isMoveDown() {
		return moveDown;
	}
	public void setMoveDown(boolean moveDown) {
		this.moveDown = moveDown;
	}
	public boolean isMoveLeft() {
		return moveLeft;
	}
	public void setMoveLeft(boolean moveLeft) {
		this.moveLeft = moveLeft;
	}
	public boolean isMoveRight() {
		return moveRight;
	}
	public void setMoveRight(boolean moveRight) {
		this.moveRight = moveRight;
	}
	
}
