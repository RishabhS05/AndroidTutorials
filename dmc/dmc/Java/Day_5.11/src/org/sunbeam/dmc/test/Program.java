package org.sunbeam.dmc.test;

enum Day
{
	SUN("SunDay"),MON(2,"MonDay");
	private String dayName;
	private int dayNumber;
	private Day( String dayName )
	{
		this.dayName = dayName;
	}
	private Day( int dayNumber, String dayName )
	{
		this.dayNumber = dayNumber;
		this.dayName = dayName;
	}
	public int getDayNumber() {
		return dayNumber;
	}
	public String getDayName() {
		return dayName;
	}
}
public class Program 
{
	public static void main(String[] args) 
	{
		Day day = Day.SUN;
		
		System.out.println("Name	:	"+day.name());
		System.out.println("Ordinal	:	"+day.ordinal());
		System.out.println("Day Name	:	"+day.getDayName());
		System.out.println("Day Number	:	"+day.getDayNumber());
	}
}
