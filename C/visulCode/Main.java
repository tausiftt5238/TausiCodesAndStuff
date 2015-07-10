public class Main{
	public static void main(String args[]){
		Interesting s = new Interesting();
		Interesting t = new Interesting();
		s.increment();
		t.increment();
		t.increment();
		
		s.printing();
		t.printing();
		
	}
}
class Interesting{
	private int a = 10;
	private static int b = 10;
	public void increment(){
		a++;
		b++;
	}
	public void printing(){
		System.out.println(a+ ' ' + b);
	}
}