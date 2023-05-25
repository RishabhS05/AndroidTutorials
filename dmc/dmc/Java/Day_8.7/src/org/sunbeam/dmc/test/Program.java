package org.sunbeam.dmc.test;
interface A
{
	void f1();
	void f2();
	void f3();
}
abstract class B implements A
{
	@Override
	public void f1() {	}
	@Override
	public void f2() {	}
	@Override
	public void f3() {	}
}
class C extends B
{
	@Override
	public void f1() 
	{
		System.out.println("C.f1");
	}
	@Override
	public void f3() 
	{
		System.out.println("C.f3");
	}
}
public class Program 
{
	public static void main(String[] args) 
	{
		A a = new C( );
		a.f1();
		a.f2();
		a.f3();
	}
}
