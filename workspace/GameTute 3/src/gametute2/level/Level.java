package gametute2.level;

import gametute2.graphics.Screen;
import gametute2.level.tile.Tile;

public class Level {
	protected int width, height;
	protected int tiles[];	//specify an integer that will say what type of tile it is
	
	public Level(int width, int height) {
		this.width= width;
		this.height= height;
		tiles = new int[width * height];
		generateLevel();
	}
	
	public Level(String path) {
		loadLevel(path);
	}
	
	protected void generateLevel() {
		
	}
	
	private void loadLevel(String path) {
		
	}
	
	public void update() {
		
	}
	
	public void time() {
		
	}
	
	public void render(int xScroll, int yScroll, Screen screen) {
		//Get Player Dislocation
		screen.setOffset(xScroll, yScroll);
		//Corner Pins into tile precision
		int x0= xScroll >> 4;
		int x1= (xScroll + screen.width + 16) >> 4;
		int y0= yScroll >> 4;
		int y1= (yScroll + screen.height + 16) >> 4;
		
		for(int y = y0; y < y1 ; y++) {
			for(int x = x0; x < x1; x++) {
				getTile(x,y).render(x, y, screen); //Just for this line we put a render method in Tile that just ends up calling renderTile() anyways
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		if(x<0 || x>=width || y<0 || y>=height) return Tile.voidTile;
		if(tiles[x+y*width]==0) return Tile.grass;
		return Tile.voidTile;
	}
	
	
	
}
