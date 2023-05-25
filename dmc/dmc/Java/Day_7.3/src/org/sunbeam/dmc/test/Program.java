package org.sunbeam.dmc.test;

import java.util.Date;

class Box
{
	private Object object;	//null
	public Object getObject() 
	{
		return object;
	}
	public void setObject(Object object) 
	{
		this.object = object;
	}
}
public class Program 
{
	public static void main1(String[] args) 
	{
		Box b1 = new Box();
		int number = 125;
		b1.setObject(number);
	}
	public static void main2(String[] args) 
	{
		Box b1 = new Box();
		Date dt = new Date(119, 2, 18);
		b1.setObject(dt);
	}
	public static void main(String[] args) 
	{
		Box b1 = new Box();
		b1.setObject(new Date(119, 2, 18));
		String str  =  (String) b1.getObject(); //ClassCastException
		System.out.println(str);
	}
}
