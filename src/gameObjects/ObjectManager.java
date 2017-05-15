package gameObjects;

import java.util.ArrayList;

import gameFileIO.ImageReader;
import graphics.GameWindow;
import utility.Util;

public class ObjectManager {
	
	public static MovingEntity player = new MovingEntity(200, 200, ImageReader.getImageFromURL(Util.getFileURL("rsc\\TestBlock.png")));
	public static GameMap map = new GameMap(50,50,0);
	public static TileHolder tileHolder = new TileHolder(6);
	
	public static void update(){
		player.updateLocation();
		updateCamera();
	}
	public static void addItem(Item i){
		int x = map.getChunkX((int)i.getX());
		int y = map.getChunkY((int)i.getY());
		
		if(x <= map.getWidth() && y <= map.getHeight() && x >= 0 && y >= 0);
			map.getIChunks()[x][y].addItem(i);
	}
	
	private static void updateCamera(){
		
		int x = (int)(GameWindow.getCamera().getX()-((1/GameWindow.getCamera().getScale())*(Util.getScreenWidth()/2.0)));
		int y = (int)(GameWindow.getCamera().getY()-((1/GameWindow.getCamera().getScale())*(Util.getScreenHeight()/2.0)));
		
		int xr = (int)(GameWindow.getCamera().getX()+((1/GameWindow.getCamera().getScale())*(Util.getScreenWidth()/2.0)));
		int yd = (int)(GameWindow.getCamera().getY()+((1/GameWindow.getCamera().getScale())*(Util.getScreenHeight()/2.0)));
		
//		System.out.println("x: " + x + " xr: " + xr);
//		System.out.println("y: " + y + " yd: " + yd);

		int height;
		int width;
		
		x = map.getChunkX((int) (x));
		y = map.getChunkY((int) (y));
		xr = map.getChunkX((int) (xr));
		yd = map.getChunkY((int) (yd));
		
//		System.out.println("x: " + x + " xr: " + xr);
//		System.out.println("y: " + y + " yd: " + yd);

		
		if(x < 0)
			x = 0;
		if(y < 0)
			y = 0;

		if(map.getWidth() <= xr+1)
			width = map.getWidth()-x;
		else
			width = xr+1-x;
		if(map.getHeight() <= yd+1)
			height = map.getHeight()-y;
		else
			height = yd+1-y;
		
		if(width < 0)
			width = 0;
		if(height < 0)
			height = 0;
		
		Chunk[][] chunks = new Chunk[width][height];
		
		ArrayList<Entity> entities = new ArrayList<Entity>();
		entities.add(player);
		
		for(int i = 0; i < width; i++){
			for(int z = 0; z < height; z++){
				chunks[i][z] = map.getChunk(i+x, z+y);
				entities.addAll(map.getIChunk(i+x, z+y).getItems());
			}
		}
		
		GameWindow.getCamera().setChunks(chunks);
		GameWindow.getCamera().setEntities(entities);
		
		
	}
}
