package hust.soict.globalict.aims.utils;
import java.util.Scanner;
public class DateUtils {
	public void compareDate() {
		System.out.println("Enter the date following form a string(Ferbruary 09th 2020)");
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the first date:");
		String date1 = keyboard.nextLine();
		System.out.println("Enter the second date:");
		String date2 = keyboard.nextLine();
		Accept test = new Accept();
		MyDate Date1 = test.accept(date1);
		MyDate Date2 = test.accept(date2);
		if(Date1.getYear()<Date2.getYear())
			System.out.println("The date "+ date1+ " before "+ date2);
		else if(Date1.getYear()>Date2.getYear())
			System.out.println("The date "+ date1+ " after "+ date2);
		else {
			if(Date1.getMonth()<Date2.getMonth())
				System.out.println("The date "+ date1+ " before "+ date2);
			else if(Date1.getMonth()>Date2.getMonth())
				System.out.println("The date "+ date1+ " after "+ date2);
			else {
				if(Date1.getDay()<Date2.getDay())
					System.out.println("The date "+ date1+ " before "+ date2);
				else if(Date1.getDay()>Date2.getDay())
					System.out.println("The date "+ date1+ " after "+ date2);
			}
		}
	}	
}
