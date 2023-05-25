package org.sunbeam.dmc.test;
public class Program 
{
	public static void sum( int... args )
	{
		int result = 0;
		for( int element : args )
			result= result + element;
		System.out.println("Result	:	"+result);	
	}
	public static void main(String[] args) 
	{
		sum( );
		sum( 10, 20 );
		sum( 10, 20, 30 );
		sum( 10, 20,30, 40 );
		sum( 10, 20, 30, 40, 50  );
	}
}
