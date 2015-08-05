package guiPackage;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

class TextAndBoxFrame extends JFrame
{
	private JTextField text;
	private JCheckBox box;
	private String stringForBox;
	public TextAndBoxFrame()
	{
		super ("Text and box Test");
		setLayout(new FlowLayout());
		stringForBox = "Box is unchecked";
		text = new JTextField(stringForBox,50);
		box = new JCheckBox("click to change");
		add(text);
		add(box);
		HandlingBox handler = new HandlingBox();
		box.addItemListener(handler);
	}
	private class HandlingBox implements ItemListener
	{

		@Override
		public void itemStateChanged(ItemEvent event) {
			// TODO Auto-generated method stub
			if(box.isSelected())
			{
				stringForBox = "is checked";
				
			}
			else
			{
				stringForBox = "Box is unchecked again";
			}
			text.setText(stringForBox);
		}
		
	}
}

public class TextAndBox 
{
	public static void main(String args[])
	{
		TextAndBoxFrame a = new TextAndBoxFrame();
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.setSize(500, 500);
		a.setVisible(true);
	}
}
