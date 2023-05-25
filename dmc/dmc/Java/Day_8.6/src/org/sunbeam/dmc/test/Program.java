package org.sunbeam.dmc.test;

interface A
{
	void f1();
}
interface B
{
	void f1();
}
class C implements A, B
{
	@Override
	public void f1() 
	{
		System.out.println("C.f1");
	}
}
public class Program 
{
	public static void main(String[] args) 
	{
		A a = new C();
		a.f1();
		
		B b = new C();
		b.f1();
	}
}
