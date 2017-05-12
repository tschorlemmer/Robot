package gameFileIO;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImageReader {
	
	public static Image getImageFromFile(File f){// reads an image from the file specified
		if(f != null)//check to make sure object is not null
			try{
				return ImageIO.read(f);
			}catch(IOException e){
				e.printStackTrace();
			}
		nife();
		return null;//if there is not file to read
	}
	
	//returns an image from the inputstream passed to it
	public static Image getImageFromStream(InputStream is){
		if(is != null)//check to make sure object is not null
			try{
				return ImageIO.read(is);
			}
			catch(IOException e){
				e.printStackTrace();
			}
		nife();
		return null;//if there is not a file found to be read
	}
	
	//returns an iage from the url passed to it
	public static Image getImageFromURL(URL url){
		if(url != null)//check to make sure object is not null
			try{
				return ImageIO.read(url);
			}
			catch(IOException e){
				e.printStackTrace();
			}
		nife();
		return null;//if there is not a file found to be read
	}
	
	private static void nife(){//no image found error
		System.out.println("No Image Found, returning null");
	}
}
