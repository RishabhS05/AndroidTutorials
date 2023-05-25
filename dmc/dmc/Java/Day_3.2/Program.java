class Program
{
	public static void main( String[] args )
	{
		String str = "abc";
		int number = Integer.parseInt( str );
	}
	public static void main2( String[] args )
	{
		String str = "125";
		int number = Integer.parseInt( str );	//UnBoxing
		System.out.println("Number	:	"+number);
	}
	public static void main1( String[] args )
	{
		int number = 10;
		//String str = Integer.toString( number );	//Boxing
		String str = String.valueOf( number );	//Boxing
		System.out.println("Number	:	"+str);
	}
}
