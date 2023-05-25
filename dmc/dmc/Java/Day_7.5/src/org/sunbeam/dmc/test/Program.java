package org.sunbeam.dmc.test;

class HashTable<K,V>
{
	private K key;
	private V value;
	public HashTable() 
	{	}
	public HashTable(K key, V value) 
	{
		this.key = key;
		this.value = value;
	}
	public K getKey() 
	{
		return key;
	}
	public V getValue() {
		
		return value;
	}
}
public class Program 
{
	public static void main(String[] args) 
	{
		HashTable<Integer,String> ht = new HashTable< >(1,"DMC");
		int key = ht.getKey();
		String value = ht.getValue();
		System.out.println(key+"	"+value);
	}
}
