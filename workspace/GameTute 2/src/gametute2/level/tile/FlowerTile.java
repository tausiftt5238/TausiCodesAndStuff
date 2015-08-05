package gametute2.level.tile;

import gametute2.graphics.Screen;
import gametute2.graphics.Sprite;

public class FlowerTile extends Tile {

	public FlowerTile(Sprite sprite) {
		super(sprite);
	}
	@Override
	public void render(int x,int y, Screen screen) {
		//render stuff here
		screen.renderTile(x <<4 , y << 4, this);
	}
}