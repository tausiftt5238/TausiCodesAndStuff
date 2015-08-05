
import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.*;

class FormFrame extends JFrame{
	JTextArea area;
	JButton button;
	String output;
	public FormFrame(){
		setLayout(new FlowLayout());
		area = new JTextArea(10,10);
		button = new JButton("submit");
		add(area);
		add(button);
		SubmitHandler handler = new SubmitHandler();
		button.addActionListener(handler);
	}
	private class SubmitHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			output = area.getText();
			JOptionPane.showMessageDialog(null, output);
		}
	}
}

public class FormFillUpMainClass {
	
	public static void main(String args[]){
		FormFrame x = new FormFrame();
		x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		x.setVisible(true);
		x.setSize(500,500);
	}
}

