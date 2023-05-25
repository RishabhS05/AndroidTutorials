package org.sunbeam.dmc.test;

interface A
{
	void f1();
}
interface B
{
	void f2();
}
class C implements A, B
{
	@Override
	public void f1() 
	{
		System.out.println("C.f1");
	}
	@Override
	public void f2() 
	{
		System.out.println("C.f2");
	}
}
public class Program 
{
	public static void main(String[] args) 
	{
		A a = new C();
		a.f1();
		
		B b = new C();
		b.f2();
		
		C c = new C();
		c.f1();
		c.f2();
	}
}
