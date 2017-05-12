package gameObjects;

import gameFileIO.ImageReader;
import utility.Util;

public class ObjectManager {
	
	public static Chunk chunk = new Chunk(0);
	public static MovingEntity player = new MovingEntity(200, 200, ImageReader.getImageFromURL(Util.getFileURL("rsc\\TestBlock.png")));
	
	public static void update(){
		player.updateLocation();
	}
}
