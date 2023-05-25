package org.sunbeam.dmc.test;

import java.util.Arrays;

public class Program 
{
	public static void main1(String[] args) 
	{
		int[][] arr = new int[ 3 ][  ];
		arr[ 0 ] = new int[ 3 ];
		arr[ 1 ] = new int[ 2 ];
		arr[ 2 ] = new int[ 4 ];
		
		for( int row = 0; row < arr.length; ++ row )
		{
			for( int col = 0; col < arr[ row ].length; ++ col )
				System.out.print(arr[ row ][ col ]+"	");
			System.out.println();
		}
	}
	public static void main2(String[] args) 
	{	
		int[][] arr = new int[ 3 ][  ];
		arr[ 0 ] = new int[  ] { 10,20,30};
		arr[ 1 ] = new int[  ] { 40, 50};
		arr[ 2 ] = new int[  ] { 60, 70, 80, 90 };
		
		for( int[] i : arr )
		{
			for( int  j : i )
				System.out.print(j+"	");
			System.out.println();
		}
	}
	public static void main(String[] args) 
	{
		int[][] arr = { {10,20,30}, {30,40}, {50,60,70 } }; 
		for( int row = 0; row < arr.length; ++ row )
		{
			for( int col = 0; col < arr[ row ].length; ++ col )
				System.out.print(arr[ row ][ col ]+"	");
			System.out.println();
		}
	}
}
