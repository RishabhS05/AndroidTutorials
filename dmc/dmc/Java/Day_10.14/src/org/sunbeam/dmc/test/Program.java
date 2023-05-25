package org.sunbeam.dmc.test;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Program 
{
	public static void main1(String[] args) 
	{
		String str = "Sunbeam Infotech Pune";
		String subStr = str.substring(8);
		System.out.println(subStr);	//Infotech Pune
	}
	public static void main2(String[] args) 
	{
		String str = "Sunbeam Infotech Pune";
		String subStr = str.substring(8,16);
		System.out.println(subStr);	//Infotech Pune
	}
	public static void main3(String[] args) 
	{
		String regex = " ";
		String str = "Sunbeam Infotech Pune";
		String[] words = str.split(regex);
		for (String word : words) 
		{
			System.out.println(word);
		}
	}
	public static void main4(String[] args) 
	{
		String regex = "\\.";
		String str = "www.gmail.com";
		String[] words = str.split(regex);
		for (String word : words) 
		{
			System.out.println(word);
		}
	}
	public static void main5(String[] args) 
	{
		String str = "SunBeam Infotech Pune";
		StringTokenizer stk = new StringTokenizer(str);
		//System.out.println(stk.countTokens());
		String token = "";
		while( stk.hasMoreTokens())
		{
			token = stk.nextToken();
			System.out.println(token);
		}
	}
	public static void main6(String[] args) 
	{
		String str = "www.yahoo.com";
		StringTokenizer stk = new StringTokenizer(str,".");
		String token = "";
		while( stk.hasMoreTokens())
		{
			token = stk.nextToken();
			System.out.println(token);
		}
	}
	public static void main7(String[] args) 
	{
		String str = "ab+bc*cd-de/ef";
		//StringTokenizer stk = new StringTokenizer(str,"+*-/", false);
		StringTokenizer stk = new StringTokenizer(str,"+*-/",true);
		String token = "";
		while( stk.hasMoreTokens())
		{
			token = stk.nextToken();
			System.out.println(token);
		}
	}
	public static void main8(String[] args) 
	{
		StringBuffer sb1 = new StringBuffer("Pune");
		StringBuffer sb2 = new StringBuffer("Pune");
		if( sb1 == sb2 )
			System.out.println("Equal");
		else
			System.out.println("Not Equal");
		//Output : Not Equal
	}
	public static void main9(String[] args) 
	{
		StringBuffer sb1 = new StringBuffer("Pune");
		StringBuffer sb2 = new StringBuffer("Pune");
		if( sb1.equals(sb2) )
			System.out.println("Equal");
		else
			System.out.println("Not Equal");
		//Output : Not Equal
	}
	public static void main10(String[] args) 
	{
		StringBuilder sb1 = new StringBuilder("Pune");
		StringBuilder sb2 = new StringBuilder("Pune");
		if( sb1 == sb2 )
			System.out.println("Equal");
		else
			System.out.println("Not Equal");
		//Output : Not Equal
	}
	public static void main11(String[] args) 
	{
		StringBuilder sb1 = new StringBuilder("Pune");
		StringBuilder sb2 = new StringBuilder("Pune");
		if( sb1.equals(sb2) )
			System.out.println("Equal");
		else
			System.out.println("Not Equal");
		//Output : Not Equal
	}
	public static void main12(String[] args) 
	{
		StringBuilder sb1 = new StringBuilder("Pune");
		StringBuilder sb2 = new StringBuilder("Pune");
		if( sb1.toString().equals(sb2.toString()) )
			System.out.println("Equal");
		else
			System.out.println("Not Equal");
		//Output : Equal
	}
	public static void main(String[] args) 
	{
		try( Scanner sc = new Scanner(System.in))
		{
			System.out.print("Enter number	:	");
			int num1 = sc.nextInt();
			System.out.println("Num1	:	"+num1);
			
			String strNumber = String.valueOf(num1);
			StringBuilder sb = new StringBuilder(strNumber);
			sb.reverse();
			strNumber = sb.toString();
			int num2 = Integer.parseInt(strNumber);
			System.out.println("Num2	:	"+num2);
		}
	}
}






