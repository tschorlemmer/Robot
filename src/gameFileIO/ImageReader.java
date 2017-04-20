package gameFileIO;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageReader {
	public static Image getImageFromFile(File f){// reads an image from the file specified
		try{
			return ImageIO.read(f);
		}catch(IOException e){
			e.printStackTrace(); // prints stack trace
		}
		return null;//if there is not file to read
	}
}
