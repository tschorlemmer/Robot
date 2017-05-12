package gameObjects;

import gameFileIO.ImageReader;
import utility.Util;

public class ObjectManager {
	
	public static Chunk chunk = new Chunk(1);
	public static MovingEntity player = new MovingEntity(200, 200, ImageReader.getImageFromURL(Util.getFileURL("rsc\\TestBlock.png")));
	public static GameMap map = new GameMap(2,2,1);
	
	public static void update(){
		player.updateLocation();
	}
}
