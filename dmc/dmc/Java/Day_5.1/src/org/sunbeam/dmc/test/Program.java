package org.sunbeam.dmc.test;

import java.util.Arrays;

public class Program 
{
	public static void main1(String[] args) 
	{
		//int arr[];
		//int[] arr;
		int[] arr = new int[ 3 ];
	}
	public static void main2(String[] args) 
	{
		//int[] arr = new int[ 3 ];
		//int[] arr = new int[  ] {10,20,30};
		int[] arr = {10,20,30};
		for( int index = 0; index < arr.length; ++ index )
			System.out.println(arr[ index ]);
	}
	public static void main3(String[] args) 
	{
		int[] arr = new int[  ] {10,20,30};
		//System.out.println(arr.toString());	//[I@7852e922
		System.out.println(Arrays.toString(arr));	//[10, 20, 30]
	}
	public static void main4(String[] args) 
	{
		int[] arr = new int[  ] {50,10,40,20,30};
		Arrays.sort(arr);
		for( int index = 0; index < arr.length; ++ index )
			System.out.println(arr[ index ]);
	}
	public static void main5(String[] args) 
	{
		int[] arr = new int[  ] {50,10,40,20,30};
		int key = 30;
		Arrays.sort(arr);
		int index = Arrays.binarySearch(arr, key);
		System.out.println("Index	:	"+index);
	}
	public static void main6(String[] args) 
	{
		//int[] arr = new int[ -3 ];//NegativeArraySizeException
		
		int[] arr = new int[  ] { 10, 20, 30, 40, 50 };
		//int element = arr[ -1 ];	//ArrayIndexOutOfBoundsException
		//int element = arr[ arr.length ];	//ArrayIndexOutOfBoundsException
		int element = arr[ arr.length - 1  ];	//OK
		System.out.println(element);
	}
	public static void main(String[] args) 
	{
		int[] arr = new int[  ] { 10, 20, 30, 40, 50 };
		for( int element : arr)
			System.out.println(element);
	}
}
