package gameObjects;

import utility.Util;

public class GameMap {
	
	private Chunk[][] chunks;
	private double scale;
	
	public GameMap(int width, int height, int tileID) {
		chunks = new Chunk[width][height];
		fillAll(tileID);
	}
	public GameMap(Chunk[][] chunks){
		this.chunks = chunks;
	}
	public void fillAll(int tileID){
		for(Chunk[] x:chunks)
			for(Chunk y:x)
				y.fillAll(tileID);
	}
	public double getScale() {
		return scale;
	}
	public void setScale(double scale) {
		this.scale = scale;
		for(Chunk[] x:chunks)
			for(Chunk y:x)
				y.setScale(scale);
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

}
