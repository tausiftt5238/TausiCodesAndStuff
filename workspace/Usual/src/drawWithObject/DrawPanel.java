package drawWithObject;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.Random;

public class DrawPanel extends JPanel
{
	private MyRect[] Rectangles;
	public DrawPanel()
	{
		Random r = new Random();
		setBackground(Color.WHITE);
		Rectangles = new MyRect[10];
		for(int i = 0; i < 10 ; i++)
		{
			int x1 = r.nextInt(200);
			int y1 = r.nextInt(200);
			int x2 = r.nextInt(200);
			int y2 = r.nextInt(200);
			Color color = new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256));
			boolean filled = r.nextBoolean();
			
			Rectangles[i] = new MyRect(x1,y1,x2,y2,color,filled);
		}
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for( MyRect x : Rectangles)
			x.draw(g);
	}
}
