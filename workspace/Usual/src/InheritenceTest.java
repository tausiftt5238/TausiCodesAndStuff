class Inh
{
	public void method()
	{
		System.out.println("this doesn't do anything");
	}
}
public class InheritenceTest 
{
	public static void main(String args[])
	{
		Inh x = new Inh();
		Class y = x.getClass();
		System.out.println(y.getName());
	}
}
