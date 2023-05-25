package org.sunbeam.dmc.test;

class Outer //Outer.class
{
	public static class Inner	//Outer$Inner.class	
	{
		
	}
}
public class Program 
{
	public static void main(String[] args) 
	{
		Outer out = new Outer();
		
		Outer.Inner in = new Outer.Inner();
	}
}
