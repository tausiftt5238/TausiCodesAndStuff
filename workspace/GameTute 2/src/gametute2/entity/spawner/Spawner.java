package gametute2.entity.spawner;

import gametute2.entity.Entity;
import gametute2.entity.particle.Particle;
import gametute2.level.Level;

public class Spawner extends Entity{
	
	public enum Type {
		PARTICLE,MOB;
	}
	
	private Type type;
	
	public Spawner(int x,int y, Type type,int amount, Level level){
		init(level);
		this.x = x;
		this.y = y;
		this.type = type;
		
	}
	
}
