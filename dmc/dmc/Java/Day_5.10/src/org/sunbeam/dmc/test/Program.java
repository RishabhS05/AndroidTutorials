package org.sunbeam.dmc.test;

enum Color
{
	RED,GREEN,BLUE
}
public class Program 
{
	public static void main1(String[] args) 
	{
		Color color = Color.RED;
		System.out.println(color.name()+"	"+color.ordinal());
		
		color = Color.GREEN;
		System.out.println(color.name()+"	"+color.ordinal());
		
		color = Color.BLUE;
		System.out.println(color.name()+"	"+color.ordinal());
	}
	
	public static void main2(String[] args) 
	{
		Color[] colors = Color.values();
		for (Color color : colors) 
		{
			System.out.println(color.name()+"	"+color.ordinal());
		}
	}
	public static void main(String[] args) 
	{
		//String str = "GREEN";
		
		String str = "green";
		Color color = Color.valueOf(str);	//IllegalArgumentException
		System.out.println(color.name()+"	"+color.ordinal());
	}
}
