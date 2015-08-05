import java.io.File;

import javax.swing.JFileChooser;


public class FileTest {
	public static void main(String args[]){
		WhereJobIsDone w = new WhereJobIsDone();
	}
		
}

class WhereJobIsDone{
	JFileChooser jf = new JFileChooser();
	File file;
	String itemList[];
	public WhereJobIsDone(){
		jf.showOpenDialog(null);
		file = jf.getSelectedFile().getParentFile();
		//System.out.println(path);
		itemList = file.list();
		for(String x: itemList){
			System.out.println(x);
		}
	}
}