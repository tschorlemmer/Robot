package gameObjects;

import java.awt.Image;

import gameFileIO.ImageReader;
import utility.Util;

public class TileHolder {
	
	Image[] tileImages;
	
	public TileHolder(int numTiles){
		tileImages = new Image[numTiles];
		init();
	}
	private void init(){
		for(int x = 0; x < tileImages.length; x++){
			tileImages[x] = ImageReader.getImageFromURL(Util.getFileURL("rsc\\tiles\\tile_"+x+".png"));
		}
	}
	public Image getImage(int number){
		return tileImages[number];
	}
}
