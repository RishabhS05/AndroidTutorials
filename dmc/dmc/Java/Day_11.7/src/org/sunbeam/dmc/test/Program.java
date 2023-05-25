package org.sunbeam.dmc.test;

import java.lang.Thread.State;

class Test
{
	@Override
	protected void finalize() throws Throwable 
	{
		Thread thread = Thread.currentThread();
		
		//System.out.println(thread.toString());//Thread[main,5,main]
		
		String name = thread.getName();
		System.out.println(name);
		
		int priority = thread.getPriority();
		System.out.println(priority);
		
		String threadGroup = thread.getThreadGroup().getName();
		System.out.println(threadGroup );
		
		State state = thread.getState();
		System.out.println(state.name());
		
		boolean threadType = thread.isDaemon();
		System.out.println(threadType ? "Daemon Thread" : "User Thread");
		
		boolean status = thread.isAlive();
		System.out.println(status ? "Alive" : "Dead");
	}
}
public class Program 
{
	public static void main(String[] args) 
	{
		Test t = new Test( );
		t = null;
		System.gc();
	}
	public static void main1(String[] args) 
	{
		Thread thread = Thread.currentThread();
		
		//System.out.println(thread.toString());//Thread[main,5,main]
		
		String name = thread.getName();
		System.out.println(name);
		
		int priority = thread.getPriority();
		System.out.println(priority);
		
		String threadGroup = thread.getThreadGroup().getName();
		System.out.println(threadGroup );
		
		State state = thread.getState();
		System.out.println(state.name());
		
		boolean threadType = thread.isDaemon();
		System.out.println(threadType ? "Daemon Thread" : "User Thread");
		
		boolean status = thread.isAlive();
		System.out.println(status ? "Alive" : "Dead");
	}
}
