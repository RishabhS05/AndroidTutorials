package org.sunbeam.dmc.test;
class CThread extends Thread
{
	public CThread( String name ) 
	{
		super( name );
		this.start();
	}
	@Override
	public void run() 
	{
		for( int count = 1; count <= 10; ++ count )
		{
			System.out.println("Count	:	"+count);
			if( count == 5 )
				return;
		}
	}
}
public class Program 
{
	public static void main(String[] args) throws Exception
	{
		Thread th1 = new CThread("ABC");
		
		while( true )
		{
			System.out.println(th1.getState().name());
			Thread.sleep(500);
		}
	}
}
