package org.sunbeam.dmc.test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

public class Program 
{
	public static int capacity( ArrayList<Integer> list )throws Exception
	{
		Class<?> c = list.getClass();
		Field field = c.getDeclaredField("elementData");
		field.setAccessible(true);
		Object[] elementData = (Object[]) field.get(list);
		return elementData.length;
	}
	public static ArrayList<Integer> getList( )
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		return list;
	}
	public static void main1(String[] args) 
	{
		try
		{
			ArrayList<Integer> list = Program.getList();
			System.out.println( Program.capacity(list));
			System.out.println(list.size());
			
			System.out.println();
			
			list.trimToSize();
			System.out.println( Program.capacity(list));
			System.out.println(list.size());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		try
		{
			ArrayList<Integer> list = Program.getList();
			list.ensureCapacity(11);
			System.out.println("Capacity	:	"+Program.capacity(list));
			
			list.forEach(System.out::println);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
