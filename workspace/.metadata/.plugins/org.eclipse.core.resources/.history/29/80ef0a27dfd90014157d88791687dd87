package guiPackage;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class TextTestFrame extends JFrame
{
	private JTextField textField1;
	public TextTestFrame()
	{
		super("This is the title");
		setLayout(new FlowLayout());
		
		textField1 = new JTextField(10);
		add(textField1);
		TextFieldHandler handler = new TextFieldHandler();
		textField1.addActionListener(handler);
	}
	private class TextFieldHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String output = event.getActionCommand();
			JOptionPane.showMessageDialog(null, output);
		}
	}
	
}

public class GuiTest {

	public static void main(String args[])
	{
		TextTestFrame x = new TextTestFrame();
		x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		x.setSize(100, 100);
		x.setVisible(true);
	}
}
