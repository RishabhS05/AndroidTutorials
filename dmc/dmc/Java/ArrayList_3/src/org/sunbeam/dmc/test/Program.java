package org.sunbeam.dmc.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Program 
{
	public static List<Integer> getList( )
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(300);
		list.add(40);
		list.add(50);
		return list;
	}
	public static void main1(String[] args) 
	{
		List<Integer> list = Program.getList();
		list.add(1, 20);
		list.set(2, 30);
		list.forEach(System.out::println);
	}
	public static void main2(String[] args) 
	{
		List<Integer> tempList = Arrays.asList(60,70,80);	//ArrayList
		List<Integer> list = Program.getList();
		list.addAll(tempList);
		list.add(1, 20);
		list.set(2, 30);
		list.forEach(System.out::println);
	}
	public static void main(String[] args) 
	{
		List<Integer> tempList = Arrays.asList(60,70);
		List<Integer> list = Program.getList();
		list.add(1, 20);
		list.set(2, 30);
		list.add(80);
		list.add(90);
		list.addAll(5, tempList);
		list.forEach(System.out::println);
	}
}
