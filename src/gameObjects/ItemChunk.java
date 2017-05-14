package gameObjects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import utility.Util;

public class ItemChunk {
	
	private ArrayList<Item> items;
	public int x, y;
	
	public ItemChunk(int x, int y){
		items = new ArrayList<Item>();
		this.x = x;
		this.y = y;
	}
	
	public void addItem(Item item){
		items.add(item);
	}
	public ArrayList<Item> getItems(){
		return items;
	}
	public void setItems(ArrayList<Item> items){
		this.items = items;
	}
	
	private ArrayList<Item> grabLooseItems(){
		ArrayList<Item> looseItems = new ArrayList<Item>();
		
		int chunkMinX = x*Chunk.SIZE*Util.IMAGESIZE;
		int chunkMinY = y*Chunk.SIZE*Util.IMAGESIZE;
		
		int chunkMaxX = (x+1)*Chunk.SIZE*Util.IMAGESIZE;
		int chunkMaxY = (y+1)*Chunk.SIZE*Util.IMAGESIZE;
		
		for(Item i:items){
			if(i.getX() < chunkMinX || i.getX() >= chunkMaxX || i.getY() < chunkMinY || i.getY() >= chunkMaxY){
				items.remove(i);
				looseItems.add(i);
			}
		}
		
		return looseItems;
	}
	
	private void sortItems(){
		if(items.size()>1);
		for(int i = 0; i < items.size(); i++){
			Item temp = items.get(i);
			int u = i+1;
			while(u < items.size() && temp.getY()>items.get(u).getY()){
				items.set(u-1, items.get(u));
				u++;
			}
			items.set(u, temp);
		}
	}
	
	public ArrayList<Item> update(){
		sortItems();
		return grabLooseItems();
	}
}
