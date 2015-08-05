package guiPackage;
import javax.swing.*;
import java.awt.*;

class TestPanel extends JPanel
{
	public void DrawingComponent(Graphics g)
	{
		g.drawRect(50, 50, 100, 100);
	}
}

class TestFrame extends JFrame
{
	private JPanel mainPanel;
	private TestPanel subPanel;
	public TestFrame()
	{
		mainPanel = new JPanel();
		subPanel = new TestPanel();
		mainPanel.setBackground(Color.BLUE);
		//subPanel.setBackground(Color.RED);
		mainPanel.add(subPanel);
		add(mainPanel,BorderLayout.CENTER);
	}
}

public class PanelXPanel 
{
	public static void main(String args[])
	{
		TestFrame x = new TestFrame();
		x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		x.setVisible(true);
		x.setSize(500, 500);
	}
}
