package org.sunbeam.dmc.test;

import java.lang.reflect.Field;

class Complex
{
	private int real;
	private int imag;
	public Complex() 
	{
		this.real = 10;
		this.imag = 20;
	}
	@Override
	public String toString() 
	{
		return this.real+"	"+this.imag;
	}
}
public class Program 
{
	public static void main(String[] args) 
	{
		try
		{
			Complex complex = new Complex();
			System.out.println(complex);
		
			Class<?> c = complex.getClass();
			Field field = c.getDeclaredField("real");
			field.setAccessible(true);
			field.setInt(complex, 500);
			
			field = c.getDeclaredField("imag");
			field.setAccessible(true);
			field.setInt(complex, 600);
			
			System.out.println( complex.toString());
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
	}
}
