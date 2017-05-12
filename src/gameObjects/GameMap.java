package gameObjects;

import utility.Util;

public class GameMap {
	
	private Chunk[][] chunks;
	
	public GameMap(int width, int height, int tileID) {
		chunks = new Chunk[width][height];
		fillAll(tileID);
	}
	public GameMap(Chunk[][] chunks){
		this.chunks = chunks;
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
	public int getChunkX(int x){
		return x/(Chunk.SIZE*Util.IMAGESIZE);
	}
	public int getChunkY(int y){
		return y/(Chunk.SIZE*Util.IMAGESIZE);
	}
	
	public Chunk getChunk(int x, int y){
		return chunks[x][y];
	}
	public void setShunk(int x, int y, Chunk chunk){
		chunks[x][y] = chunk;
	}
	
	public Chunk[][] getChunks(){
		return chunks;
	}
	public void setChunks(Chunk[][] chunks){
		this.chunks = chunks;
	}

}
