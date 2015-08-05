import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;


public class FileChoose {
	public static void main(String args[]){
		FileChooseTest j = new FileChooseTest();
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setSize(500, 500);
		j.setVisible(true);
	}
}

class FileChooseTest extends JFrame{
	JFileChooser jf;
	JButton button;
	String path;
	BufferedImage image = null;
	public FileChooseTest(){
		setLayout(new FlowLayout());
		jf = new JFileChooser();
		button = new JButton();
		add(button);
		buttonHandling handler = new buttonHandling();
		button.addActionListener(handler);
	}
	private class buttonHandling implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			jf.showOpenDialog(null);
			path = jf.getSelectedFile().getPath();
			try{
				image = ImageIO.read(new File(path));
			}catch(IOException exception){
				System.out.println(exception);
			}
			Graphics g = getGraphics();
			g.drawImage(image,50,50,null);
		}
		
	}
}
