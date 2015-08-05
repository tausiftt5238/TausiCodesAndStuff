package gametute2.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

	private boolean[] keys = new boolean[1000];
	public boolean up,down,left,right;
	
	public void update() {
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		if(up||down||left||right)
			System.out.println("Pressed");
	}
	
	public void keyPressed(KeyEvent ke) {
		keys[ke.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent ke) {
		keys[ke.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent ke) {
		
	}

}
