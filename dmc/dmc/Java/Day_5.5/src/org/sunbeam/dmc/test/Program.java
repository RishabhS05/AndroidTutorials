package org.sunbeam.dmc.test;
public class Program 
{
	public static void swap( int[] arr2 )
	{
		int temp = arr2[ 0 ];
		arr2[ 0 ] = arr2[ 1 ];
		arr2[ 1 ] = temp;
	}
	public static void main(String[] args) 
	{
		int num1 = 10, num2 = 20;
		int[] arr1 = new int[ ] { num1, num2 };
		Program.swap(arr1);
		num1 = arr1[ 0 ]; num2 = arr1[ 1 ];
		System.out.println("Num1	:	"+num1);
		System.out.println("Num2	:	"+num2);
	}
}
