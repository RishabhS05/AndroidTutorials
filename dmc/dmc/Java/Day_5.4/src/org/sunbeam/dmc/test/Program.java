package org.sunbeam.dmc.test;
class Complex
{
	private int real;
	private int imag;
	public Complex(  )
	{	}
	public Complex( int real, int imag )
	{
		this.real = real;
		this.imag = imag;
	}
	public void printRecord( )
	{
		System.out.println(this.real+"	"+this.imag);
	}
}
public class Program 
{
	public static void main(String[] args) 
	{
		Complex[] arr = new Complex[ 3 ];
		for( int index = 0; index < arr.length; ++ index )
			arr[ index ] = new Complex();
		
		for( int index = 0; index < arr.length; ++ index )
			arr[ index ].printRecord();
	}
}
