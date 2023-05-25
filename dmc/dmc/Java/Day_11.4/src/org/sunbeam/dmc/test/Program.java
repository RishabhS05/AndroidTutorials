package org.sunbeam.dmc.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Program 
{
	public static void printPackageInfo( Class<?> c )
	{
		String packageName =  c.getPackage().getName();
		System.out.println("Package	:	"+packageName);
	}
	public static void printClassInfo( Class<?> c )
	{
		//System.out.println(c.getName());
		System.out.println("Class	:	"+c.getSimpleName());
	}
	public static void printFieldInfo( Class<?> c )
	{
		Field[] fields = c.getFields();
		for (Field field : fields)
			System.out.println(field.toString());
	}
	public static void printConstructorInfo( Class<?> c )
	{
		Constructor<?>[] constructors= c.getConstructors();
		for (Constructor<?> constructor : constructors)
			System.out.println(constructor.toString());
	}
	public static void printMethodInfo( Class<?> c )
	{
		Method[] mthods = c.getMethods();
		for (Method method : mthods) 
			System.out.println(method.toString());
	}
	public static void main(String[] args) 
	{
		try(Scanner sc = new Scanner(System.in))
		{
			System.out.print("Enter F.Q. Class Name	:	");
			String className = sc.nextLine();
			Class<?> c =  Class.forName(className);
			
			Program.printPackageInfo(c);
			
			Program.printClassInfo(c);
		
			Program.printFieldInfo(c);
			
			Program.printMethodInfo(c);
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
	}
}
