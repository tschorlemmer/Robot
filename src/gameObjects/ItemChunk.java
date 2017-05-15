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
		sortItems();
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
		Item temp;
        for (int i = 1; i < items.size(); i++) {
            for(int j = i ; j > 0 ; j--){
                if(items.get(j).getY() < items.get(j-1).getY()){
                    temp = items.get(j);
                    items.set(j, items.get(j-1));
                    items.set(j-1, temp);
                }
            }
        }
	}
	
	public ArrayList<Item> update(){
		sortItems();
		return grabLooseItems();
	}
}
