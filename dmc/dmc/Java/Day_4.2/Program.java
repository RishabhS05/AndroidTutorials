class Employee
{
	private String name;
	private int empid;
	private float salary;
	private String designation;
	private String department;
	public Employee( )
	{	}
	public Employee( String name, int empid, float salary, String designation, String department )
	{
		this.name = name;
		this.empid = empid;
		this.salary = salary;
		this.designation = designation;
		this.department = department;
	}
	public void printRecord( )
	{
		System.out.println("Name	:	"+this.name);
		System.out.println("Empid	:	"+this.empid);
		System.out.println("Salary	:	"+this.salary);
		System.out.println("Designation	:	"+this.designation);
		System.out.println("Department	:	"+this.department);
	}
	public String toString()
	{
		//return this.name+"	"+this.empid+"	"+this.salary;
		return String.format("%-15s%-5d%-10.2f",this.name, this.empid, this.salary);
	}
}
class Program
{
	public static void main( String[] args )
	{
		Employee emp = new Employee("ABC",12,25000,"Manager","Sales");
		System.out.println( emp.toString());
	}
}
