package org.sunbeam.dmc.test;

class Outer	//Top Level class --> Outer.class
{
	public class Inner	//Non static Nested class( Inner )	--> Outer$Inner.class
	{
		
	}
}
public class Program 
{
	public static void main(String[] args) 
	{
		Outer out = new Outer();
		
		//Outer.Inner in = out.new Inner();
		
		Outer.Inner in = new Outer().new Inner();
	}
}
