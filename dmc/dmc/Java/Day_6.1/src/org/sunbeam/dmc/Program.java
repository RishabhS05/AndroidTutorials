package org.sunbeam.dmc;

class Person
{
	public void print()
	{
		System.out.println("Person.print");
	}
}
class Employee extends Person
{
	public void print()
	{
		System.out.println("Employee.print");
	}
}
public class Program 
{
	public static void main1(String[] args) 
	{
		Employee emp = new  Employee();
		emp.print();	//Employee.print
	}
	public static void main2(String[] args) 
	{
		Employee emp = new  Employee();
		//Person p = ( Person)emp;//Upcasting
		Person p = emp;//Upcasting
		p.print();	//Employee.print : Dynamic Method Dispatch
	}
	public static void main3(String[] args) 
	{
		Person p = new  Person();
		p.print();//Person.print
	}
	public static void main4(String[] args) 
	{
		Person p = new  Person();
		Employee emp = (Employee)p;	//Downcasting : ClassCastException
		emp.print(); 
	}
	public static void main5(String[] args) 
	{
		Person p = new Employee();
		Employee emp = (Employee)p;	//Downcasting : OK
		emp.print(); //Employee.print
	}
	public static void main(String[] args) 
	{
		Person p = new Employee();	//OK
		
		Employee emp = new Person();	//Not OK
	}
}
