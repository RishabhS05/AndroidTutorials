import java.util.Scanner;
class Complex
{
	private int real;
	private int imag;
	public Complex( )
	{
		this(10,20);	//Ctor Chaining
	}
	public Complex( int real, int imag )
	{
		this.real = real;
		this.imag = imag;
	}
	public void acceptRecord( )
	{
		Scanner sc = new Scanner( System.in );
		System.out.print("Real Number	:	");
		this.real = sc.nextInt();
		System.out.print("Imag Number	:	");
		this.imag = sc.nextInt();
	}
	public void printRecord( )
	{
		System.out.println("Real Number	:	"+this.real);
		System.out.println("Imag Number	:	"+this.imag);
	}
}
class Program
{
	public static void main( String[] args )
	{
		Complex c1 = null;
		c1 = new Complex();
		c1.printRecord( );
	}
	public static void main2( String[] args )
	{
		Complex c1 = new Complex();
		c1.printRecord();
	}
	public static void main1( String[] args )
	{
		Complex c1 = new Complex();
		c1.acceptRecord( );	//Message Passing
		c1.printRecord( );	//Message Passing
	}
}
