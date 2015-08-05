package gametute2.level.tile;

import gametute2.graphics.Screen;
import gametute2.graphics.Sprite;

public class VoidTile extends Tile {
	public VoidTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x,int y, Screen screen) {
		//render stuff here
		screen.renderTile(x << 4, y << 4, this);
	}
	
}
