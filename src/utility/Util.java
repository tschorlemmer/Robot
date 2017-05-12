package utility;

import java.awt.GraphicsEnvironment;
import java.io.InputStream;
import java.net.URL;

public class Util {
	
	public final static int IMAGESIZE = 64;
	
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
	
	//returns the stream for the resource
	public static InputStream getFileStream(String fileName){
		return Util.class.getResourceAsStream(fileName);
	}
	//returns the url for the resource
	public static URL getFileURL(String fileName){
		return Util.class.getClassLoader().getResource(fileName);
	}
}
