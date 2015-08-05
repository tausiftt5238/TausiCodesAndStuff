package guiPackage;
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

class JComboBoxFrame extends JFrame
{
	private JComboBox LinkCombo;
	private JLabel label;
	private static final String[] names = {"link1.png","link2.jpg","link3.jpg","link4.jpg"};
	private Icon[] icon = { new ImageIcon( getClass().getResource( names[0])),
			new ImageIcon( getClass().getResource( names[1])),
			new ImageIcon( getClass().getResource( names[2])),
			new ImageIcon( getClass().getResource( names[3]))};
	public JComboBoxFrame()
	{
		super("selection of link's pics");
		setLayout(new FlowLayout());
		
		LinkCombo = new JComboBox(names);
		LinkCombo.setMaximumRowCount(2);
		LinkCombo.addItemListener(
				new ItemListener()
				{

					@Override
					public void itemStateChanged(ItemEvent event) {
						// TODO Auto-generated method stub
						if(event.getStateChange() == ItemEvent.SELECTED)
						{
							label.setIcon(icon[LinkCombo.getSelectedIndex()]);
						}
						
					}
					
				});
		add(LinkCombo);
		label = new JLabel(icon[0]);
		add(label);
	}
}

public class JComboTest {
	public static void main(String args[])
	{
		JComboBoxFrame a = new JComboBoxFrame();
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.setSize(500, 500);
		a.setVisible(true);
	}

}
