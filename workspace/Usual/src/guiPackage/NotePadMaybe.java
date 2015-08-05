package guiPackage;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class WritingFrame extends JFrame
{
	
	private JTextArea area1;
	private JButton button;
	private String stringForArea1;
	private JPanel toHoldTheJButton;
	public WritingFrame()
	{
		super("This might be a notepad someday");
		//setLayout(null);
		Box box = Box.createVerticalBox();
		toHoldTheJButton = new JPanel();
		stringForArea1 = "This is a demo string, change it and see what happens";
		area1 = new JTextArea(10,15);
		area1.setText(stringForArea1);
		//area1.setLocation(0,0);
		box.add(area1,BorderLayout.CENTER);
		
		button = new JButton("Click to Show");
		button.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						System.out.println(area1.getText());
					}
				}
		);
		toHoldTheJButton.add(button);
		box.add(toHoldTheJButton,BorderLayout.SOUTH);
		
		add(box);
	}
}

class TestTextFrame extends JFrame
{
	private JTextArea textArea;
	public TestTextFrame()
	{
		textArea = new JTextArea(10,15);
		textArea.setText("this is a triumph");
		add(textArea);
		System.out.println(textArea.getText().charAt(textArea.getText().length() - 1));
		textArea.addKeyListener(
			new KeyListener()
			{

				@Override
				public void keyPressed(KeyEvent event) {
					//System.out.printf("%c",event.getKeyChar());
					
				}

				@Override
				public void keyReleased(KeyEvent event) {
					//System.out.println(textArea.getText().charAt(textArea.getText().length() - 1));
					
				}

				@Override
				public void keyTyped(KeyEvent event) {
					System.out.printf("%c",event.getKeyChar());
					
				}
				
			}
		);
		
	}
	public void ifPressedEnter()
	{
		JOptionPane.showMessageDialog(null, "You hit a new line");
	}
}

public class NotePadMaybe
{
	public static void main(String args[])
	{
		TestTextFrame x = new TestTextFrame();
		x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		x.setSize(500,400);
		x.setVisible(true);
	}
}