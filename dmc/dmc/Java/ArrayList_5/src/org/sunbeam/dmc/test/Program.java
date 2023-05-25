package org.sunbeam.dmc.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
public class Program 
{
	public static List<Integer> getList( )
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(70);
		list.add(10);
		list.add(60);
		list.add(20);
		list.add(50);
		list.add(30);
		list.add(40);
		return list;
	}
	public static void main1(String[] args) 
	{
		List<Integer> list = Program.getList();
		Collections.sort(list);
		list.forEach(System.out::println);
	}
	public static void main2(String[] args) 
	{
		List<Integer> list = Program.getList();
		list.sort(null);
		list.forEach(System.out::println);
	}
	public static void main3(String[] args) 
	{
		List<Integer> list = Program.getList();
		Object[] arr = list.toArray();
		System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args) 
	{
		List<Integer> list = Program.getList();
		Integer[] arr = new Integer[ list.size() ];
		list.toArray(arr);
		System.out.println(Arrays.toString(arr));
	}
}
