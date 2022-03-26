package by.bobruisk.zhelnov.myproject.mavenproject1;

import by.bobruisk.zhelnov.myproject.mavenproject1.Exceptions.IncorrectNumberException;

public class BirthDate {
	private int day;
	private int month;
	private int year;

	public BirthDate(int day, int month, int year) throws IncorrectNumberException  {
		setDay(day);
		setMonth(month);
		setYear(year);
	}

	public BirthDate(int year) throws IncorrectNumberException{
		setDay(1);
		setMonth(1);
		setYear(year);
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) throws IncorrectNumberException {
            if(day>0&&day<32){
                this.day = day;
            } else{
                throw new IncorrectNumberException("The number must be between 1 and 31. You passed: ",day);
            }
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) throws IncorrectNumberException {
            if(month>0&&month<13){
                this.month = month;
            }
                else{
                    throw new IncorrectNumberException("The number must be between 1 and 12. You passed: ",month);
            }                
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) throws IncorrectNumberException {
		            if(year>=1900&&year<=2100){
                this.year = year;
            }
                else{
                    throw new IncorrectNumberException("The number must be between 1900 and 2100. You passed: ",year);
            } 

	}

	@Override
	public String toString() {
		return day + "." + month + "." + year;
	}

}
