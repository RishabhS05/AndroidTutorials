package org.sunbeam.dmc.test;
class Test
{
	//Instance Variable
	private int num1;	
	private int num2;
	//Class Level variable
	private static int num3;
	static
	{
		Test.num3 = 500;
	}
	public Test() 
	{	}
	public Test(int num1, int num2) 
	{
		this.num1 = num1;
		this.num2 = num2;
	}
	//Instance Methods
	public int getNum1() 
	{
		return num1;
	}
	public void setNum1(int num1) 
	{
		this.num1 = num1;
	}
	public int getNum2() 
	{
		return num2;
	}
	public void setNum2(int num2) 
	{
		this.num2 = num2;
	}
	//Class Level Methods
	public static int getNum3() 
	{
		return num3;
	}
	public static void setNum3(int num3) 
	{
		Test.num3 = num3;
	}
}
public class Program 
{
	public static void main(String[] args) 
	{
		Test t1 = new Test();
		t1.setNum1(10);
		t1.setNum2(20);
		Test.setNum3(30);
		
		System.out.println("Num1	:	"+t1.getNum1());
		System.out.println("Num2	:	"+t1.getNum2());
		System.out.println("Num3	:	"+Test.getNum3());
	}
}
