package gametute2.level;

import gametute2.entity.Entity;
import gametute2.entity.particle.Particle;
import gametute2.entity.projectile.Projectile;
import gametute2.entity.spawner.Spawner;
import gametute2.graphics.Screen;
import gametute2.level.tile.Tile;

import java.util.ArrayList;
import java.util.List;

public class Level {
	protected int width, height;
	protected int tilesInt[];	//specify an integer that will say what type of tile it is
	protected int[] tiles;
	public static Level spawn = new Level("textures/spawn.png");
	
	private List<Entity> entities = new ArrayList<Entity> ();
	private List<Projectile> projectiles = new ArrayList<Projectile> ();
	private List<Particle> particles = new ArrayList<Particle>();
	
	public Level(int width, int height) {
		this.width= width;
		this.height= height;
		tilesInt = new int[width * height];
		generateLevel();
	}
	
	public Level(String path) {
		loadLevel(path);
		generateLevel();
		
	}
	
	protected void generateLevel() {
		
	}
	
	protected void loadLevel(String path) {
		
	}
	
	public void update() {
		for(int i = 0 ; i < entities.size(); i++)
			entities.get(i).update();
		for(int i = 0; i < projectiles.size(); i ++){
			projectiles.get(i).update();
		}
		for(int i = 0; i < particles.size(); i ++){
			particles.get(i).update();
		}
		remove();
	}
	public List <Projectile> getProjectile(){
		return projectiles;
	}
	public void time() {
		
	}
	public boolean tileCollision(int x,int y,int size,int xOffset,int yOffset){
		boolean solid = false;
		//int xt,yt;
		for(int c = 0; c < 4; c++){
			int xt = (x - c % 2 * size + xOffset) >> 4; //change the multiplication part and subtraction to your own advantage
			int yt = (y - c / 2 * size + yOffset) >> 4;
			if(getTile(xt,yt).solid()) solid = true;
		}
		return solid;
	}
	
	public void render(int xScroll, int yScroll, Screen screen) {
		
		screen.setOffset(xScroll,yScroll);
		
		int x0= xScroll >> 4;
		int x1= (xScroll + screen.width + 16) >> 4;
		int y0= yScroll >> 4;
		int y1= (yScroll + screen.height + 16) >> 4;
		
		for(int y = y0; y < y1 ; y++) {
			for(int x = x0; x < x1; x++) {
				getTile(x,y).render(x, y, screen);
			}	
		}
		for(int i = 0; i < entities.size(); i ++){
			entities.get(i).render(screen);
		}
		for(int i = 0; i < projectiles.size(); i ++){
			projectiles.get(i).render(screen);
		}
		for(int i = 0; i < particles.size(); i ++){
			particles.get(i).render(screen);
		}
	}
	//Grass = 0xFFFF00
	//Flower = 0xFFFFFF00
	//rock = 0xFF7F7F00
	public Tile getTile(int x, int y) {
		if(x<0 || x>=width || y<0 || y>=height){
			
			return Tile.voidTile;
		}
		if(tiles[x+y*width]== Tile.col_spawn_grass) return Tile.grass;
		if(tiles[x+y*width] == Tile.col_spawn_wall1) return Tile.wall1;
		if(tiles[x+y*width] == Tile.col_spawn_wall2) return Tile.wall2;
		if(tiles[x+y*width] == Tile.col_spawn_floor) return Tile.floor;
		return Tile.voidTile;
	}
	
	public void add(Entity e){
		e.init(this);
		if( e instanceof Particle){
			particles.add((Particle)e);
		}
		else if( e instanceof Projectile){
			projectiles.add((Projectile) e);
		}
		else
			entities.add(e);
	}
	private void remove(){
		for(int i = 0 ; i < entities.size(); i++)
			if(entities.get(i).isRemoved())	entities.remove(i);
		for(int i = 0; i < projectiles.size(); i ++){
			if(projectiles.get(i).isRemoved())	projectiles.remove(i);
		}
		for(int i = 0; i < particles.size(); i ++){
			if(particles.get(i).isRemoved())	particles.remove(i);
		}
	}
}
