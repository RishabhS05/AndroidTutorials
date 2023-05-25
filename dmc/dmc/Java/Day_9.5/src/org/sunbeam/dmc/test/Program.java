package org.sunbeam.dmc.test;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class Program 
{
	public static void main1(String[] args) 
	{
		Dictionary<Integer, String> d = new Hashtable<Integer, String>();
		d.put(1, "DMC");
		d.put(2, "DAC");
		d.put(3, "DBDA");
		d.put(4, "DESD");
	
		System.out.println("Count	:	"+d.size());
	}
	public static void main2(String[] args) 
	{
		Dictionary<Integer, String> d = new Hashtable<Integer, String>();
		d.put(1, "DMC");
		d.put(2, "DAC");
		d.put(3, "DBDA");
		d.put(4, "DESD");
	
		Enumeration<Integer> e = d.keys();
		while( e.hasMoreElements())
		{
			int key = e.nextElement();
			System.out.println(key);
		}
	}
	public static void main3(String[] args) 
	{
		Dictionary<Integer, String> d = new Hashtable<Integer, String>();
		d.put(1, "DMC");
		d.put(2, "DAC");
		d.put(3, "DBDA");
		d.put(4, "DESD");
	
		Enumeration<String> e = d.elements();
		while( e.hasMoreElements())
		{
			String value = e.nextElement();
			System.out.println(value);
		}
	}
	public static void main(String[] args) 
	{
		Dictionary<Integer, String> d = new Hashtable<Integer, String>();
		d.put(1, "DMC");
		d.put(2, "DAC");
		d.put(3, "DBDA");
		d.put(4, "DESD");
	
		Integer key = new Integer(2);
		//String value =  d.get(key);
		String value =  d.remove(key);
		System.out.println(value);
	}
}
