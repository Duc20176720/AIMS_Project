package hust.soict.globalict.test.media;

import java.util.Scanner;

import hust.soict.globalict.aims.media.Book;

public class BookTest {

	public static void main(String[] args) {
		Book book = new Book("a", "hello", "world", 12.34);
		System.out.println(book);
		System.out.println("Enter the content of book: ");
		Scanner keyboard = new Scanner(System.in);
		String content = keyboard.nextLine();
		book.setContent(content);
		book.processContent();
	}
}
