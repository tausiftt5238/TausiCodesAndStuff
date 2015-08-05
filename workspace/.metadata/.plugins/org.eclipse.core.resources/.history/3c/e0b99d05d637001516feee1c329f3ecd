package gametute2.graphics;

public class AnimatedSprite extends Sprite {

	private int frame;
	private Sprite sprite;
	private int rate = 5;
	private int time = 0;
	//private int animationSize = 0;
	private int length = -1;
	
	
	public AnimatedSprite(SpriteSheet sheet,int width,int height,int length){
		super(sheet,height,width);
		frame = 0;
		this.length = length;
		if(length > sheet.getSprite().length) System.err.println("Error! AnimatedSprite length out of bound.");
		sprite = sheet.getSprite()[0];
	}

	public void update(){
		time++;
		if(time % rate == 0){
			if(frame >= length - 1) frame = 0;
			else frame++;
			sprite = sheet.getSprite()[frame];
		}
		System.out.println(sprite + ",:" + frame);
	}
	public Sprite getSprite(){
		return sprite;
	}
	public void setFrameRate(int frames){
		rate = frames;
	}
}
