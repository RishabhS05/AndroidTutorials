package org.sunbeam.dmc.test;

import java.util.ArrayList;

public class Program 
{
	public static ArrayList<Integer> getIntegerList()
	{
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		return list;
	}
	public static void print( ArrayList<Number> list )
	{	
		//TODO
	}
	public static void main(String[] args) 
	{	
		ArrayList<Integer> intList = Program.getIntegerList();
		Program.print( intList );
	}
}
