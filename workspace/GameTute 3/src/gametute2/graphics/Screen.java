package gametute2.graphics;

import gametute2.level.tile.Tile;

import java.util.Random;

public class Screen {
	public int width,height;
	public final int MAP_SIZE = 64;
	public int pixels[];
	//public int tiles[] = new int[MAP_SIZE * MAP_SIZE];
	public int xOffset, yOffset;

	//private Random random = new Random();
	
	public Screen(int width,int height) {
		this.width=width;
		this.height=height;
		pixels = new int[width*height];
		
		/*for(int i=0; i< MAP_SIZE*MAP_SIZE; i++)
			tiles[i] = random.nextInt(0xffffff);*/
	}
	
	public void clear() {
		for(int i=0; i<pixels.length; i++)
			pixels[i]=0;
	}
	
	public void renderTile(int xp, int yp, Tile tile) { //THIS IS RENDERING A SINGLE FUCKING TILE DAMMIT!!!
		xp -= xOffset;
		yp -= yOffset;
		for(int y=0; y<tile.sprite.SIZE; y++) {
			int ya = y + yp; //y-absolute, y of tile, y-position (how much shifted THIS tile is from the corner of the screen)
			for(int x=0; x<tile.sprite.SIZE; x++) {
				int xa = x + xp; //x-absolute
				if(xa<(-tile.sprite.SIZE) || xa>=width || ya<0 || ya>=height) break;
				if(xa<0) xa=0;
				pixels[xa+ya*width] = tile.sprite.pixels[x+y*tile.sprite.SIZE];
				
			}
		}
	}
	
	public void setOffset(int xOffset,int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
}
