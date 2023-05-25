package org.sunbeam.dmc.test;

public class Program 
{
	public static void main1(String[] args) 
	{
		Integer n1 = new Integer(125);
		Class<?> c = n1.getClass();
	}
	public static void main2(String[] args) 
	{
		Class<?> c =  Number.class;
	}
	public static void main(String[] args)throws Exception 
	{
		String className = "java.util.Scanner";
		Class<?> c =  Class.forName(className);
	}
}
