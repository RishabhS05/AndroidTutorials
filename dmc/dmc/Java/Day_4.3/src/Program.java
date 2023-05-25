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
