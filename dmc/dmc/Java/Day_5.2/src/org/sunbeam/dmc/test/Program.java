package org.sunbeam.dmc.test;

import java.util.Arrays;

public class Program 
{
	public static void main1(String[] args) 
	{
		//int arr[][];	//Ok
		//int[] arr[];	//Ok
		//int[][] arr;	//Ok
		int[][] arr = new int[ 2 ][ 3 ];
	}
	public static void main2(String[] args) 
	{
		int[][] arr = new int[  ][ ]
		{ 
			{10,20,30},
			{40,50,60}
		};
				
		for( int row = 0; row < 2; ++ row )
		{
			for( int col = 0; col < 3; ++ col )
				System.out.print(arr[ row ][ col ]+"	");
			System.out.println();
		}	
	}
	public static void main3(String[] args) 
	{
		int[][] arr =
		{ 
			{10,20,30},
			{40,50,60}
		};
				
		for( int row = 0; row < arr.length; ++ row )
		{
			for( int col = 0; col < arr[ row ].length; ++ col )
				System.out.print(arr[ row ][ col ]+"	");
			System.out.println();
		}	
	}
	public static void main4(String[] args) 
	{
		int[][] arr = new int[  ][ ]
		{ 
			{10,20,30},
			{40,50,60}
		};
		
		for(int[] i : arr )
		{
			for( int j : i )
				System.out.print(j+"	");
			System.out.println();
		}
	}
	public static void main(String[] args) 
	{
		int[][] arr = new int[  ][ ]
		{ 
			{10,20,30},
			{40,50,60}
		};
		
		for( int index = 0; index < arr.length; ++ index )
			System.out.println(Arrays.toString(arr[ index ]));
	}
}
