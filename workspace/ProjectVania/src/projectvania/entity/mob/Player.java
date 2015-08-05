package projectvania.entity.mob;

import projectvania.graphics.AnimatedSprite;
import projectvania.graphics.Screen;
import projectvania.graphics.Sprite;
import projectvania.graphics.SpriteSheet;
import projectvania.input.Keyboard;

public class Player extends Mob {
	
	private Keyboard input;
	private Sprite sprite;
	private int anim = 0;
	//private int jumpLimit = 10;
	//private int jumpLimitReach = 120;
	private int jumpingRange = 15;
	private AnimatedSprite player_walking = new AnimatedSprite(SpriteSheet.player_walking,16,32,4);
	private AnimatedSprite player_jumping = new AnimatedSprite(SpriteSheet.player_jumping,16,32,1);
	private AnimatedSprite animSprite = null;
	
	public Player(int x,int y,Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.Player_def;
		animSprite = player_walking;
	}
	
	public void update() {
		if(jumping >0) jumping--;
		
		if(walking) animSprite.update();
		else animSprite.setFrame(0);
		
		int xa=0,ya=0;
		if(input.left) {
			animSprite = player_walking;
			xa--;
		}
		else if(input.right) {
			animSprite = player_walking;
			xa++;
		}
		if(input.up && jumping==0 && !falling){
			animSprite = player_jumping;
			//ya--;
			jumping = jumpingRange;
		}
		if(xa!=0 || ya!=0) {
			move(xa,ya);
			move(xa,ya);
			walking = true;
		}
		else walking = false;
		if(jumping==0) {
			move(0,1);
			move(0,1);
		}
		else if(jumping > 0) {
			move(0,-1);
			move(0,-1);
		}
	}
	
	public void render(Screen screen) {
		int flip = 0;
		sprite = Sprite.Player_def;
		if(dir == Direction.RIGHT) {
			flip = 0;
		}
		if(dir == Direction.LEFT) {
			flip = 1;
		}
		sprite = animSprite.getSprite();
		if(falling) {
			sprite = Sprite.Player_air;
		}
		if(jumping>0) {
			sprite = Sprite.Player_jump_up;
		}
		screen.renderSprite(x-16,y-16,sprite,true,flip);
	}
}