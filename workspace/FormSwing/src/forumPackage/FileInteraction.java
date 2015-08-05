package forumPackage;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class FileInteraction {
	private String Name,Roll,Address,Gender,Hobby,path;
	private BufferedImage img;
	private String pathImage;
	public FileInteraction(){
		Name = Roll = Address = Gender = Hobby = path = null;
	}
	public void Save(String Name,String Roll,String Address,String Gender,String Hobby,String path,BufferedImage img){
		this.Name = Name;
		this.Address = Address;
		this.Roll = Roll;
		this.Gender = Gender;
		this.Hobby = Hobby;
		this.path = path;
		this.img = img;
		pathImage = path + Roll + ".png";
		FileWriter fout = null;
		File outImage;
		try {
			fout = new FileWriter(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try{
			fout.write(String.format("%s\n%s\n%s\n%s\n%s\n%s\n",Name,Roll,Address,Gender,Hobby,pathImage));
			fout.close();
		}catch (Exception e){
			System.out.println(e);
		}
		
		try{
			outImage = new File(pathImage);
			ImageIO.write(img, "png", outImage);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	public void Load(File FormFile){
		Scanner fileRead = null;
		try{
			fileRead = new Scanner(FormFile);
		}catch(Exception e){
			System.out.println(e);
		}
		this.Name = fileRead.nextLine();
		this.Roll = fileRead.nextLine();
		this.Address = fileRead.nextLine();
		this.Gender = fileRead.nextLine();
		this.Hobby = fileRead.nextLine();
		path = fileRead.nextLine();
	}
	public String getName(){
		return Name;
	}
	public String getRoll(){
		return Roll;
	}
	public String getAddress(){
		return Address;
	}
	public int getHobby(){
		return Integer.parseInt(Hobby);
	}
	public ImageIcon getImage() throws IOException{
		
		img = null;
		try{
			img = ImageIO.read(new File(path));
		}catch(IOException e){
			System.out.println(e);
		}
		Image imgIcon = img.getScaledInstance(100,50,Image.SCALE_DEFAULT);
		ImageIcon icon = new ImageIcon(imgIcon);
		return icon;
	}
	public String toString(){
		String output =  String.format("%s %s %s %s %s\n",Name,Roll,Address,Gender,Hobby);
		return output;
	}
	public void print(){
		System.out.println(this);
	}
}
