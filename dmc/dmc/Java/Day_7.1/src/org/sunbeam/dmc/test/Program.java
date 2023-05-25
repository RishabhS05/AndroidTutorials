package org.sunbeam.dmc.test;

abstract class A
{
	public abstract void print();
}
class B extends A
{
	public void print( ) throws RuntimeException
	{
		try
		{
			for( int count = 1; count <= 10; ++ count )
			{
				System.out.println("Count	:	"+count);
				Thread.sleep(250);
			}
		}
		catch (InterruptedException cause) 
		{
			throw new RuntimeException( cause );	//Exception Chaining
		}
	}
}
public class Program 
{
	public static void main(String[] args) 
	{
		try
		{
			A a = new B();
			a.print();
		}
		catch( RuntimeException ex )
		{
			ex.printStackTrace();
			
			Throwable t =  ex.getCause();
			t.printStackTrace();
		}
	}
}
