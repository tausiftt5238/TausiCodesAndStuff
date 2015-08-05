
class RectangleClass 
{
	private double length;
	private double width;
	public RectangleClass()
	{
		length = 1;
		width = 1;
	}
	public void setParameter(double l, double w)
	{
		if((l >= 0.0 && l <= 20.0 )&&(w>= 0.0 && l <= 20.0))
		{
			length = l;
			width = w;
		}
		else
		{
			throw new IllegalArgumentException("either the length or the width is out of range");
		}
	}
	public double getLength()
	{
		return length;
	}	
	public double getWidth()
	{
		return width;
	}
	public double perimeter()
	{
		return 2*(length + width);
	}
	public double area()
	{
		return length * width;
	}
}

public class Rectangle
{
	public static void main(String args[])
	{
		RectangleClass x = new RectangleClass();
		try
		{
			x.setParameter(9.2, 10);
			System.out.printf("perimeter is %f, area is %f\n",x.perimeter(),x.area());
		}
		catch(IllegalArgumentException e)
		{
			System.out.printf("%s",e);
		}
		try
		{
			x.setParameter(-1, 10);
			System.out.printf("perimeter is %f, area is %f\n",x.perimeter(),x.area());
		}
		catch(IllegalArgumentException e)
		{
			System.out.printf("%s",e);
		}
	}
}
