package org.sunbeam.dmc.test;
public class Program 
{
	public static void main(String[] args) 
	{
		//Object obj;	//obj --> reference
		
		//new Object( );	//Anonynous instance
		
		//Object obj = new Object();	//Instantiation
		
		Object obj = new Object() 	//Program$1.class
		{
			@Override
			public String toString() 
			{
				return "Inside anonymous inner class";
			}
		};
		System.out.println(obj.toString());
	}
}
