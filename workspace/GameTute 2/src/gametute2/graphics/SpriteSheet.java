package gametute2.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	private String path;
	public final int SIZE;
	public int pixels[];
	public final int WIDTH,HEIGHT;
	public static SpriteSheet tiles = new SpriteSheet("/textures/SpriteSheet.png",256); //i'm already loading it, i wonder why the path is needed later on.
	public static SpriteSheet projectile_sword = new SpriteSheet("/textures/projectile.png",48);
	public static SpriteSheet player = new SpriteSheet("/textures/player.png",96,96);
	public static SpriteSheet player_down = new SpriteSheet(player,2,0,1,3,32);
	private Sprite[] sprites;
	public SpriteSheet(String path, int size) {
		this.path=path;
		SIZE= WIDTH = HEIGHT = size; // size as in the size of the full sprite sheet ? like height * width ? maybe. 
		pixels = new int[SIZE*SIZE];
		load();
		
	}
	public SpriteSheet(String path,int width,int height){
		WIDTH = width;
		HEIGHT = height;
		SIZE = width == height ? width : -1;
		this.path = path;
		pixels = new int[WIDTH * HEIGHT];
		load();
	}
	public SpriteSheet(SpriteSheet sheet,int x,int y,int width,int height,int spriteSize){
		int xx = x*spriteSize;
		int yy = y*spriteSize;
		int w = width*spriteSize;
		int h = height*spriteSize;
		WIDTH = w;
		HEIGHT = h;
		if(width == height)
			SIZE = width;
		else SIZE = -1;
		pixels = new int[w*h];
		for(int y0 = 0 ; y0 < h; y0++){
			int yp = yy + y0;
			for(int x0 = 0; x0 < w; x0++){
				int xp = xx + x0;
				pixels[x0 + y0 * w] = sheet.pixels[xp + yp * sheet.WIDTH];
			}
		}
		int frame = 0;
		sprites = new Sprite[width*height];
		for(int ya = 0; ya < height; ya++){
			for(int xa = 0; xa < width;xa++){
				int[] spritePixels = new int [spriteSize*spriteSize];
				for(int y0 = 0; y0 < spriteSize;y0++){
					for(int x0 = 0 ; x0 < spriteSize; x0++){
						spritePixels[x0 + y0*spriteSize] = pixels[(x0 + xa *spriteSize) + (y0 + ya * spriteSize)*width];
					}
				}
				Sprite sprite = new Sprite(spritePixels,spriteSize,spriteSize);
				sprites[frame++] = sprite;
			}
		}
	}
	private void load() {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public Sprite[] getSprite(){
		return sprites;
	}
}
