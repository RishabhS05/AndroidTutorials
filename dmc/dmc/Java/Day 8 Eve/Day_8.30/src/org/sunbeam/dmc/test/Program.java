package org.sunbeam.dmc.test;

import java.util.Arrays;
import java.util.Comparator;

class Person implements Comparable<Person>
{
	private String name;
	public Person() 
	{	}
	public Person( String name )
	{
		this.name = name;
	}
	public String getName() 
	{
		return name;
	}
	@Override
	public int compareTo(Person other)
	{
		return this.name.compareTo(other.name);
	}
	@Override
	public String toString() 
	{
		return this.name;
	}
}
class Student extends Person
{
	private int rollNumber;
	public Student() 
	{	}
	public Student( String name, int rollNumber )
	{
		super(name);
		this.rollNumber = rollNumber;
	}
	public int getRollNumber() {
		return rollNumber;
	}
	@Override
	public String toString() 
	{
		return String.format("%-15s%-5d", super.toString(), this.rollNumber);
	}
}
class Employee extends Person
{
	private int empid;
	public Employee() 
	{	}
	public Employee( String name, int empid )
	{
		super(name);
		this.empid = empid;
	}
	public int getEmpid() {
		return empid;
	}
	@Override
	public String toString() 
	{
		return String.format("%-15s%-5d", super.toString(), this.empid);
	}
}
class SortById implements Comparator<Person>
{
	@Override
	public int compare(Person p1, Person p2) 
	{
		if( p1 instanceof Student && p2 instanceof Student )
		{
			Student s1 = (Student) p1;
			Student s2 = (Student) p2;
			return s1.getRollNumber() - s2.getRollNumber();
		}
		else if( p1 instanceof Employee && p2 instanceof Employee )
		{
			Employee emp1 = (Employee) p1;
			Employee emp2 = (Employee) p2;
			return emp1.getEmpid() - emp2.getEmpid();
		}
		else if( p1 instanceof Student && p2 instanceof Employee )
		{
			Student s1 = (Student) p1;
			Employee emp2 = (Employee) p2;
			return s1.getRollNumber() - emp2.getEmpid();
		}
		else
		{
			Employee emp1 = (Employee) p1;
			Student s2 = (Student) p2;
			return emp1.getEmpid() - s2.getRollNumber();
		}
	}
}
public class Program 
{
	public static Person[] getPersons()
	{
		Person[] arr = new Person[ 5 ];
		arr[ 0 ] = new Student("Rajiv",50);
		arr[ 1 ] = new Employee("Nitin",10);
		arr[ 2 ] = new Student("Yogesh", 40);
		arr[ 3 ] = new Employee("Prashant",20);
		arr[ 4 ] = new Student("Amit", 30);
		return arr;
	}
	public static void print( Person[] arr )
	{
		if( arr != null )
			for (Person person : arr) 
				System.out.println(person.toString());
		
		System.out.println();
	}
	public static void main(String[] args)
	{
		Person[] arr = Program.getPersons();
		Program.print(arr);
		
		//Arrays.sort( arr );
		
		//Comparator<Person> comparator = new SortById();
		//Arrays.sort( arr, comparator );
		Arrays.sort( arr, new SortById());
		Program.print(arr);
	}
}
