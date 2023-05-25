package org.sunbeam.dmc.test;

import java.util.ConcurrentModificationException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

public class Program
{
	public static void main1(String[] args) 
	{
		Vector<Integer> v = new Vector<Integer>();
		v.add(10);
		v.add(20);
		v.add(30);
		
		Enumeration<Integer> e = v.elements();
		int element = 0;
		while( e.hasMoreElements())
		{
			element = e.nextElement();
			System.out.println(element);
		}
	}
	public static void main2(String[] args) 
	{
		Vector<Integer> v = new Vector<Integer>();
		v.add(10);
		v.add(20);
		v.add(30);
		
		Iterator<Integer> itr = v.iterator();
		int element = 0;
		while( itr.hasNext())
		{
			element = itr.next();
			System.out.println(element);
		}
	}
	public static void main3(String[] args) 
	{
		Vector<Integer> v = new Vector<Integer>();
		v.add(10);
		v.add(20);
		v.add(30);
		
		ListIterator<Integer> itr = v.listIterator();
		int element = 0;
		while( itr.hasNext())
		{
			element = itr.next();
			System.out.println(element);
		}
		
		while( itr.hasPrevious())
		{
			element = itr.previous();
			System.out.println(element);
		}
	}
	public static void main(String[] args) 
	{
		Vector<Integer> v = new Vector<Integer>();
		v.add(10);
		v.add(20);
		v.add(30);
		
		/*for( int element : v )
		{
			System.out.println(element);
			if( element == 30 )
				v.add(40);	//ConcurrentModificationException
		}*/
		
		/*Iterator<Integer> itr = v.iterator();
		while( itr.hasNext())
		{
			int element = itr.next();
			System.out.println(element);
			if( element == 30 )
				v.add(40);//ConcurrentModificationException
		}*/
		
		Enumeration<Integer> e = v.elements();
		while( e.hasMoreElements())
		{
			int element = e.nextElement();
			System.out.println(element);
			if( element == 30 )
				v.add(40);	//Ok
		}
	}
}
