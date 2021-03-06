class IntegerSet
{
	private boolean integers[] = new boolean[101];
	public IntegerSet()
	{
		for(int i = 0; i < 101 ; i++) integers[i] = false;
	}
	public void insertElement(int k)
	{
		integers[k] = true;
	}
	public boolean getElement(int k)
	{
		return integers[k];
	}
	public void deleteElement(int k)
	{
		integers[k] = false;
	}
	static boolean[] union(IntegerSet a, IntegerSet b)
	{
		boolean x[] = new boolean[101];
		for(int i = 0; i< 101; i++) x[i] = a.getElement(i) | b.getElement(i);
		return x;
	}
	static boolean[] intersection(IntegerSet a, IntegerSet b)
	{
		boolean x[] = new boolean[101];
		for(int i = 0; i< 101; i++) x[i] = a.getElement(i) & b.getElement(i);
		return x;
	}
	public String toString()
	{
		String outputString = "";
		for(int i = 0; i< 101; i++)
		{
			if(integers[i] == true)
			{
				outputString += String.format("%d ",i);
			}
		}
		return outputString;
	}
}
public class IntegerSetTest 
{
	public static void main(String args[])
	{
		IntegerSet x = new IntegerSet();
		x.insertElement(5);
		x.insertElement(10);
		x.insertElement(15);
		System.out.printf("%s",x.toString());
		System.out.println();
		IntegerSet y = new IntegerSet();
		y.insertElement(10);
		y.insertElement(20);
		y.insertElement(3);
		boolean[] a = IntegerSet.union(x,y);
		for(int i = 0; i<101; i++) 
		{
			if(a[i] == true)
				System.out.printf("%d ",i);
		}
		
	}
}
