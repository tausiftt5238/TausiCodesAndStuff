package gametute2.level.tile;

import gametute2.graphics.Screen;
import gametute2.graphics.Sprite;

public class Tile {
	
	public int x,y;
	public Sprite sprite; //so Tile will take in some sprite.
	
	public static Tile grass = new GrassTile(Sprite.grass); //this makes the tile for a grass, hmm, i guess all the sprites will be stored in this class huh?
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite); 
	public static Tile wall1 = new spawn_wall1Tile(Sprite.wall1);
	public static Tile wall2 = new spawn_wall2Tile(Sprite.wall2);
	public static Tile floor = new spawn_floorTile(Sprite.floor);
	
	public static final int col_spawn_grass = 0xFF007F0E;
	public static final int col_spawn_hedge = 0;
	public static final int col_spawn_water = 0;
	public static final int col_spawn_wall1 = 0xFF404040;
	public static final int col_spawn_wall2 = 0xFF000000;
	public static final int col_spawn_floor = 0xFF7F3300;
	
	public Tile(Sprite sprite) {
		this.sprite = sprite; //really convenient :v 
	}
	
	public void render(int x, int y, Screen screen) { //didn't he render it ? i think he rendered it, okay time to get back to work.
	}
	
	public boolean solid() {
		return false;
	}
}
