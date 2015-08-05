import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class FileWritingTest {
	public static void main(String args[]) throws IOException{
		int a = 20;
		float b = 30;
		GenClass <Integer,Float> x = new GenClass(a,b);
		x.print();
	}
}
class ThreadTest extends Thread{
	ThreadTest(){
		start();
	}
	@Override
	public void run(){
		for(int i = 0 ; i < 5; i++){
			System.out.println(i);
		}
	}
}

class GenClass <T1,T2>{
	T1 dataType1;
	T2 dataType2;
	GenClass(T1 t1,T2 t2){
		dataType1 = t1;
		dataType2 = t2;
	}
	void print(){
		System.out.println(dataType1 + " " + dataType2);
	}
}