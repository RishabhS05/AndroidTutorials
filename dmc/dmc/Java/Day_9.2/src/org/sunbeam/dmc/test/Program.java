package org.sunbeam.dmc.test;

import java.util.Set;
import java.util.TreeSet;

public class Program
{
	public static void main(String[] args) 
	{
		Set<Integer> set = new TreeSet<Integer>();
		set.add(50);
		set.add(10);
		set.add(40);
		set.add(20);
		set.add(30);
		
		set.add(50);
		set.add(10);
		set.add(40);
		set.add(20);
		set.add(30);
		
		set.add(null);
		
		set.forEach(System.out::println);
	}
}
