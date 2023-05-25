package org.sunbeam.dmc.test;

class Node
{
	int data;
	Node next;
	public Node( int data )
	{
		this.data = data;
		this.next = null;
	}
}
class List
{
	private Node head = null;
	private Node tail = null;
	public boolean empty()
	{
		return this.head == null;
	}
	public void addLast( int element )
	{
		Node newNode = new Node(element);
		if( this.empty() )
		{
			this.head = newNode;
			this.tail = newNode;
		}
		else
		{
			this.tail.next = newNode;
			this.tail = newNode;
		}
	}
	public void printList()
	{
		if( !this.empty())
		{
			Node trav = this.head;
			while( trav != null )
			{
				System.out.print(trav.data+" ");
				trav = trav.next;
			}
		}
	}
}
public class Program 
{
	public static void main(String[] args) 
	{
		List list = new List();
		list.addLast( 10 );
		list.addLast( 20 );
		list.addLast( 30 );
		
		list.printList();
	}
}
