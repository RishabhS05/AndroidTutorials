package org.sunbeam.dmc.test;

class Employee
{
	private String name;
	private int empid;
	private float salary;
	public Employee(String name, int empid, float salary)
	{
		this.name = name;
		this.empid = empid;
		this.salary = salary;
	}
	//Employee this = emp1;
	//Object obj = emp2;	//Upcasting
	/*@Override
	public boolean equals(Object obj) 
	{
		if( obj != null )
		{
			Employee other = (Employee) obj;	//Downcasting
			if( this.empid == other.empid )
				return true;
		}
		return false;
	}*/
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
}
public class Program 
{
	public static void main(String[] args) 
	{	
		Employee emp1 = new Employee("ABC", 1221, 25000);
		Employee emp2 = new Employee("ABC", 1221, 25000);
		if( emp1.equals(emp2))
			System.out.println("Equal");
		else
			System.out.println("Not Equal");
		//Output : Not Equal
	}
}
