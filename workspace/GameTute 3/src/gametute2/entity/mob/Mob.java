package gametute2.entity.mob;

import gametute2.entity.Entity;
import gametute2.graphics.Sprite;

public abstract class Mob extends Entity {
	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	
	public void move() {
	}
	
	public void update() {
	}

	public boolean collision() { //if collision, true
		return false;
	}
}
