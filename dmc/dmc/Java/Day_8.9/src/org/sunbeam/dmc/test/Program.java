package org.sunbeam.dmc.test;
interface A
{
	default void f1( )
	{	}
}
interface B
{
	default void f1( )
	{	}
}
class C implements A, B
{
	@Override
	public void f1() 	//Mandatory to override
	{
		System.out.println("C.f1");
	}
}
public class Program 
{
	public static void main(String[] args) 
	{
		
	}
}
