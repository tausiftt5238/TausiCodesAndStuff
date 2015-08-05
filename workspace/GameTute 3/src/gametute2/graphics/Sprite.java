package gametute2.graphics;

import java.awt.Color;

public class Sprite {
	
	public final int SIZE;
	private int x,y; //co-ordinates of our sprite
	public int pixels[];
	private SpriteSheet sheet;
	
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles); //Sprites are static
	public static Sprite voidSprite = new Sprite(16, 0x0000ff);
	
	public Sprite(int size, int color) {
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		setColor(color);
	}
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE=size;
		pixels = new int[SIZE*SIZE];
		this.x = x * SIZE;
		this.y = y * SIZE;
		
		
		this.sheet = sheet;
		load();
	}
	
	private void setColor(int color) {
		for(int i=0; i<SIZE*SIZE; i++) {
			pixels[i] = color;
		}
	}
	
	private void load() {
		for(int j = 0; j<SIZE; j++)
			for(int i = 0; i<SIZE; i++) {
				pixels[i+(j*SIZE)] = sheet.pixels[(i+x) + ((j+y)*sheet.SIZE)];
			}
	}
	
}
