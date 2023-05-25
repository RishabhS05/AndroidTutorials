package org.sunbeam.dmc.test;

import java.time.Period;

@FunctionalInterface
interface Printable
{
	void print( );
}
public class Program 
{
	public static void main(String[] args) 
	{
		Printable p = ()->System.out.println("Hello");
		p.print();
	}
}
