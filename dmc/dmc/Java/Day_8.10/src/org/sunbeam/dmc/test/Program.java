package org.sunbeam.dmc.test;

import java.util.Scanner;

public class Program 
{
	public static void acceptRecord( int[] number )
	{
		try( Scanner sc = new Scanner(System.in))
		{
			System.out.print("Enter number	:	");
			number[ 0 ] = sc.nextInt();
		}
	}
	public static void printRecord( int[] number )
	{
		System.out.println("Number	:	"+number[ 0 ]);
	}
	public static void main(String[] args) 
	{
		int[] number = new int[ 1 ];
		Program.acceptRecord( number );
		Program.printRecord( number );
	}
}
