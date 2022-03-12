package by.bobruisk.zhelnov.myproject.mavenproject1;

import by.bobruisk.zhelnov.myproject.mavenproject1.Exeptions.IncorrectNumberException;

public class BirthDate {
	private int day;
	private int month;
	private int year;

	public BirthDate(int day, int month, int year) {
		setDay(day);
		setMonth(month);
		setYear(year);
	}

	public BirthDate(int year) {
		setDay(1);
		setMonth(1);
		setYear(year);
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if (day >= 1 && day <= 31) {
			this.day = day;
		} else {
			throw new IncorrectNumberException("Only numbers from 1 to 31", day);
		}
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if (month >= 1 && month <= 12) {
			this.month = month;
		} else {
			throw new IncorrectNumberException("Only numbers from 1 to 12", month);
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (year >= 1900 && year <= 2100) {
			this.year = year;
		} else {
			throw new IncorrectNumberException("Only numbers from 1900 to 2100", year);
		}
	}

	@Override
	public String toString() {
		return day + "." + month + "." + year;
	}

}
