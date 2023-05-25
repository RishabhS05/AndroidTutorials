package org.sunbeam.dmc.test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class Program 
{
	public static void main1(String[] args) 
	{
		Calendar c = Calendar.getInstance();
		int day = c.get( Calendar.DATE);
		int month = c.get(Calendar.MONTH) + 1;
		int year = c.get(Calendar.YEAR);
		System.out.println(day+" / "+month+" / "+year);
	}
	public static void main2(String[] args) 
	{
		Calendar c = Calendar.getInstance();
		int hour = c.get( Calendar.HOUR);
		int minute = c.get(Calendar.MINUTE );
		int second = c.get(Calendar.SECOND);
		System.out.println(hour+" : "+minute+" : "+second);
	}
	public static void main3(String[] args) 
	{
		LocalDateTime ldt = LocalDateTime.now();
		int day = ldt.getDayOfMonth();
		int month = ldt.getMonthValue();
		int year = ldt.getYear();
		System.out.println(day+" / "+month+" / "+year);
	}
	public static void main4(String[] args) 
	{
		LocalDateTime ldt = LocalDateTime.now();
		int hour = ldt.getHour();
		int minute = ldt.getMinute();
		int second = ldt.getSecond();
		System.out.println(hour+" : "+minute+" : "+second);	
	}
	public static void main(String[] args) 
	{
		Date dt = new Date( 119, 2, 18 );
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		String strDate =  sdf.format(dt);
		System.out.println(strDate);
	}
}
