package gameObjects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import utility.Util;

public class Chunk {
	
	public final static int SIZE = 16;//constant x and y size of the grid
	
	Tile[][] tiles;//all of the tiles in the chunk

	public Chunk() {
		tiles = new Tile[SIZE][SIZE];//creates empty chunk with default size
	}
	public Chunk(int tileID){
		this();
		fillAll(tileID);//creates chunk filled with same tile
	}
	
	public void fillAll(int tileID){
		for(int x = 0; x < SIZE; x++)
			for(int y = 0; y < SIZE; y++)
				tiles[x][y] = new Tile(tileID);//changes all the tiles to a certain type
	}
	
	public Tile getTile(int x, int y){
		if(x < SIZE && x >= 0 && y < SIZE && y > 0)
			return tiles[x][y];
		return null;
	}
	public void setTile(Tile tile, int x, int y){
		tiles[x][y] = tile;
	}
	public Tile[][] getTiles(){
		return tiles;
	}
	public void setTiles(Tile[][] tiles){
		this.tiles = tiles;
	}
	public static int getImageSize(){
		return (int)(SIZE*Util.IMAGESIZE);
	}
	public Image getImage(){
		int s = getImageSize();
		
		BufferedImage image = new BufferedImage(s,s,BufferedImage.TYPE_INT_ARGB);
		Graphics g = image.getGraphics();
		for(int x = 0; x < SIZE; x++){
			for(int y = 0; y < SIZE; y++){
				g.drawImage(tiles[x][y].getImage(),(int)(x*Util.IMAGESIZE),(int)(y*Util.IMAGESIZE),null);
			}
		}
		return image;
	}
}
