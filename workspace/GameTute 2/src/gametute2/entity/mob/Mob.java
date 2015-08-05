package gametute2.entity.mob;

import gametute2.entity.Entity;
import gametute2.entity.particle.Particle;
import gametute2.entity.projectile.Projectile;
import gametute2.entity.projectile.SwordProjectile;
import gametute2.graphics.Sprite;

public abstract class Mob extends Entity{
	
	protected Sprite sprite;
	protected int dir = -1;	//0 = NORTH, 1 = EAST , 2 = SOUTH , 3 = WEST
	protected boolean moving = false;
	protected boolean walking = false;
	
	//protected List<Projectile> projectiles = new ArrayList<Projectile> ();
	
	public void move(int xChange, int yChange){
		if(xChange != 0 && yChange != 0){
			move(xChange,0);
			move(0,yChange);
			return;
		}
		if(xChange > 0 ) dir = 1;
		if(xChange < 0 ) dir = 3;
		if(yChange > 0 ) dir = 2;
		if(yChange < 0 ) dir = 0;
		
		if(!collision(xChange,yChange)){
			x += xChange;
			y += yChange;
		}
		
	}
	protected void shoot(int x, int y , double dir){
		//System.out.println("angle: " + dir);
		Projectile p = new SwordProjectile(x,y,dir);
		//projectiles.add(p);
		level.add(p);
	}
	@Override
	public void update(){
		
	}
	public void render(){
		
	}
	private boolean collision(int xa,int ya){
		boolean solid = false;
		int xt,yt;
		for(int c = 0; c < 4; c++){
			xt = ((x + xa) + c % 2 * 12 - 7) / 16; //change the multiplication part and subtraction to your own advantage
			yt = ((y + ya) + c / 2 * 12 + 3) / 16;
			if(level.getTile(xt,yt).solid()) solid = true;
		}
		return solid;
	}
}
