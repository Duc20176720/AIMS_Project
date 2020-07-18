package hust.soict.globalict.test.media;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File file = new File("/home/xuanduc/Desktop/test.txt");
		System.out.println(file.length());
		System.out.println(file.getName());
		try {
			String text = "Hello";
			byte buff[] = text.getBytes();
			FileOutputStream input = new FileOutputStream(file, false);
			input.write(buff, 0, buff.length);
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
