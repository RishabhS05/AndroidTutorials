package org.sunbeam.dmc.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

class Employee implements Comparable<Employee>, Serializable
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	@Override
	public int compareTo(Employee other) 
	{
		return this.empid - other.empid;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empid != other.empid)
			return false;
		return true;
	}
	@Override
	public String toString() 
	{
		return String.format("%-15s%-5d%-10.2f", this.name, this.empid, this.salary);
	}
}
class SortByName implements Comparator<Employee>
{
	@Override
	public int compare(Employee emp1, Employee emp2) 
	{
		return emp1.getName().compareTo(emp2.getName());
	}
}
class SortByEmpid implements Comparator<Employee>
{
	@Override
	public int compare(Employee emp1, Employee emp2) 
	{
		return emp1.getEmpid() - emp2.getEmpid();
	}
}
class SortBySalary implements Comparator<Employee>
{
	@Override
	public int compare(Employee emp1, Employee emp2) 
	{
		return (int) (emp1.getSalary() - emp2.getSalary());
	}
}
class ListTest
{
	private List<Employee> empList;//null
	public void setEmpList(List<Employee> empList) 
	{	
		this.empList = empList;
	}
	public void addNewRecord( Employee[] arr )
	{
		if( this.empList != null && arr != null )
		{
			for( Employee emp : arr )
				this.empList.add(emp);
		}
	}
	/*public Employee findRecord(int empid )
	{
		if( this.empList != null )
		{
			for( Employee emp : this.empList )
			{
				if( emp.getEmpid() == empid )
					return emp;
			}
		}
		return null;
	}*/
	public Employee findRecord(int empid )
	{
		if( this.empList != null )
		{
			Employee key = new Employee();
			key.setEmpid(empid);
			if( this.empList.contains(key) )
			{
				int index = this.empList.indexOf(key);
				return this.empList.get(index);
			}
		}
		return null;
	}
	/*public boolean removeRecord(int empid )
	{
		if( this.empList != null )
		{
			Employee key = new Employee();
			key.setEmpid(empid);
			if( this.empList.contains(key) )
			{
				int index = this.empList.indexOf(key);
				this.empList.remove(index);
				return true;
			}
		}
		return false;
	}*/
	public boolean removeRecord(int empid )
	{
		if( this.empList != null )
		{
			Employee key = new Employee();
			key.setEmpid(empid);
			if( this.empList.contains(key) )
			{
				this.empList.remove(key);
				return true;
			}
		}
		return false;
	}
	public void printRecord( Comparator<Employee> comparator )
	{
		this.empList.sort(comparator);
		this.empList.forEach(System.out::println);
	}
	public void writeRecord(String pathname )throws Exception 
	{
		try( ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(pathname)))))
		{
			outputStream.writeObject(this.empList);
		}
	}
	public void readRecord(String pathname ) throws Exception
	{
		try( ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(pathname)))))
		{
			this.empList = (List<Employee>) inputStream.readObject();
		}
	}
}
public class Program 
{
	static Scanner sc = new Scanner(System.in);
	public static Employee[] getEmployees()
	{
		Employee[] arr = new Employee[ 10 ];
		arr[ 0 ] = new Employee("Prashant",110,90000);
		arr[ 1 ] = new Employee("Ankit",101,85000);
		arr[ 2 ] = new Employee("Nikhil",109,80000);
		arr[ 3 ] = new Employee("Umesh",102,75000);
		arr[ 4 ] = new Employee("Sachin",108,70000);
		arr[ 5 ] = new Employee("Rohan",103,65000);
		arr[ 6 ] = new Employee("Ketan",107,60000);
		arr[ 7 ] = new Employee("Vikas",104,55000);
		arr[ 8 ] = new Employee("Devendra",106,50000);
		arr[ 9 ] = new Employee("Rajiv",105,45000);
		return arr;
	}
	public static void acceptRecord( int[] empid )
	{
		System.out.print("Enter empid	:	");
		empid[ 0 ] = sc.nextInt();
	}
	public static void printRecord( Employee emp )
	{
		if( emp != null )
			System.out.println(emp.toString());
		else
			System.out.println("Employee not found");
	}
	public static void printRecord( boolean removedStatus )
	{
		System.out.println(removedStatus ? "Employee removed" : "Employee not removed");
	}
	public static int menuList( )
	{
		System.out.println("0.Exit");
		System.out.println("1.Add New Record");
		System.out.println("2.Find Record");
		System.out.println("3.Remove Record");
		System.out.println("4.Print Record(Sorted)");
		System.out.println("5.Write Record");
		System.out.println("6.Read Record");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
	public static int subMenuList( )
	{
		System.out.println("0.Exit");
		System.out.println("1.Sort By Name");
		System.out.println("2.Sort By Empid");
		System.out.println("3.Sort By Salary");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
	public static void main(String[] args) 
	{
		int choice;
		int[] empid = new int[1];
		ListTest test = new ListTest();
		test.setEmpList(new ArrayList<Employee>());
		while( ( choice = Program.menuList( ) ) != 0 )
		{
			try
			{
				switch( choice )
				{
				case 1:
					Employee[] arr = Program.getEmployees();
					test.addNewRecord( arr );
					break;
				case 2:
					Program.acceptRecord( empid );
					Employee emp = test.findRecord( empid[ 0 ] );
					Program.printRecord( emp );
					break;
				case 3:
					Program.acceptRecord( empid );
					boolean removedStatus = test.removeRecord( empid[ 0 ] );
					Program.printRecord( removedStatus );
					break;
				case 4:
					while( ( choice = Program.subMenuList( ) ) != 0 )
					{
						Comparator<Employee> comparator = null;
						switch( choice )
						{
						case 1:
							comparator = new SortByName();
							break;
						case 2:
							comparator = new SortByEmpid();
							break;
						case 3:
							comparator = new SortBySalary();
							break;
						}
						test.printRecord( comparator );
					}
					break;
				case 5:
					test.writeRecord( "EmployeeDB.dat" );
					break;
				case 6:
					test.readRecord( "EmployeeDB.dat" );
					break;
				}
			}
			catch( Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
