package org.sunbeam.dmc;

public class Program 
{
	/*public static void print()
	{
		try
		{
			for( int count = 1; count <= 10; ++ count )
			{
				System.out.println("Count	:	"+count);
				Thread.sleep(1000);
			}
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}*/
	public static void print() throws InterruptedException
	{
		for( int count = 1; count <= 10; ++ count )
		{
			System.out.println("Count	:	"+count);
			Thread.sleep(1000);
		}
	}
	public static void main(String[] args) 
	{
		try {
			Program.print();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
