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
