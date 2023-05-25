package org.sunbeam.dmc.test;

interface A
{
	int num1 = 10;	//Ok
}
interface B
{
	int num1 = 20;	//Ok
}
interface C extends A, B
{	}
public class Program 
{
	public static void main(String[] args) 
	{
		System.out.println("Num1	:	"+A.num1);	//Ok : 10
		
		System.out.println("Num1	:	"+B.num1);	//Ok : 20
		
		System.out.println("Num1	:	"+C.num1);	//Ambiguity Error
	}
}
