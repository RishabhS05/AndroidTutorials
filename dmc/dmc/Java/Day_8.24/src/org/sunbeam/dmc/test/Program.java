package org.sunbeam.dmc.test;

import java.time.Period;

@FunctionalInterface
interface Printable
{
	void print( String message );
}
public class Program 
{
	public static void main(String[] args) 
	{
		//Printable p = ( String message )->System.out.println(message);
		//Printable p = ( String str )->System.out.println(str);
		//Printable p = ( str )->System.out.println(str);
		Printable p = str ->System.out.println(str);
		p.print("Hello DMC");
	}
}
