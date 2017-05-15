package gameObjects;

import java.awt.Image;

import gameFileIO.ImageReader;
import utility.Util;

public class Tile {

	private int ID;
	
	
	public Tile(int tileID) {// should not need to be used - chunk should use its own x/y positioning
		this.setID(tileID);
	}
	public int getID() {//returns the id of the tile
		return ID;
	}
	public void setID(int id) {//sets the id of the tile, effectively changing the tile type
		ID = id;
	}
	public Image getImage(){
		return ObjectManager.tileHolder.getImage(ID);
	}


}
