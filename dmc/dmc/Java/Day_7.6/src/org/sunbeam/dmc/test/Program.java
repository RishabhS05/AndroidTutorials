package org.sunbeam.dmc.test;
class Box<T extends Number > //T extends Number --> Bounded Type Parameter
{
	private T object;
	public T getObject() {
		return object;
	}
	public void setObject(T object) {
		this.object = object;
	}
}
public class Program 
{
	public static void main(String[] args) 
	{	
		Box<Number> b1 = new Box<>();		//OK
		
		Box<Integer> b2 = new Box<>();		//Ok
		
		Box<Double> b3 = new Box<>();		//Ok
		
		Box<String> b4 = new Box<>();		//Not Ok
		
		Box<Character> b5 = new Box<>();	//Not Ok
		
	}
}
