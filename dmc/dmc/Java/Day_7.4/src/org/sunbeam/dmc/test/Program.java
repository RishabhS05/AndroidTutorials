package org.sunbeam.dmc.test;

import java.util.Date;
import java.util.LinkedList;

class Box<T>	//T : Type Parameter
{
	private T object;	//null
	public T getObject() 
	{
		return object;
	}
	public void setObject(T object) 
	{
		this.object = object;
	}
}
public class Program 
{
	public static void main1(String[] args) 
	{
		Box<Date> b1 = new Box<Date>();	//Date : Type Argument
		b1.setObject(new Date());
		Date dt2 = b1.getObject();
	}
	public static void main2(String[] args) 
	{
		Box<Date> b1 = new Box<>();	//Date : Type Argument
		b1.setObject(new Date());
		Date dt2 = b1.getObject();
		System.out.println(dt2);
	}
	public static void main(String[] args) 
	{
		//Box<int> b1 = new Box<>();	//Not OK	
		Box<Integer> b1 = new Box<>();	//Ok
	}
}
