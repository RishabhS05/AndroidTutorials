package org.sunbeam.dmc.test;

public class Program 
{
	public static int getHashCode( int data )
	{
		int result = 1;
		final int prime = 31;
		result = result * data + prime * data;
		return result;
	}
	public static void main(String[] args) 
	{
		for( int count = 1; count <= 100; ++ count )
		{
			int data = count;
			int hashcode = Program.getHashCode(data );
			int slot = hashcode % 5;
			System.out.println(data+"	"+hashcode+"	"+slot);
		}
	}
}
