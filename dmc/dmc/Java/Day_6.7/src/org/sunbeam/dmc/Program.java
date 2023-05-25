package org.sunbeam.dmc;

import java.util.Scanner;

class StackUnderflowException extends Exception
{
	public StackUnderflowException() 
	{
		super();
	}
	public StackUnderflowException(String message) 
	{
		super(message);
	}
}
class StackOverflowException extends Exception
{
	public StackOverflowException() 
	{
		super();
	}
	public StackOverflowException(String message) 
	{
		super(message);
	}
}
class Stack
{
	private int top;
	private int[] arr;
	public Stack( )
	{
		this( 5 );
	}
	public Stack( int size )
	{
		this.top = -1;
		this.arr = new int[ size ]; 
	}
	public boolean empty()
	{
		return this.top == -1;
	}
	public boolean full()
	{
		return this.top == this.arr.length - 1;
	}
	public void push( int element ) throws StackOverflowException
	{
		if( this.full())
			throw new StackOverflowException("Stack is full");
		this.arr[ ++ this.top ] = element;
	}
	public int peek() throws StackUnderflowException
	{
		if( this.empty())
			throw new StackUnderflowException("Stack is empty");
		return this.arr[ this.top ];
	}
	public void pop() throws StackUnderflowException
	{
		if( this.empty())
			throw new StackUnderflowException("Stack is empty");
		-- this.top;
	}
}
public class Program 
{
	static Scanner sc = new Scanner(System.in);
	public static int menuList()
	{
		System.out.println("0.Exit");
		System.out.println("1.Push");
		System.out.println("2.Pop");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
	public static void main(String[] args) 
	{
		int choice,element;
		Stack stack = new Stack();
		while( ( choice = Program.menuList( ) ) != 0 )
		{
			try 
			{
				switch( choice )
				{
				case 1:
					System.out.print("Enter element	:	");
					stack.push(sc.nextInt());
					break;
				case 2:
					element = stack.peek();
					System.out.println("Removed element is	:	"+element);
					stack.pop();
					break;
				}
			} 
			catch (StackOverflowException | StackUnderflowException e) 
			{
				System.out.println(e.getMessage());
			}
		}
	}
}
