package org.sunbeam.dmc.test;

interface A
{
	int num1 = 10;	//Ok
}
interface B
{
	int num2 = 20;	//Ok
}
interface C extends A, B
{
	int num3 = 30;
}
public class Program 
{
	public static void main(String[] args) 
	{
		System.out.println("Num1	:	"+A.num1);
		System.out.println("Num1	:	"+C.num1);
		
		System.out.println("Num2	:	"+B.num2);
		System.out.println("Num2	:	"+C.num2);
		
		System.out.println("Num3	:	"+C.num3);
		
	}
}
