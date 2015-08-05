package drawWithObject;

import java.awt.Color;
import java.awt.Graphics;


public class MyRect 
{
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private Color RectColor;
	private boolean fill;
	public MyRect(int a1,int b1,int a2,int b2,Color color, boolean filled)
	{
		x1 = getX(a1,a2);
		x2 = getWidth(a1,a2);
		y1 = getY(b1,b2);
		y2 = getHeight(b1,b2);
		RectColor = color;
		fill = filled;
	}
	public void draw(Graphics g)
	{
		if(fill == true)
		{
			g.setColor(RectColor);
			g.fillRect(x1, y1, x2, y2);
		}
	}
	public int getWidth(int a1,int a2)
	{
		if(a1 > a2)
		{
			int temp = a1;
			a1 = a2;
			a2 = temp;
		}
		return Math.abs(a2 - a1);
	}
	public int getHeight(int b1,int b2)
	{
		if(b1 > b2)
		{
			int temp = b1;
			b1 = b2;
			b2 = temp;
		}
		return Math.abs(b1 - b2);
	}
	public int getX(int x1, int x2)
	{
		return x1 <= x2 ? x1 : x2;
	}
	public int getY(int y1, int y2)
	{
		return y1 <= y2 ? y1 : y2;
	}
}
