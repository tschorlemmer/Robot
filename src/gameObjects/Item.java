package gameObjects;

import java.awt.Image;

import gameFileIO.ImageReader;
import utility.Util;

public class Item extends MovingEntity{
	
	private int ID;

	public Item(double x, double y, int itemID) {
		super(x, y, ImageReader.getImageFromURL(Util.getFileURL("rsc\\items\\item_"+itemID+".png")));
	}
	
}
