package org.sunbeam.dmc.test;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program 
{
	 public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	 public static final String PHONE_PATTERN = "\\d{10}";
	 public static final String NAME_PATTEREN = "[a-zA-Z][a-zA-Z ]*";
	public static void main1(String[] args) 
	{
		try( Scanner sc = new Scanner(System.in))
		{
			System.out.print("Email	:	");
			String email = sc.nextLine();
			
			Pattern p = Pattern.compile(EMAIL_PATTERN);
			Matcher m = p.matcher(email);
			if( m.matches())
				System.out.println(email);
			else
				System.out.println("Invalid email");
		}
	}
	public static void main2(String[] args) 
	{
		try( Scanner sc = new Scanner(System.in))
		{
			System.out.print("Email	:	");
			String email = sc.nextLine();
			if( Pattern.matches(EMAIL_PATTERN, email))
				System.out.println(email);
			else
				System.out.println("Invalid email");
		}
	}
	public static void main(String[] args) 
	{
		try( Scanner sc = new Scanner(System.in))
		{
			System.out.print("Email	:	");
			String email = sc.nextLine();
			if( email.matches(EMAIL_PATTERN))
				System.out.println(email);
			else
				System.out.println("Invalid email");
		}
	}
}






