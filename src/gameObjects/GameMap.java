package gameObjects;

import utility.Util;

public class GameMap {
	
	private Chunk[][] chunks;
	private ItemChunk[][] iChunks;
	private int width, height;
	
	public GameMap(int width, int height, int tileID) {
		chunks = new Chunk[width][height];
		iChunks = new ItemChunk[width][height];
		this.width = width;
		this.height = height;
		fillAll(tileID);
		createIChunks();
	}
	public GameMap(Chunk[][] chunks){
		this.chunks = chunks;
		this.width = chunks.length;
		this.height = chunks[0].length;
		iChunks = new ItemChunk[width][height];
		createIChunks();
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	public void fillAll(int tileID){
		for(int x = 0;x<chunks.length; x++){
			for(int y = 0; y<chunks[x].length; y++){
				if(chunks[x][y]!= null)
					chunks[x][y].fillAll(tileID);
				else
					chunks[x][y] = new Chunk(tileID);
			}
		}	
	}
	private void createIChunks(){
		for(int x = 0; x < iChunks.length; x++){
			for(int y = 0; y < iChunks[x].length; y++){
				iChunks[x][y] = new ItemChunk(x, y);
			}
		}
	}
	public int getChunkX(int x){
		return x/(Chunk.SIZE*Util.IMAGESIZE);
	}
	public int getChunkY(int y){
		return y/(Chunk.SIZE*Util.IMAGESIZE);
	}
	
	public Chunk getChunk(int x, int y){
		return chunks[x][y];
	}
	public void setChunk(int x, int y, Chunk chunk){
		chunks[x][y] = chunk;
	}
	public Chunk[][] getChunks(){
		return chunks;
	}
	public void setChunks(Chunk[][] chunks){
		this.chunks = chunks;
	}
	
	public ItemChunk getIChunk(int x, int y){
		return iChunks[x][y];
	}
	public void setIChunk(int x, int y, ItemChunk chunk){
		iChunks[x][y] = chunk;
	}
	public ItemChunk[][] getIChunks(){
		return iChunks;
	}
	public void setIChunks(ItemChunk[][] chunks){
		this.iChunks = chunks;
	}

}
