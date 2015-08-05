package bouncingBall;
import java.awt.Graphics;
import javax.swing.JPanel;


public class DrawBall extends JPanel implements Runnable 
{
	private int x,y;
	Thread t;
	DrawBall(int a, int b)
	{
		x = a;
		y = b;
		t = new Thread(this);
		t.start();
	}
	
	public void run()
	{
		try
		{
			for(int i= 0 ;i < 100 ; i++)
			{
				y += i*10;
				Thread.sleep(1000);
			}
		}
		catch(Exception e)
		{
			System.out.println("System was interrupted");
		}
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawOval(x,y,30,30);
	}
	public void Change( int b)
	{
		y += b;
	}
}
