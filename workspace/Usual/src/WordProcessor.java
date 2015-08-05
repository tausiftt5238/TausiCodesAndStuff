import java.util.Scanner;

class Data{
	public String text[] = new String[1000];
	public int counter = 0;
	public boolean inputTaken = true;
	synchronized void setText(String str){
		while(!inputTaken)
			try{
				wait();
			}catch(Exception e){
				System.out.println(e);
			}
			text[counter++] = str;
			inputTaken = false;
			notify();
	}
	
	synchronized String getText(){
		while(inputTaken)
			try{
				wait();
			}catch(Exception e){
				System.out.println(e);
			}
			inputTaken = true;
			notify();
			return text[counter-1];
	}

}


class Input implements Runnable{
	Data obj;
	Thread t;
	String input;
	boolean run;
	Scanner s = new Scanner(System.in);
	Input(Data p){
		obj = p;
		run = true;
		t = new Thread(this,"input");
		t.start();
	}
	@Override
	public void run(){
		while(run){
			input = s.next();
			obj.setText(input);
			if(input.charAt(input.length()-1) == '#'){
				run = false;
				break;
			}
			
			//notify();		
		}
	}
}

class CountVowels implements Runnable{
	Data obj;
	Thread t;
	int vowels = 0;
	String s;
	boolean hasInput = false;
	CountVowels(Data p){
		obj = p;
		t = new Thread(this,"vowels");
		t.start();
	}
	@Override
	public void run(){
		/*try{
			wait();
		}catch(Exception e){
			System.out.println(e);
		}*/
		while(true){
			s = obj.getText();
			hasInput = true;
			if(s.charAt(s.length() -1 ) == '#') break;
			for(int i = 0; i < s.length(); i++){
				if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'||
					s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U')
					vowels++;
			}
		}
	}
	synchronized String getText(){
		while(!hasInput){
			try{
				wait();
			}catch(Exception e){
				System.out.println(e);
			}
		}
		hasInput = false;
		notify();
		return s;
	}
}



class CountCharFreq implements Runnable{
	Data obj;
	Thread t;
	CountVowels CV;
	String s;
	int letters[] = new int[26];
	CountCharFreq(Data p,CountVowels CV){
		this.CV = CV;
		obj = p;
		t = new Thread(this,"letters");
		t.start();
	}
	@Override
	public void run(){
		while(true){
			s = CV.getText();
			System.out.println(s);
			if(s.charAt(s.length() -1 ) == '#') break;
			for(int i = 0 ; i < s.length(); i++){
				if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
					letters[(int)s.charAt(i) - (int)'a']++;
				else if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
					letters[(int)s.charAt(i) - (int)'A']++;
			}
		}
	}
}

public class WordProcessor{
	public static void main(String args[]){
		Data dataObj = new Data();
		Input input = new Input(dataObj);
		CountVowels countVowel = new CountVowels(dataObj);
		CountCharFreq countChar = new CountCharFreq(dataObj,countVowel);
		try{
			input.t.join();
			countVowel.t.join();
			countChar.t.join();
		}catch(Exception e){
			System.out.println("Interrupted");
		}
		//System.out.println(dataObj.text[dataObj.counter-1]);
		System.out.println(countVowel.vowels);
		for(int i = 0; i < 26; i++){
			if(countChar.letters[i] > 0){
				System.out.printf("%c %d\n",('a'+(char)i),countChar.letters[i]);
			}
		}
	}
}