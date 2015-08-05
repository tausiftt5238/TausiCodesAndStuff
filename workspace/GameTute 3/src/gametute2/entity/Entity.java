package gametute2.entity;

import gametute2.graphics.Screen;
import gametute2.level.Level;

import java.util.Random;

public abstract class Entity {
	public int x,y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	
	public void update() {
	}
	
	public void render(Screen screen) {
	}
	
	public void remove() {
		//Remove from level
		removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}
}
