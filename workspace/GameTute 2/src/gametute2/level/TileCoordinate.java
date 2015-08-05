package gametute2.level;

public class TileCoordinate {
	public int x;
	public int y;
	protected final int TILE_SIZE = 16;
	public TileCoordinate(int x,int y){
		this.x = x * TILE_SIZE;
		this.y = y * TILE_SIZE;
		
	}
	public int X(){
		return x;
	}
	public int Y(){
		return y;
	}
	public int[] xy(){
		int[] r = {x,y};
		return r;
	}
}
