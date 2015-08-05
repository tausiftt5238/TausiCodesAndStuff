package gametute2;
import gametute2.graphics.Screen;
import gametute2.input.Keyboard;
import gametute2.level.Level;
import gametute2.level.RandomLevel;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{


	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 300;
	public static final int HEIGHT = WIDTH / 16 * 9;
	public static final int SCALE = 3;
	public static final String NAME = "Game";
	public int xOffset=0,yOffset=0;
	
	private Thread thread;
	
	private JFrame frame;
	private Screen screen;
	private Keyboard key;
	private Level level;
	
	public boolean running = false;
	public int tickCount = 0;
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	public Game(){
		
		screen = new Screen(WIDTH,HEIGHT);
		frame = new JFrame(NAME);
		key = new Keyboard();
		level = new RandomLevel(64,64);
		
		setMinimumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		setMaximumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		
		frame.addKeyListener(key);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		frame.add(this, BorderLayout.CENTER);
		frame.pack();
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public synchronized void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
    public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {	
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames= 0;
		int ticks= 0;
		frame.requestFocus();
		
		while(running) {
			long now = System.nanoTime();
			delta += (now-lastTime) / ns; //means the value of delta will be 1 or higher 60 times a second
			lastTime=now;
			while(delta>=1) {
				tick();
				ticks++;
				delta--;
			}
			render();
			frames++;
			if(System.currentTimeMillis()-timer>1000) { //adds a second to the timer so that the checking difference doesn't get bigger
				timer += 1000;
				//System.out.println(ticks + "ticks, " + frames + "frames");
				frame.setTitle(NAME + " | " + ticks + "ticks, " + frames + "frames");
				ticks=0;
				frames=0;
			}
		}
		
		
		
	}
	
	public void tick(){
		/*tickCount++;
		
		for (int i = 0; i < pixels.length; i++){
			pixels[i] = i + tickCount;
		}*/
		key.update();
		if(key.up)
			yOffset--;
		if(key.down)
			yOffset++;
		if(key.left)
			xOffset--;
		if(key.right)
			xOffset++;
	}
	
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if (bs == null){
			createBufferStrategy(3);
			return;
		}
		
		screen.clear(); //Clearing screen before starting to render
		level.render(xOffset, yOffset, screen);
		
		/*
		 * Here is where it gets confusing, so might as well write it down.
		 * The calling hierarchy works as follows:
		 * we've generated a map in the level constructor in the tiles array that 
		 * holds the type of tile for a specific part of the level
		 * level.render creates corner pins, gets the tile starting from the corner
		 * via the getTile method giving it an (x,y) and then renders the tile that should be there (tile.render())
		 * this method keeps getting called in a loop for each tile that is to be shown
		 * the method calls the renderTile() method of the Screen class which renders the tile in its absolute position
		 * taking into account the Offset and all that shit. this is copied into Screen.pixels[]
		 * which is then moved to Game.pixels[], the representative array of the BufferedImage.  
		 */
		
		for(int i=0; i<pixels.length; i++) {
			pixels[i]= screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		
		//g.setColor(Color.black);
		//g.fillRect(0, 0, getWidth(), getHeight());
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args){ 
		new Game().start();
	}

}