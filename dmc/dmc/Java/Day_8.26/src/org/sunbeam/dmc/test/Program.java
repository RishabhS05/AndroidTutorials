package org.sunbeam.dmc.test;

import java.time.Period;

@FunctionalInterface
interface Math
{
	int pow( int base, int index );
}
public class Program 
{
	public static void main(String[] args) 
	{
		Math m = ( base, index )->
		{
			int result = 1;
			for( int count = 1; count <= index; ++ count )
				result = result * base;
			return result;
		};
		int result = m.pow(2, 3);
		System.out.println("Result	:	"+result);
	}
}
