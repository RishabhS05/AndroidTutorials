package org.sunbeam.dmc.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

public class Program 
{
	public static List<Integer> getList( )
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		return list;
	}
	public static void main1(String[] args) 
	{
		List<Integer> list = Program.getList();
		for( int index = 0; index < list.size(); ++ index )
		{
			int element = list.get(index);
			System.out.println(element);
		}
		
		//int ele = list.get(list.size());	//IndexOutOfBoundsException
	}
	public static void main2(String[] args) 
	{
		List<Integer> list = Program.getList();
		for( Integer element : list )
			System.out.println(element);
	}
	public static void main3(String[] args) 
	{
		List<Integer> list = Program.getList();	
		//Consumer<Integer> c = number  -> System.out.println(number);
		//list.forEach(c);
		list.forEach(number->System.out.println(number));
	}
	public static void main4(String[] args) 
	{
		List<Integer> list = Program.getList();	
		list.forEach( System.out::println );	
	}
	public static void main5(String[] args) 
	{
		List<Integer> list = Program.getList();	
		ListIterator<Integer> itr = list.listIterator();
		
		int element;
		while( itr.hasNext())
		{
			element = itr.next();
			System.out.print(element+"	");
		}
		System.out.println();
		while( itr.hasPrevious())
		{
			element = itr.previous();
			System.out.print(element+"	");
		}
	}
	public static void main(String[] args) 
	{
		List<Integer> list = Program.getList();	
		ListIterator<Integer> itr = list.listIterator( list.size() );
		
		int element;
		while( itr.hasPrevious())
		{
			element = itr.previous();
			System.out.print(element+"	");
		}
	}
}
