package org.sunbeam.dmc.test;
@FunctionalInterface
interface Printable
{
	void print();
}
public class Program 
{
	public static void showRecord()
	{
		System.out.println("showRecord");
	}
	public void printRecord()
	{
		System.out.println("printRecord");
	}
	public static void main(String[] args) 
	{
		//Printable p = ()->System.out.println("Hello");
		//Printable p = Program::showRecord;
		
		Program prog = new  Program();
		Printable p = prog::printRecord;
		p.print();
	}
}
