package org.sunbeam.dmc.test;

import java.util.Scanner;

import org.sunbeam.dmc.lib.Address;
import org.sunbeam.dmc.lib.Date;
import org.sunbeam.dmc.lib.Person;

public class Program 
{
	static Scanner sc = new Scanner(System.in);
	public static void acceptRecord( Date date )
	{
		System.out.print("Day	:	");
		date.setDay(sc.nextInt());
		System.out.print("Month	:	");
		date.setMonth(sc.nextInt());
		System.out.print("Year	:	");
		date.setYear(sc.nextInt());
	}
	public static void acceptRecord( Address address )
	{
		System.out.print("City Name	:	");
		address.setCityName(sc.nextLine());
		System.out.print("State Name	:	");
		address.setStateName(sc.nextLine());
		System.out.print("Pincode	:	");
		address.setPincode(sc.nextInt());
	}
	public static void acceptRecord( Person person  )
	{
		System.out.print("Name	:	");
		person.setName(sc.nextLine());
		
		Date date = person.getBirthDate();
		Program.acceptRecord(date);
		
		sc.nextLine();
		
		Address address = person.getCurrentAddress();
		Program.acceptRecord(address);
	}
	public static void printRecord( Date date )
	{
		//System.out.println(date.toString());
		System.out.println(date.getDay()+" / "+date.getMonth()+" / "+date.getYear());
	}
	public static void printRecord( Address address )
	{
		System.out.println(address.toString());
	}
	public static void printRecord( Person person  )
	{
		System.out.println(person.toString());
	}
	public static void main1(String[] args) 
	{
		Date date = new Date();
		Program.acceptRecord(date);
		Program.printRecord(date);
	}
	public static void main2(String[] args) 
	{
		Address address = new Address();
		Program.acceptRecord(address);
		Program.printRecord(address);
	}
	public static void main(String[] args) 
	{
		Person p = new Person();
		Program.acceptRecord(p);
		Program.printRecord(p);
	}
}
