package edu.depaul.se433.nextdate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
/*
 * These are junit tests designed to catch issues within the code. The tests
 * provided are used for all erroneous input as well as ensuring that the
 * next date function will increment or decrement properly
 */
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DateObjTest {
	@Test
	@DisplayName("Should return next day in simplest case")
	void simplestNextDate() {
		DateObj today = new DateObj(2019, 4, 14);
		DateObj tomorrow = today.nextDate();
		assertEquals(new DateObj(2019, 4, 15), tomorrow);
	}
	@Test
	@DisplayName("Should return the date incremented to the next month for 30 days")
	void simplestNextShortMonth() {
		DateObj today = new DateObj(2019, 4, 30);
		DateObj tomorrow = today.nextDate();
		assertEquals(new DateObj(2019, 5, 1), tomorrow);
	}
	@Test
	@DisplayName("Should return the date incremented to the next month for 31 days")
	void simplestNextLongMonth() {
		DateObj today = new DateObj(2019, 5, 31);
		DateObj tomorrow = today.nextDate();
		assertEquals(new DateObj(2019, 6, 1), tomorrow);
	}
	@Test
	@DisplayName("Should return next year and correct month")
	void nextYear() {
		DateObj today = new DateObj(2019, 12, 31);
		DateObj tomorrow = today.nextDate();
		assertEquals(new DateObj(2020, 1, 1), tomorrow);
	}
	@Test
	@DisplayName("Should return next day during leap year")
	void leapYear() {
		DateObj today = new DateObj(2020, 2, 28);
		DateObj tomorrow = today.nextDate();
		assertEquals(new DateObj(2020, 2, 29), tomorrow);
	}
	@Test
	@DisplayName("Should return next month during leap year")
	void leapNextMonth() {
		DateObj today = new DateObj(2020, 2, 29);
		DateObj tomorrow = today.nextDate();
		assertEquals(new DateObj(2020, 3, 1), tomorrow);
	}
	@Test
	@DisplayName("Should return next month during non leap year")
	void nonLeap() {
		DateObj today = new DateObj(2019, 2, 28);
		DateObj tomorrow = today.nextDate();
		assertEquals(new DateObj(2019, 3, 1), tomorrow);
	}
	@Test
	@DisplayName("Should return an error")
	void wrongDayUnder() {
		boolean thrown = false;
		try {
			//input is same as in today
			DateObj today = new DateObj(2019, 4, 0);
			today.currentDate();
		}
		catch(IllegalArgumentException e) {
			thrown=true;
		}
		assertTrue(thrown);
	}
	@Test
	@DisplayName("Should return an error")
	void wrongDayOver30() {
		boolean thrown=false;
		try {
			//input is same as in today
			DateObj today = new DateObj(2019, 9, 31);
			today.currentDate();
		}
		catch (IllegalArgumentException e) {
			thrown=true;
		}
		assertTrue(thrown);
	}
		@Test
	@DisplayName("Should return an error")
	void wrongDayOver31() {
		boolean thrown=false;
		try {
			//input is same as in today
			DateObj today = new DateObj(2019, 8, 32);
			today.currentDate();
		}
		catch (IllegalArgumentException e) {
			thrown=true;
		}
		assertTrue(thrown);
	}
	@Test
	@DisplayName("Should return an error")
	void wrongMonthUnder() {
		boolean thrown=false;
		try {
			//input is same as in today
			DateObj today = new DateObj(2019, 0, 14);
			today.currentDate();
		}
		catch(IllegalArgumentException e) {
			thrown=true;
		}
		assertTrue(thrown);
	}
	@Test
	@DisplayName("Should return an error")
	void wrongMonthOver() {
		boolean thrown=false;
		try {
			//input is same as in today
			DateObj today = new DateObj(2019, 13, 0);
			today.currentDate();
		}
		catch(IllegalArgumentException e) {
			thrown=true;
		}
		assertTrue(thrown);
	}
	@Test
	@DisplayName("Should return an error")
	void wrongYearUnder() {
		boolean thrown=false;
		try {
			//input is same as in today
			DateObj today = new DateObj(-1, 4, 1);
			today.currentDate();
		}
		catch(IllegalArgumentException e) {
			thrown=true;
		}
		assertTrue(thrown);
	}

	@Test
	@DisplayName("Should return an error")
	void febTest() {
		boolean thrown=false;
		try {
			DateObj today= new DateObj(2019,2,29);
			//input is same as today
			today.currentDate();
		}
		catch(IllegalArgumentException e) {
			thrown=true;
		}
		assertTrue(thrown);
	}
	@Test
	@DisplayName("Should return an error")
	void febLeapTest() {
		boolean thrown=false;
		try {
			DateObj today= new DateObj(4,2,30);
			//input is same as today
			today.currentDate();
		}
		catch(IllegalArgumentException e) {
			thrown=true;
		}
		assertTrue(thrown);
	}
}
