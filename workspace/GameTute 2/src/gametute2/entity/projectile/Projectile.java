package gametute2.entity.projectile;

import gametute2.entity.Entity;
import gametute2.graphics.Sprite;

public abstract class Projectile extends Entity{

	protected final int xOrigin,yOrigin;
	protected double x,y;
	protected double angle;
	protected Sprite sprite;
	protected double nx,ny;
	protected double distance;
	protected double speed ,range, damage;
	public Projectile(int x,int y,double dir ){
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		this.x = x;
		this.y = y;
		
	}
	public Sprite getSprite(){
		return sprite;
	}
	protected void move(){
		
	}
}


