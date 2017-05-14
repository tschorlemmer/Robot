package gameObjects;

import gameFileIO.ImageReader;
import utility.Util;

public class ObjectManager {
	
	public static MovingEntity player = new MovingEntity(200, 200, ImageReader.getImageFromURL(Util.getFileURL("rsc\\TestBlock.png")));
	public static GameMap map = new GameMap(2,2,0);
	
	public static void update(){
		player.updateLocation();
	}
	public static void addItem(Item i){
		int x = map.getChunkX((int)i.getX());
		int y = map.getChunkY((int)i.getY());
		
		if(x <= map.getWidth() && y <= map.getHeight());
			map.getIChunks()[x][y].addItem(i);
	}
}
