package org.sunbeam.dmc.test;

import java.util.Iterator;
import java.util.LinkedList;

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
class List implements Iterable<Integer>
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
	@Override
	public Iterator<Integer> iterator() 
	{
		Iterator<Integer> itr = new ListIterator( this.head );
		return itr;
	}
}
class ListIterator implements Iterator<Integer>
{
	Node node;
	public ListIterator( Node node )
	{
		this.node = node;
	}
	@Override
	public boolean hasNext()
	{
		if( this.node != null )
			return true;
		return false;
	}
	@Override
	public Integer next() 
	{
		int element = this.node.data;
		this.node = this.node.next;
		return element;
	}
}
public class Program 
{
	public static void main(String[] args)
	{
		List list = new List();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		
		for( int element : list )
			System.out.println(element);
	}
	public static void main1(String[] args) 
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		
		
		for( int element : list )
			System.out.println(element);
		
		//eqivalent to
		
		Iterator<Integer> itr = list.iterator();
		while( itr.hasNext())
		{
			int element = itr.next();
			System.out.println(element);
		}
		
	}
}
