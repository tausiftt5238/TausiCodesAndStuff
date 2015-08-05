package gametute;
import gametute.graphics.Screen;
import gametute.input.Keyboard;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
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
	
	public boolean running = false;
	public int tickCount = 0;
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	public Game(){
		setMinimumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		setMaximumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		
		screen = new Screen(WIDTH,HEIGHT);
		frame = new JFrame(NAME);
		key = new Keyboard();
		
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
		
		while(running) {
			long now = System.nanoTime();
			delta += (now-lastTime) / ns;
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
		
		screen.clear();
		screen.render(xOffset,yOffset);
		
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