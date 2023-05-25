package org.sunbeam.dmc.test;

class CThread implements Runnable
{
	private Thread thread;
	public CThread() 
	{
		this("");
	}
	public CThread( String name ) 
	{
		this.thread = new Thread(this);
		this.thread.setName(name);
		this.thread.start();
	}
	@Override
	public void run() 
	{
		//TODO : B.L.
	}
}
public class Program 
{
	public static void main(String[] args) 
	{
		Runnable target1 = new CThread("ABC");
	}
}
