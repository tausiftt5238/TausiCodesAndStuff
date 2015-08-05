package gametute2.graphics;

import java.awt.Color;

public class Sprite {
	
	public final int SIZE;
	private int x,y; //co-ordinates of our sprite
	public int pixels[]; //is it storing the pixel of the tile or whole freaking screen?
	protected SpriteSheet sheet; //let sheet where every sprite is stored.
	private int width, height;
	//Tiles' sprite over here.
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles); //Sprites are static
	public static Sprite voidSprite = new Sprite(16, 0x1B87E0); //making void out of color -_- god i was lost here -_- 
	public static Sprite flower = new Sprite(16 ,1 , 0 , SpriteSheet.tiles);
	public static Sprite rock = new Sprite(16 ,2, 0, SpriteSheet.tiles);
	public static Sprite floor = new Sprite(16, 0, 1, SpriteSheet.tiles);
	public static Sprite wall1 = new Sprite(16, 0, 2, SpriteSheet.tiles);
	public static Sprite wall2 = new Sprite(16, 1, 1, SpriteSheet.tiles);
	//player sprites over here.
	public static Sprite playerForward = new Sprite(32, 0, 5, SpriteSheet.tiles);
	public static Sprite playerBackward = new Sprite(32, 2, 5, SpriteSheet.tiles);
	public static Sprite playerSide = new Sprite(32, 1, 5, SpriteSheet.tiles);
	
	public static Sprite playerForward1 = new Sprite(32, 0, 6,SpriteSheet.tiles);
	public static Sprite playerForward2 = new Sprite(32, 0, 7,SpriteSheet.tiles);
	
	public static Sprite playerSide1 = new Sprite(32, 1, 6,SpriteSheet.tiles);
	public static Sprite playerSide2 = new Sprite(32, 1, 7,SpriteSheet.tiles);
	
	public static Sprite playerBackward1 = new Sprite(32, 2, 6,SpriteSheet.tiles);
	public static Sprite playerBackward2 = new Sprite(32, 2, 7,SpriteSheet.tiles);
	//projectile sprites here
	
	public static Sprite partcile_normal  = new Sprite(3,0xFF00FF);
	public static Sprite projectile_sword = new Sprite(16,0,0,SpriteSheet.projectile_sword);
	
	protected Sprite(SpriteSheet sheet,int width,int height){
		this.sheet = sheet;
		this.width = width;
		this.height = height;
		SIZE = width == height ? width : -1;
	}
	
	public Sprite(int size, int color) {
		SIZE = size;
		width = height = SIZE;
		pixels = new int[SIZE*SIZE]; //as it's basically 16 x 16 , i will take that the pixel array will hold the pixels of one tile.
		setColor(color); 
	}
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE=size;
		this.width = this.height = size;
		pixels = new int[SIZE*SIZE];
		this.x = x * SIZE;
		this.y = y * SIZE;
		//i'm trying to understand why was it multiplied :\
		//oh wait, it means co-ordinate of the sprite sheet, for that i WILL need to multiply.
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int width,int height,int color){
		this.width = width;
		this.height = height;
		SIZE = width == height ? width : -1;
		pixels = new int[width * height];
		setColor(color);
	}
	public Sprite(int[] pixels, int width, int height) {
		SIZE = width == height ? width : -1;
		this.width = width;
		this.height = height;
		this.pixels = pixels;
	}

	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	
	private void setColor(int color) {
		for(int i=0; i<width*height; i++) {
			pixels[i] = color;
		}
	}
	
	private void load() {
		for(int j = 0; j<SIZE; j++)
			for(int i = 0; i<SIZE; i++) {
				pixels[i+(j*SIZE)] = sheet.pixels[(i+x) + ((j+y)*sheet.SIZE)]; // wait why i + x and j + y ? :\ is anyone going to explain it to me ? -_-
			}
	}
	
}
