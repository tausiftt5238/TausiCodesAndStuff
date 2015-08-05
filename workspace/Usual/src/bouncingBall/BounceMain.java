package bouncingBall;
import javax.swing.JFrame;

public class BounceMain 
{
	public static void main(String args[])
	{
		DrawBall x = new DrawBall(50,50);
		JFrame application = new JFrame();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize(500, 500);
		application.setVisible(true);
		try
		{
			for(int i = 0; i< 100 ; i++)
			{
				application.add(x);
				x.Change(10);
			}
		}
		catch(Exception e)
		{
			System.out.println("interrupted");
		}
	}
}
