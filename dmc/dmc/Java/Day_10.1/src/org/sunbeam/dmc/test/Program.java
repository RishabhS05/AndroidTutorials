package org.sunbeam.dmc.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Program 
{
	public static Map<Integer, String> getMap()
	{
		Map<Integer, String> map = new Hashtable<>();
		map.put(101, "Pune");
		map.put(203, "Mumbai");
		map.put(413, "Delhi");
		map.put(351, "Nagpur");
		return map;
	}
	public static void main1(String[] args) 
	{
		Map<Integer, String> map = Program.getMap();
		Set<Integer> keys = map.keySet();
		keys.forEach(System.out::println);
	}
	public static void main2(String[] args) 
	{
		Map<Integer, String> map = Program.getMap();
		Collection<String> values = map.values();
		values.forEach(System.out::println);
		//ArrayList<String> list = new ArrayList<String>(values);
	}
	public static void main3(String[] args) 
	{
		Map<Integer, String> map = Program.getMap();
		Set<Entry<Integer, String>> entries = map.entrySet();
		for (Entry<Integer, String> entry : entries) 
		{
			System.out.println(entry.getKey()+"	"+entry.getValue());
		}
	}
	public static void main4(String[] args) 
	{
		Map<Integer, String> map = Program.getMap();
		Integer key = new Integer(203);
		if( map.containsKey(key))
		{
			String value = map.get(key);
			System.out.println(key+"	"+value);
		}
	}
	public static void main(String[] args) 
	{
		Map<Integer, String> map = Program.getMap();
		Integer key = new Integer(203);
		if( map.containsKey(key))
		{
			String value = map.remove(key);
			System.out.println("Removed Element is	:	"+value);
		}
	}
}
