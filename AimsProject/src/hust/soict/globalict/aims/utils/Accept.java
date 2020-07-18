package hust.soict.globalict.aims.utils;

import java.util.Scanner;
public class Accept {
	
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
		else
		return 0;
	}
	
	public static String CheckMonth_a(String s) {
		if(s.equals("January") == true) return "Jan";
		else if(s.equals("February") == true) return "Feb";
		else if(s.equals("March") == true) return "Mar";
		else if(s.equals("April") == true) return "Apr";
		else if(s.equals("May") == true) return "May";
		else if(s.equals("June") == true) return "Jun";
		else if(s.equals("July") == true) return "Jul";
		else if(s.equals("August") == true) return "Aug";
		else if(s.equals("September") == true) return "Sep";
		else if(s.equals("October") == true) return "Oct";
		else if(s.equals("November") == true) return "Nov";
		else if(s.equals("December") == true) return "Dec";
		else
		return "error";
	}
	
	public static String CheckDay_a(int s) {
		if(s == 1) return "01";
		if(s == 2) return "02";
		if(s == 3) return "03";
		if(s == 4) return "04";
		if(s == 5) return "05";
		if(s == 6) return "06";
		if(s == 7) return "07";
		if(s == 8) return "08";
		if(s == 9) return "09";
		else return "error";
	}
	
	public MyDate accept(String date) {
		String words[] = date.split("\\s");
		int month = CheckMonth(words[0]);
		int day = Integer.parseInt(words[1].substring(0,2));
		int year = Integer.parseInt(words[2]);
		MyDate mydate = new MyDate(day, month);
		mydate.setYear(year);
		return mydate;
	}
	
	public void accept_a() {
		String day;
		String month;
		int year;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the day:");
		day = keyboard.nextLine();
		System.out.println("Enter the month: ");
		month = keyboard.nextLine();
		System.out.println("Enter the year: ");
		year = keyboard.nextInt();
		MyDate s = new MyDate(day, month, year);
		System.out.println("Your date(d/M/yyyy): "+ s.getDay()+"/"+s.getMonth()+"/"+s.getYear());
		System.out.println("Your date(MMM d yyyy): "+ CheckMonth_a(month)+" "+ s.getDay()+" "+s.getYear());
		if(s.getDay() < 10) {
			System.out.println("Your date(yyyy-MM-dd): "+ s.getYear()+"-"+ CheckDay_a(s.getMonth())+"-"+CheckDay_a(s.getDay()));
		}else {
			System.out.println("Your date(yyyy-MM-dd): "+ s.getYear()+"-"+s.getMonth()+"-"+s.getDay());
		}
		if(s.getDay() < 10) {
			System.out.println("Your date(mm-dd-yyyy): "+ CheckDay_a(s.getMonth())+"-"+CheckDay_a(s.getDay())+"-"+s.getYear());
		}else {
			System.out.println("Your date(mm-dd-yyyy): "+ s.getMonth()+"-"+s.getDay()+"-"+s.getYear());
		}
		if(s.getDay() < 10) {
			System.out.println("Your date(dd-MMM-yyyy): "+CheckDay_a(s.getDay())+"-"+ CheckMonth_a(month)+"-"+s.getYear());
		}else {
			System.out.println("Your date(mm-dd-yyyy): "+ s.getDay()+"-"+CheckMonth_a(month)+"-"+s.getYear());
		}
		
	}
	
	public void printDate(MyDate s) {
		System.out.print("Date: "+s.getDay()+"/"+s.getMonth()+"/"+s.getYear());
		System.out.println();
	}
}
