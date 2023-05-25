package org.sunbeam.dmc.test;

import java.util.Scanner;

interface Collection
{
	void accept( );
	
	static void swap( int[] arr )
	{
		int temp = arr[ 0 ];
		arr[ 0 ] = arr[ 1 ];
		arr[ 1 ] = temp;
	}
	default void sort( int[] arr )
	{
		for( int i = 0; i < arr.length - 1; ++ i )
		{
			for( int j = i + 1; j < arr.length; ++ j )
			{
				if( arr[ i ] > arr[ j ] )
				{
					int[] temp = { arr[ i ], arr[ j ] };
					Collection.swap(temp);
					arr[ i ] = temp[ 0 ];
					arr[ j ] = temp[ 1 ];
				}
			}
		}
	}
	void print( );
}
class Array implements Collection
{
	private int[] arr = new int[ 5 ];
	@Override
	public void accept() 
	{
		try( Scanner sc = new Scanner(System.in))
		{
			for( int index = 0; index < this.arr.length; ++ index  )
			{
				System.out.print("Enter element	:	");
				this.arr[ index ] = sc.nextInt();
			}
		}
	}
	@Override
	public void sort(int[] arr) 
	{
		for( int i = 0; i < arr.length - 1; ++ i )
		{
			for( int  j = 0; j < arr.length - 1 - i; ++ j )
			{
				if( arr[ j ] > arr[ j + 1 ] ) 
				{
					int[] temp = { arr[ j ], arr[ j + 1 ] };
					Collection.swap(temp);
					arr[ j ] = temp[ 0 ];
					arr[ j + 1 ] = temp[ 1 ];
				}
			}
		}
	}
	public int[] getArr() 
	{
		return arr;
	}
	@Override
	public void print() 
	{
		for( int index = 0; index < this.arr.length; ++ index  )
		{
			System.out.println( this.arr[ index ] );
		}
	}
}
public class Program 
{
	public static void main(String[] args) 
	{
		Collection c = new Array();
		c.accept();
		Array a1 = (Array) c;
		c.sort(a1.getArr());
		c.print();
	}
}
