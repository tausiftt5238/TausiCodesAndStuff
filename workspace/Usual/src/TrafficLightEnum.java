enum TrafficLight
{
	RED("red","1hr"),
	YELLOW("yellow","5secs"),
	GREEN("green","0.5hr");
	
	private String color;
	private String duration;
	TrafficLight(String a, String b)
	{
		color = a;
		duration = b;
	}
	public String getColor()
	{
		return color;
	}
	public String getDuration()
	{
		return duration;
	}
}
public class TrafficLightEnum 
{
	public static void main(String args[])
	{
		for(TrafficLight x : TrafficLight.values())
			System.out.printf("%s %s\n",x.getColor(),x.getDuration());
	}	
}
