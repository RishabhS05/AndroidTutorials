import java.util.Scanner;
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
