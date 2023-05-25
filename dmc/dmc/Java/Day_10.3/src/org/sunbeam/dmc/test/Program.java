package org.sunbeam.dmc.test;

import java.io.File;
import java.io.IOException;

public class Program 
{
	public static void main3(String[] args) 
	{
		try
		{
			String pathname = "Temp";
			File file = new  File(pathname);
			//file.mkdir();
			file.delete();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		try
		{
			String pathname = "Demo.txt";
			File file = new  File(pathname);
			//file.createNewFile();
			file.delete();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public static void main1(String[] args) 
	{
		//String pathname = "/Users/sandeep/Programs/HTML/Index.html";
		String pathname = "/Users/sandeep/Programs";
		File file = new File(pathname);
		if( file.exists())
		{
			if( file.isDirectory())
			{
				String[] arr = file.list();
				for (String str : arr) 
				{
					System.out.println(str);
				}
			}
			else
			{
				System.out.println("Name	:	"+file.getName());
				System.out.println("Parent	:	"+file.getParent());
				System.out.println("Length	:	"+file.length());
			}
		}
		else
			System.out.println(pathname+" does not exist");
	}
}
