package org.sunbeam.dmc.test;

import java.util.Arrays;

class Employee implements Comparable<Employee>
{
	private String name;
	private int empid;
	private float salary;
	public Employee() 
	{	}
	public Employee(String name, int empid, float salary)
	{
		this.name = name;
		this.empid = empid;
		this.salary = salary;
	}
	/*@Override
	public int compareTo(Employee other )
	{
		if( this.salary < other.salary )
			return -1;
		else if( this.salary > other.salary )
			return 1;
		return 0;
	}*/
	/*@Override
	public int compareTo(Employee other )
	{
		return (int) (this.salary - other.salary);
	}*/
	/*@Override
	public int compareTo(Employee other )
	{
		return this.empid - other.empid;
	}*/
	@Override
	public int compareTo(Employee other )
	{
		return this.name.compareTo(other.name);
	}
	@Override
	public String toString() 
	{
		return String.format("%-15s%-5d%-10.2f",this.name, this.empid, this.salary);
	}
}
public class Program 
{
	public static Employee[] getEmployees()
	{
		Employee[] arr = new Employee[ 5 ];
		arr[ 0 ] = new Employee("Umesh",15,50000);
		arr[ 1 ] = new Employee("Nitin",11,40000);
		arr[ 2 ] = new Employee("Amit",14,30000);
		arr[ 3 ] = new Employee("Yogesh",12,20000);
		arr[ 4 ] = new Employee("Sachin",13,10000);
		return arr;
	}
	public static void print( Employee[] arr )
	{
		if( arr != null )
		{
			for (Employee emp : arr) 
				System.out.println(emp.toString());
		}
		System.out.println();
	}
	public static void main(String[] args)
	{
		Employee[] arr = Program.getEmployees();
		Program.print(arr);
		
		Arrays.sort( arr );	//mergeSort
		Program.print(arr);
	}
}
