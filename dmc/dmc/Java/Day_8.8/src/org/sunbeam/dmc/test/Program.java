package org.sunbeam.dmc.test;
interface A
{
	void f1( );
	default void f2( )
	{
		System.out.println("A.f2");
	}
}
class B implements A
{
	@Override
	public void f1() 
	{
		System.out.println("B.f1");
	}
	@Override
	public void f2() 
	{
		A.super.f2();
		System.out.println("B.f2");
	}
}
public class Program 
{
	public static void main(String[] args) 
	{
		A a = new B();
		a.f1();
		a.f2();
	}
}
