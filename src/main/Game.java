package main;

import graphics.GameWindow;
import utility.Util;

//the backbone of the game - holds the loop and all the outside objects
public class Game {
	
	
	private long lastUpdate; //ms of the last update
	private final long CLOCK_SPEED; //time between the updates
	private boolean gameRunning;
	

	
	//constructors
	public Game(long CLOCK_SPEED){
		this.CLOCK_SPEED = CLOCK_SPEED;
		lastUpdate = 0;
		gameRunning = true;
	}
	public Game(){
		this(33);
	}
	
	
	//starts the game by initializing values and beginning the loop
	public void start(){
		initGraphics();
		initLogic();
		loop();
	}
	
	//ends the game
	public void stop(){
		this.gameRunning = false;
	}
	
	private GameWindow gameWindow;
	private void initGraphics(){
		gameWindow = new GameWindow();
		gameWindow.setVisible(true);
	}
	private void initLogic(){
		
	}
	
	
	private void loop(){
		
		long currentTime;//temporary variable for the current time - used in comparison to last update
		
		currentTime = Util.getTime();//init current time
		lastUpdate = currentTime;//init last update to that of the current time
		
		while(this.gameRunning){ //check if the game is still running
			
			currentTime = Util.getTime();//update time
			//System.out.println("curtime:"+currentTime);
			
			/*checks if the current time is greater than the last update + the clock speed
			while this is true, the game gets updated until the current time is less than
			the last update + the clock speed
			this works to update the game as quickly as possible and keep the game frame rate
			independent*/
			while(currentTime > this.lastUpdate + this.CLOCK_SPEED){ 
				
				
				updateLogic();
				this.lastUpdate+=this.CLOCK_SPEED;
				
			}
			
			updateGraphics();
		}
	}
	
	private void updateLogic(){
		
	}
	private void updateGraphics(){
		gameWindow.repaint();
	}
	
	//getters and setters for the gameRunning variable
	public void setGameRunning(boolean gameRunning){
		this.gameRunning = gameRunning;
	}
	public boolean getGameRunning(){
		return this.gameRunning;
	}
	
}
