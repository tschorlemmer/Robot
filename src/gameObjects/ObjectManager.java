package gameObjects;

import gameFileIO.ImageReader;
import utility.Util;

public class ObjectManager {
	
	public static Character player = new Character(200, 200, ImageReader.getImageFromURL(Util.getFileURL("rsc\\TestBlock.png")));
	
	public static void update(){
		player.updateLocation();
	}
}
