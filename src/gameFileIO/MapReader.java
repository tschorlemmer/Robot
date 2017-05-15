package gameFileIO;

import java.awt.Image;
import java.awt.image.BufferedImage;

import gameObjects.Chunk;
import gameObjects.GameMap;
import gameObjects.ObjectManager;
import gameObjects.Tile;
import utility.Util;

public class MapReader {
	
	public static void readMapFromPicture(String pictureName){
		
		System.out.println("Derp");
		
		BufferedImage i = (BufferedImage) ImageReader.getImageFromURL(Util.getFileURL("rsc\\saves\\"+pictureName));
		Chunk[][] chunks = new Chunk[i.getWidth(null)/Chunk.SIZE][i.getHeight(null)/Chunk.SIZE];
		
		for(int x = 0; x < chunks.length; x++){
			for(int y = 0; y < chunks[x].length; y++){
				
				chunks[x][y] = new Chunk();
				Tile[][] tiles = chunks[x][y].getTiles();
				
				for(int u = 0; u < tiles.length; u++){
					for(int z = 0; z < tiles[u].length; z++){
						
						tiles[u][z] = new Tile(getTileIDFromColor(i.getRGB(x*Chunk.SIZE+u, y*Chunk.SIZE+z)));
						
					}
				}
				
				
			}
		}
		
		ObjectManager.map = new GameMap(chunks);
	}

	private static int getTileIDFromColor(int rgb) {
		switch(rgb){
			case 0xffffff00:
				return 5;
			case 0xffff0000:
				return 4;
			case 0xff00ffff:
				return 3;
			case 0xff0000ff:
				return 2;
			case 0xff000000:
				return 1;
			case 0xff00ff00:
				return 0;
			default:
				return 0;
		}
	}
}
