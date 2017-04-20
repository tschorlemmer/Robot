package utility;

import java.awt.GraphicsEnvironment;

public class Util {
	
	//returns the system time in milliseconds
	public static long getTime(){
		return System.currentTimeMillis();
	}
	
	//returns the width and height of the screen
	public static int getScreenWidth(){
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
	}
	public static int getScreenHeight(){
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
	}
	
}
