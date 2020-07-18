package hust.soict.globalict.aims.utils;

public class MyDate {
	private int day;
	private int month;
	private int year;
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public MyDate(int day, int month) {
		if(day < 1 || day > 31) {
			System.out.println("The day is invalid.");
		} else if(month < 1 || month > 12) {
			System.out.println("The month is invalid.");
		}else {
			this.day = day;
			this.month = month;
		}
	}
	
	public MyDate(int day, int month, int year) {
		if(day < 1 || day > 31) {
			System.out.println("The day is invalid.");
		} else if(month < 1 || month > 12) {
			System.out.println("The month is invalid.");
		}else {
			this.day = day;
			this.month = month;
			this.year = year;
		}
	}
	
	public static int CheckMonth(String s) {
		if(s.equals("January") == true) return 1;
		else if(s.equals("February") == true) return 2;
		else if(s.equals("March") == true) return 3;
		else if(s.equals("April") == true) return 4;
		else if(s.equals("May") == true) return 5;
		else if(s.equals("June") == true) return 6;
		else if(s.equals("July") == true) return 7;
		else if(s.equals("August") == true) return 8;
		else if(s.equals("September") == true) return 9;
		else if(s.equals("October") == true) return 10;
		else if(s.equals("November") == true) return 11;
		else if(s.equals("December") == true) return 12;
		return 0;
	}
	
	public static int CheckDay(String s) {
		if(s.equals("first") == true) return 1;
		else if(s.equals("second") == true) return 2;
		else if(s.equals("third") == true) return 3;
		else if(s.equals("fourth") == true) return 4;
		else if(s.equals("fifth") == true) return 5;
		else if(s.equals("sixth") == true) return 6;
		else if(s.equals("seventh") == true) return 7;
		else if(s.equals("eighth") == true) return 8;
		else if(s.equals("ninth") == true) return 9;
		else if(s.equals("tenth") == true) return 10;
		else if(s.equals("eleventh") == true) return 11;
		else if(s.equals("twelfth") == true) return 12;
		else if(s.equals("thirteenth") == true) return 13;
		else if(s.equals("fourteenth") == true) return 14;
		else if(s.equals("fifteenth") == true) return 15;
		else if(s.equals("sixteenth") == true) return 16;
		else if(s.equals("seventeenth") == true) return 17;
		else if(s.equals("eighteenth") == true) return 18;
		else if(s.equals("nineteenth") == true) return 19;
		else if(s.equals("twentieth") == true) return 20;
		else if(s.equals("twenty-first") == true) return 21;
		else if(s.equals("twenty-second") == true) return 22;
		else if(s.equals("twenty-third") == true) return 23;
		else if(s.equals("twenty-fourth") == true) return 24;
		else if(s.equals("twenty-fifth") == true) return 25;
		else if(s.equals("twenty-sixth") == true) return 26;
		else if(s.equals("twenty-seventh") == true) return 27;
		else if(s.equals("twenty-eighth") == true) return 28;
		else if(s.equals("twenty-ninth") == true) return 29;
		else if(s.equals("thirtieth") == true) return 30;
		else if(s.equals("thirty-first") == true) return 31;
		else if(s.equals("thirty-second") == true) return 32;
		return 0;
	}
	
	public MyDate(String day, String month, int year) {
		int month_int;
		int day_int;
		month_int = CheckMonth(month);
		day_int = CheckDay(day);
		if(day_int < 1 || day_int > 31) {
			System.out.println("The day is invalid.");
		} else if(month_int < 1 || month_int > 12) {
			System.out.println("The month is invalid.");
		}else {
			this.day = day_int;
			this.month = month_int;
		}
		this.year =year;
	}
}