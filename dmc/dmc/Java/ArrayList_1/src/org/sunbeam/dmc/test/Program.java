package org.sunbeam.dmc.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Program 
{
	public static void main1(String[] args) 
	{
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		
		List<Integer> list2 = new ArrayList<Integer>();
		
		Collection<Integer> list3 = new ArrayList<Integer>();
	}
	public static void main2(String[] args) 
	{
		int capacity = 15;
		List<Integer> list = new ArrayList<Integer>( capacity );
	}
	public static void main3(String[] args) 
	{
		Collection<Integer> c = new ArrayList<Integer>();
		c.add(10);
		c.add(20);
		c.add(30);
		List<Integer> list = new ArrayList<Integer>( c );
	}
	public static void main4(String[] args) 
	{
		List<Integer> al = new ArrayList<Integer>();
		al.add(10);
		al.add(20);
		al.add(30);
		List<Integer> list = new ArrayList<Integer>( al );
	}
	public static void main(String[] args) 
	{
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add( 10 );
		list1.add( 20 );
		list1.add( 30 );
		
		List<Integer> list = new ArrayList<Integer>( list1 );
	}
}
