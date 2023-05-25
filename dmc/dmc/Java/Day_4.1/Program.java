import java.util.Scanner;
class Complex
{
	private int real;
	private int imag;
	public Complex( )
	{
		this( 0, 0 );	//ctor chaining
	}
	public Complex( int real, int imag )
	{
		this.real = real;
		this.imag = imag;
	}
	public int getReal()
	{
		return this.real;
	}
	public void setReal( int real )
	{
		this.real = real;
	}
	public int getImag()
	{
		return this.imag;
	}
	public void setImag( int imag )
	{
		this.imag = imag;
	}
}
class ComplexTest
{
	static Scanner sc = new Scanner( System.in );
	private Complex c1 = new Complex( );
	public void acceptRecord( )
	{
		System.out.print("Real Number	:	");
		c1.setReal( sc.nextInt( ) );
		System.out.print("Imag Number	:	");
		c1.setImag( sc.nextInt() );
	}
	public void printRecord()
	{
		int real = c1.getReal();
		System.out.println("Real Number	:	"+real);
		int imag = c1.getImag();
		System.out.println("Imag Number	:	"+imag);
	}
	public static int menuList( )
	{
		System.out.println("0.Exit");
		System.out.println("1.Accept Record");
		System.out.println("2.Print Record");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
}
class Program
{
	public static void main( String[] args )
	{
		if( true )
			System.out.println("If");
		else
			System.out.println("Else");

		int choice;
		ComplexTest test = new ComplexTest();
		while( ( choice = ComplexTest.menuList( ) ) != 0 )
		{
			switch( choice )
			{
			case 1:
				test.acceptRecord();
				break;
			case 2:
				test.printRecord();
				break;
			}
		}
	}
}
