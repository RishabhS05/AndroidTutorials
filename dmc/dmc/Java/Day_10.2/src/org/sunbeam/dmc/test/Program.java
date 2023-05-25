package org.sunbeam.dmc.test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

class Account implements Comparable<Account>
{
	private int accountNumber;
	private String accountType;
	private float balance;
	public Account() 
	{	}
	public Account(int accountNumber, String accountType, float balance) 
	{
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	@Override
	public int compareTo(Account other )
	{
		return this.accountNumber - other.accountNumber;
	}
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNumber;
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNumber != other.accountNumber)
			return false;
		return true;
	}
	@Override
	public String toString() 
	{
		return String.format("%-10d%-10s%-10.2f", this.accountNumber, this.accountType, this.balance);
	}
}
class Customer
{
	private String name;
	private String address;
	private String contactNumber;
	public Customer() 
	{	}
	public Customer(String name, String address, String contactNumber) 
	{
		this.name = name;
		this.address = address;
		this.contactNumber = contactNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	@Override
	public String toString() 
	{
		return String.format("%-20s%-15s%-15s", this.name, this.address, this.contactNumber);
	}
}
class MapTest
{
	private Map<Account, Customer> map;
	public void setMap(Map<Account, Customer> map) 
	{
		this.map = map;
	}
	public void addRecord(Account[] accounts, Customer[] customers)
	{
		if( this.map != null )
		{
			for( int index = 0 ; index < accounts.length; ++ index )
				this.map.put(accounts[ index ], customers[ index ] );
		}
	}
	public void printRecord()
	{
		if( this.map != null )
		{
			Set<Entry<Account, Customer>> entries = this.map.entrySet();
			for (Entry<Account, Customer> entry : entries) 
			{
				Account key = entry.getKey();
				Customer value = entry.getValue();
				System.out.println(key+" "+value);
			}
		}
	}
	public Customer findRecord(int accountNumber ) 
	{
		if( this.map != null )
		{
			Account key = new Account();
			key.setAccountNumber(accountNumber);
			if( this.map.containsKey(key))
				return this.map.get(key);
		}
		return null;
	}
	public boolean removeRecord(int accountNumber )
	{
		if( this.map != null )
		{
			Account key = new Account();
			key.setAccountNumber(accountNumber);
			if( this.map.containsKey(key))
			{
				this.map.remove(key);
				return true;
			}
		}
		return false;
	}
}
public class Program 
{
	public static Scanner sc = new Scanner(System.in);
	public static Account[] getAccounts()
	{
		Account[] arr = new Account[ 5 ];
		arr[ 0 ] = new Account(11023,"Saving",85000);
		arr[ 1 ] = new Account(51234,"Current",60000);
		arr[ 2 ] = new Account(24135,"Loan",90000);
		arr[ 3 ] = new Account(19724,"Joint",75000);
		arr[ 4 ] = new Account(87145,"Pention",45000);
		return arr;
	}
	public static Customer[] getCustomers()
	{
		Customer[] arr = new Customer[ 5 ];
		arr[ 0 ] = new Customer("Sarang Patil","Karad","11111");
		arr[ 1 ] = new Customer("Nitin Kudhale","Panchgani","22222");
		arr[ 2 ] = new Customer("Prashant Lad","Karad","33333");
		arr[ 3 ] = new Customer("Sanjay Chaudhari","Nagpur","44444");
		arr[ 4 ] = new Customer("Rahul Kale","Pune","55555");
		return arr;	
	}
	public static int menuList()
	{
		System.out.println("0.Exit");
		System.out.println("1.Add Record");
		System.out.println("2.Find Record");
		System.out.println("3.Remove Record");
		System.out.println("4.Print Record");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
	public static void acceptRecord( int[] accountNumber )
	{
		System.out.print("Enter account number	:	");
		accountNumber[ 0 ] = sc.nextInt();
	}
	private static void printRecord(Customer value) 
	{
		if( value != null )
			System.out.println(value.toString());
		else
			System.out.println("Record not found");
	}
	private static void printRecord(boolean removedStatus)
	{
		System.out.println(removedStatus ? "Record removed" : "Record not removed");
	}
	public static void main(String[] args) 
	{
		int choice;
		int[] accountNumber = new int[ 1 ];
		MapTest test = new MapTest();
		//test.setMap(new Hashtable<Account, Customer>());
		//test.setMap(new HashMap<Account, Customer>());
		//test.setMap(new LinkedHashMap<Account, Customer>());
		test.setMap(new TreeMap<Account, Customer>());
		while( ( choice = Program.menuList( ) ) != 0 )
		{
			switch( choice )
			{
			case 1:
				test.addRecord( Program.getAccounts(), Program.getCustomers());
				break;
			case 2:
				Program.acceptRecord(accountNumber);
				Customer value =  test.findRecord( accountNumber[ 0 ] );
				Program.printRecord( value );
				break;
			case 3:
				Program.acceptRecord(accountNumber);
				boolean removedStatus = test.removeRecord( accountNumber[ 0 ] );
				Program.printRecord(removedStatus);
				break;
			case 4:
				test.printRecord( );
				break;
			}
		}
	}
}
