package org.sunbeam.dmc.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
public class Program 
{
	public static List<Integer> getList( )
	{
		List<Integer> list = new ArrayList<Integer>();
		for( int count = 10; count <= 100; count = count + 10 )
			list.add(count);
		return list;
	}
	public static void main1(String[] args) 
	{
		List<Integer> list = Program.getList();
		Integer key = new Integer(50);
		if( list.contains(key))
		{
			int index = list.indexOf(key);
			list.remove(index);
			list.forEach(System.out::println);
		}
		else
			System.out.println("Key not found");
	}
	public static void main2(String[] args) 
	{
		List<Integer> list = Program.getList();
		Integer key = new Integer(50);
		if( list.contains(key))
		{
			list.remove(key);
			list.forEach(System.out::println);
		}
		else
			System.out.println("Key not found");
	}
	public static void main3(String[] args) 
	{	
		Collection<Integer> keys = Arrays.asList(40,50,60);
		List<Integer> list = Program.getList();
		if( list.containsAll(keys))
		{
			list.removeAll(keys);
			list.forEach(System.out::println);
		}
		else
			System.out.println("keys not found");
	}
	public static void main(String[] args) 
	{	
		Collection<Integer> keys = Arrays.asList(40,50,60);
		List<Integer> list = Program.getList();
		if( list.containsAll(keys))
		{
			list.retainAll(keys);
			list.forEach(System.out::println);
		}
		else
			System.out.println("keys not found");
	}
}
