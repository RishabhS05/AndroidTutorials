package org.sunbeam.dmc;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program 
{
	public static void main(String[] args) 
	{
		Scanner sc = null;
		try
		{	
			System.out.println("Inside try");
			sc = new Scanner(System.in);
			System.out.print("Num1	:	");
			int num1 = sc.nextInt();
			
			System.out.print("Num2	:	");
			int num2 = sc.nextInt();
			
			if( num2 == 0 )
				throw new ArithmeticException("Divide by zero exception");
			int result = num1 / num2;
			System.out.println("Result	:	"+result);
			System.exit(0);
		}
		catch ( ArithmeticException ex )
		{
			System.out.println("Inside catch");
			System.out.println(ex.getMessage());
			System.exit(0);
		}
		finally
		{
			System.out.println("Inside finally");
			sc.close();
		}
	}
}
