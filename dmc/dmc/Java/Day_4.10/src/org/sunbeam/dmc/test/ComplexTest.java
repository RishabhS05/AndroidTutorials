package org.sunbeam.dmc.test;

import java.util.Scanner;

import org.sunbeam.dmc.complex.Complex;

public class ComplexTest 
{
	static Scanner sc = new Scanner(System.in);
	Complex c1 = new Complex();
	public void acceptRecord()
	{
		System.out.print("Real Number	:	");
		c1.setReal(sc.nextInt());
		System.out.print("Imag Number	:	");
		c1.setImag(sc.nextInt());
	}
	public void printRecord()
	{
		//System.out.println(c1.toString());
		System.out.println("Real Number	:	"+c1.getReal());
		System.out.println("Imag Number	:	"+c1.getImag());
	}
	public static int menuList()
	{
		System.out.println("0.Exit");
		System.out.println("1.Accept Record");
		System.out.println("2.Print Record");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
}
