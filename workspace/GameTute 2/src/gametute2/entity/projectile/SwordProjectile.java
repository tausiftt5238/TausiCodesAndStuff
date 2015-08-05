package gametute2.entity.projectile;

import gametute2.entity.spawner.ParticleSpawner;
import gametute2.entity.spawner.Spawner;
import gametute2.graphics.Screen;
import gametute2.graphics.Sprite;

public class SwordProjectile extends Projectile{
	public static final int FIRERATE = 15;
	
	public SwordProjectile (int x, int y, double dir){
		super(x,y,dir);
		range = 100	;
		damage = 20;
		
		speed = 4;
		sprite = Sprite.projectile_sword;
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}
	public void update(){
		if(level.tileCollision((int)(x + nx),(int)(y + ny), 9,6,0)){
			
			level.add(new ParticleSpawner((int)x , (int)y, 44,50,level	));
			remove();
		}
		move();
	}
	
	
	
	public void move(){
		x += nx;
		y += ny;
		if(distance() > range) remove();
		
	}
	public void render(Screen screen){
		screen.renderProjectile((int)x, (int)y, this);
	}
	private double distance(){
		double dist = Math.sqrt(Math.abs((xOrigin - x)*(xOrigin - x) + (yOrigin - y) * (yOrigin - y)));
		return dist;
	}
}