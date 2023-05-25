package org.sunbeam.dmc.test;

import java.net.InetAddress;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Validator
{
	 public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	 public static boolean validateEmail( String email )
	 {
		return email.matches(EMAIL_PATTERN);
	 }
	 public static final String PHONE_PATTERN = "\\d{10}";
	 public static boolean validatePhoneNumber( String phoneNumber )
	 {
		return phoneNumber.matches(PHONE_PATTERN);
	 }
	 public static final String NAME_PATTEREN = "[a-zA-Z][a-zA-Z ]*";
	 public static boolean validateName( String name )
	 {
		return name.matches(NAME_PATTEREN);
	 }
}
public class Program 
{
	public static void main1(String[] args) 
	{
		try( Scanner sc = new Scanner(System.in))
		{
			String name;
			System.out.print("Name	:	");
			name = sc.nextLine();
			while( !Validator.validateName(name))
			{
				System.out.print("Re-enter Name	:	");
				name = sc.nextLine();
			}
			System.out.println("Name	:	"+name);
		}
	}
	public static void main(String[] args)throws Exception 
	{
		InetAddress localhost = InetAddress.getLocalHost();
		String hostName = localhost.getHostName();
		String hostAddress = localhost.getHostAddress();
		System.out.println(hostName+"	:	"+hostAddress);
	}
}






