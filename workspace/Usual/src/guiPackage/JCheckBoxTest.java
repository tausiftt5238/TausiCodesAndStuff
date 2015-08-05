package guiPackage;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class JCheckBoxTestClass extends JFrame
{
	private JCheckBox TestingBox;
	private TextField text;
	public JCheckBoxTestClass()
	{
		super("THIS IS A MOTHAFUCKING TEST");
		setLayout(new FlowLayout());
		TestingBox = new JCheckBox("this will be a test");
		add(TestingBox);
		
		JBox handler = new JBox();
		TestingBox.addItemListener(handler);
		
	}
	private class JBox implements ItemListener
	{

		@Override
		public void itemStateChanged(ItemEvent event) 
		{
			// TODO Auto-generated method stub
			if(TestingBox.isSelected())
			{
				System.out.printf("this was selected");
			}
			else
			{
				System.out.printf("this wasn't selected");
			}
		}
		
	}
}

public class JCheckBoxTest 
{
	public static void main(String args[])
	{
		JCheckBoxTestClass a = new JCheckBoxTestClass();
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.setSize(500, 500);
		a.setVisible(true);
	}

}
