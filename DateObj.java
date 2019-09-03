package edu.depaul.se433.nextdate;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner; 
/*
 * Assignment 3
 * Topic: Junit Testing
 * Author: Donald Ulfig
 * */
/*
 * This is a class that will identify the next date based off the given input
 * the program is designed to handle improper dates and error out accordingly
 * if they are dates outside the given bounds.
 * The program will also detect if the year is considered a leap year or not
 */
public class DateObj {
	private boolean longMonths[]= {true,false,true,false,true,false,true,true,false,true,false,true};
	private boolean shortMonths[]= {false,false,false,true,false,true,false,false,true,false,true,false};
	private int year;
	private int month;
	private int day;
	
	public DateObj(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public DateObj nextDate() {
		if(month==12&&day==31)
			return new DateObj(year+1, month-11,day-30);
		else if(longMonths[month-1]&& day==31)
			return new DateObj(year,month+1,day-30);
		else if(shortMonths[month-1]&& day==30)
			return new DateObj(year,month+1,day-29);
		else if(isLeapYear()&&day==29&&month==2)
			return new DateObj(year,month+1,day-28);
		else if(isLeapYear()&&day==28&&month==2)
			return new DateObj(year,month,day+1);
		else if(month==2&&day==28)
			return new DateObj(year,month+1,day-27);
		else
			return new DateObj(year, month, day + 1);
	}
	
	public boolean isLeapYear() {
		if(year%4==0||year%400==0)
			return true;
		else return false;
	}
	
	public Date asDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, day);
		Date date = cal.getTime();
		return date;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		if (! (other instanceof DateObj)) {
			return false;
		}
		DateObj otherDate = (DateObj) other;
		
		return (otherDate.year == year) && (otherDate.month == month) && (otherDate.day == day);
		
	}
	
	@Override
	public String toString() {
		return String.format("Date[year: %d, month: %d, day: %d]", year, month, day);
	}
	
	public void currentDate() {
		if(month>12||month<1) {
			throw new IllegalArgumentException("Not a valid month");
		}
		if(year<=0){
			throw new IllegalArgumentException("Not a valid year");
		}
		if(shortMonths[month-1]&&day>30||day<1) {
			throw new IllegalArgumentException("Not a valid day");
		}
		if(longMonths[month-1]&&day>31) {
			throw new IllegalArgumentException("Not a valid day");
		}
		if(isLeapYear()&&month==2&&day>29) {
			throw new IllegalArgumentException("Not a valid day");
		}
		if(month==2&&day>28) {
			throw new IllegalArgumentException("Not a valid day");
		}
	}

}
