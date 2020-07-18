package hust.soict.globalict.test.media;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Iterator;


public class TestMediaCompareTo {

	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("dvd1", "The Lion King", "Animation", 18.99, 87, "Roger Allers");
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("dvd2", "Star War", "Science Fiction", 24.95, 124, "George Lucas");
			
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("dvd3", "Aladdin", "Animation", 19.95, 90, "John Musker");
		Collection collection = new ArrayList();
		
		//Add objects to ArrayList
		collection.add(dvd1);
		collection.add(dvd2);
		collection.add(dvd3);
		
		
		//Iterate through the ArrayList and output their titles
		//(unsorted order)
		Iterator iterator = collection.iterator();
		
		while(iterator.hasNext()) {
			DigitalVideoDisc d = ((DigitalVideoDisc)iterator.next());
			System.out.println("Playing DVD: " + d.getTitle());
			System.out.println("DVD length: " + d.getLength());
		}
		
		iterator = collection.iterator();
		int totalLength =0;
		while(iterator.hasNext()) {
			totalLength += ((DigitalVideoDisc)iterator.next()).getLength() ;
		}
		System.out.println("The total length of CD to add is: "+ totalLength);
		
		iterator = collection.iterator();
		System.out.println("-------------------------------------");
		System.out.println("The DVDs currently in the order are: ");
		
		while(iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
		}
		
		// Sort the collection of DVDs - based on the compareTo()
		java.util.Collections.sort((List)collection);
		
		//Iterate through the ArrayList and output their titles
		// in sorted order
		iterator= collection.iterator();
		
		System.out.println("-------------------------------------");
		System.out.println("The DVDs in sorted order are: ");
		
		while(iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
		}
		
		System.out.println("-------------------------------------");
	}

}
