class complexNumber
{
	private double realPart;
	private double imaginaryPart;
	complexNumber(double a,char operand, double b)
	{
		realPart = a;
		if(operand == '-')
			imaginaryPart = -b;
		else 
			imaginaryPart = b;
	}
	public double getRealPart()
	{
		return realPart;
	}
	public double getImaginaryPart()
	{
		return imaginaryPart;
	}
}
class sumComplexNumber
{
	private complexNumber a;
	private complexNumber b;
	sumComplexNumber(complexNumber x, complexNumber y)
	{
		a = x;
		b = y;
	}
	public String getSumComplexNumber()
	{
		String output;
		output = String.format("%f %fi", a.getRealPart()+ b.getRealPart(), a.getImaginaryPart() + b.getImaginaryPart());
		return output;
	}
}
public class complexNumberSummation 
{
	public static void main(String args[])
	{
		complexNumber a = new complexNumber (4, '-' , 6);
		complexNumber b = new complexNumber (3, '+' , 2);
		sumComplexNumber x = new sumComplexNumber(a,b);
		System.out.println(x.getSumComplexNumber());
	}
}
