package org.sunbeam.dmc.test;

import java.time.LocalDateTime;

class Date implements Cloneable
{
	private int day;
	private int month;
	private int year;
	public Date() 
	{
		LocalDateTime ldt = LocalDateTime.now();
		this.day = ldt.getDayOfMonth();
		this.month = ldt.getMonthValue();
		this.year = ldt.getYear();
	}
	public Date(int day, int month, int year)
	{
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public int getDay() 
	{
		return this.day;
	}
	public void setDay(int day) 
	{
		this.day = day;
	}
	public int getMonth() 
	{
		return this.month;
	}
	public void setMonth(int month) 
	{
		this.month = month;
	}
	public int getYear() 
	{
		return this.year;
	}
	public void setYear(int year) 
	{
		this.year = year;
	}
	public Date clone( ) throws CloneNotSupportedException
	{
		Date other =  (Date) super.clone();
		return other;
	}
	@Override
	public String toString() 
	{
		return String.format("%d / %d / %d", this.day,this.month,this.year);
	}
}
class Employee implements Cloneable
{
	private String name;
	private int empid;
	private float salary;
	private Date joinDate;
	public Employee() 
	{
		this.name = "";
		this.empid = 0;
		this.salary = 0;
		this.joinDate = new Date();
	}
	public String getName() 
	{
		return this.name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public int getEmpid() 
	{
		return this.empid;
	}
	public void setEmpid(int empid)
	{
		this.empid = empid;
	}
	public float getSalary()
	{
		return this.salary;
	}
	public void setSalary(float salary)
	{
		this.salary = salary;
	}
	public Date getJoinDate() 
	{
		return this.joinDate;
	}
	public void setJoinDate(Date joinDate) 
	{
		this.joinDate = joinDate;
	}
	public Employee clone() throws CloneNotSupportedException
	{
		Employee other = (Employee) super.clone();
		other.name = new String(this.name);
		other.joinDate = this.joinDate.clone();
		return other;
	}
	@Override
	public String toString() 
	{
		return String.format("%-15s%-5d%-10.2f%s", this.name, this.empid, this.salary, this.joinDate.toString());
	}
}
public class Program 
{
	public static void main(String[] args)
	{
		try 
		{
			Date dt1 = new Date( );
			Date dt2 = dt1.clone();
			if( dt1 == dt2 )
				System.out.println("Equal");
			else
				System.out.println("Not Equal");
		}
		catch (CloneNotSupportedException e) 
		{
			e.printStackTrace();
		}
	}
}
