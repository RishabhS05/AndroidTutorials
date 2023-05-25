package org.sunbeam.dmc.test;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Scanner;

class Convert
{
	public static Object changeType( String value, Parameter parameter )
	{
		switch( parameter.getType().getSimpleName())
		{
		case "int":
			return Integer.parseInt(value);
		case "float":
			return Float.parseFloat(value);
		case "double":
			return Double.parseDouble(value);
		}
		return null;
	}
}
public class Program 
{
	public static void main(String[] args) 
	{
		try( Scanner sc = new Scanner(System.in))
		{
			System.out.print("F.Q. Class Name	:	");
			String className = sc.nextLine();	//math.Calculator
			Class<?> c = Class.forName(className);
			
			System.out.print("Method Name	:	");
			String methodName = sc.nextLine();	//sum
			
			Method[] methods = c.getMethods();
			for (Method method : methods) 
			{
				if( method.getName().equalsIgnoreCase(methodName))
				{
					Object[] arr = new Object[ method.getParameterCount()];
					Parameter[] parameters =  method.getParameters();
					for( int index = 0; index < parameters.length; ++ index )
					{
						System.out.print("Enter value for argument of "+parameters[ index ].getType().getSimpleName()+"	:	");
						String argument = sc.nextLine();
						arr[ index ] = Convert.changeType(argument, parameters[ index ] );
					}
					
					Object obj =  c.newInstance();
					Object result =  method.invoke(obj,arr);
					System.out.println("Result	:	"+result);
					break;
				}
			}
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
	}
}
