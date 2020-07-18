package hust.soict.globalict.aims;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.order.Order;

import java.util.*;

public class Aims {
	
	public static void showMenu() {
		System.out.println("===================================");
		System.out.println("Order Management Application: ");
		System.out.println("--------------------------------");
		System.out.println("1. Create new order");
		System.out.println("2. Add item to the order");
		System.out.println("3. Delete item by id");
		System.out.println("4. Display the items list of order");
		System.out.println("5. List DVD of store:");
		System.out.println("6. List CD of store: ");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		System.out.println("===================================");
		}

	public static void main(String[] args) {
		
		//Thread in java: memory used
		MemoryDaemon md = new MemoryDaemon();
		Thread th = new Thread(md);
		th.start();
		
		//aims
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("dvd1", "The Lion King", "Animation", 19.95, -2, "Roger Allers");
			
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("dvd2", "Star War", "Science Fiction", 24.95, 124, "George Lucas");
			
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("dvd3", "Aladdin", "Animation", 18.99, 90, "John Musker");
		
		Book b1 = new Book("b1", "Harry Potter","J.K. Rowling", 12.3);
		b1.addAuthor("a");
		b1.addAuthor("b");
		b1.addAuthor("c");
		
		Book b2 = new Book("b2", "The Lightning Thief", "Rick Riordan", 23.4);
		b2.addAuthor("e");
		b2.addAuthor("d");
		b2.addAuthor("f");
		
		Book b3 = new Book("b3", "Twilight", "Stephenie Meyer", 34.5);
		b3.addAuthor("g");
		b3.addAuthor("h");
		b3.addAuthor("j");
		
		CompactDisc cd1 = new CompactDisc("cd1", "a", "a", 14.3, "a", "a");
		CompactDisc cd2 = new CompactDisc("cd2", "b", "b", 10.8, "b", "b");
		CompactDisc cd3 = new CompactDisc("cd3", "c", "c", 13.1, "c", "c");
		List<CompactDisc> listCD = new ArrayList<CompactDisc>();
		listCD.add(cd1);
		listCD.add(cd2);
		listCD.add(cd3);
		
		Track tr1 = new Track("first", 17);
		Track tr2 = new Track("second", 12);
		Track tr3 = new Track("third", 15);
		
		List<Media> listMedia = new ArrayList<Media>();
		listMedia.add(dvd1);
		listMedia.add(dvd2);
		listMedia.add(dvd3);
		listMedia.add(b1);
		listMedia.add(b2);
		listMedia.add(b3);
		listMedia.add(cd1);
		listMedia.add(cd2);
		listMedia.add(cd3);
//		java.util.Collections.sort((List)listMedia);
//		Iterator iterator = listMedia.iterator();
//		
//		while(iterator.hasNext()) {
//			System.out.println(((Media)iterator.next()).getTitle());
//		}
		
		
		List<String> listID = new ArrayList<String>();
		for (Media m:listMedia) {
			listID.add(m.getId());
		}
		
		List<Track> listTrack = new ArrayList<Track>();
		listTrack.add(tr1);
		listTrack.add(tr2);
		listTrack.add(tr3);
		
		
		Order order = new Order();
		Scanner keyboard = new Scanner(System.in);
		int check_out =0;
		do {
			showMenu();
			int temp = keyboard.nextInt();
			switch(temp) {
			case 1:
				int x=0;
				System.out.println("List of media with id:");
				for(Media m: listMedia ) {
					System.out.println(m.getId()+" - "+ m.getTitle());
				}
				System.out.println("How many items do you order:");
				int numItems = keyboard.nextInt();
				keyboard.nextLine();
				List<String> listOrder = new ArrayList<String>();
				System.out.println("Enter your selection (using id):");
				for(int i= 0; i< numItems; i++) {
					System.out.println("Item "+ (i+1)+":");
					String s = keyboard.nextLine();
					listOrder.add(s);
				}
				for (String s:listOrder) {
					if(listID.contains(s)==false) {
						x=1;
					}
				}
				if(x==1)
					System.out.println("Selection error!");
				else {
					for(int i = 0; i < numItems; i++) {
						for(CompactDisc c : listCD) {
							if(listOrder.get(i).equals(c.getId()) == true) {
								for(Track t : listTrack) {
									System.out.println("Track : " + t.getTitle() + " - " + t.getLength());
								}
								System.out.println("How many track do you want add for "+ listOrder.get(i)+ ": ");
								int count = keyboard.nextInt();
								keyboard.nextLine();
								for(int j =0; j < count; j++) {
									System.out.println("Enter the track that you want for "+ listOrder.get(i) +" (using title): ");
									String s = keyboard.nextLine();
									for(Track t : listTrack) {
										if(t.getTitle().equals(s) == true)
											c.addTrack(t);
									}
								}
							}
						}
					}
					for (Media m:listMedia) {
						for(int i=0;i< numItems; i++) {
							if(m.getId().equals(listOrder.get(i))==true) {
								order.addMedia(m);
							}
						}
					}
					System.out.println("Order successfully:");
					for (int i=0; i < numItems; i++) {
						System.out.print(listOrder.get(i)+ ", ");
					}
					System.out.println();
				}
				break;
			case 2:
				int y=0;
				keyboard.nextLine();
				System.out.println("Enter the item that you want add(using id):");
				String idAdd = keyboard.nextLine();
				for(String s :listID) {
					if(listID.contains(idAdd)==false)
					y=1;
				}
				if (y==1) {
					//System.out.println(idAdd);
					System.out.println("Selection error!");
					}
				else {
					for(CompactDisc c : listCD) {
						if(c.getId().equals(idAdd) == true) {
							for(Track t : listTrack) {
								System.out.println("Track : " + t.getTitle() + " - " + t.getLength());
							}
							System.out.println("How many track do you want add for "+ idAdd +": ");
							int count = keyboard.nextInt();
							keyboard.nextLine();
							for(int j = 0; j < count; j++) {
								System.out.println("Enter the track that you want for "+ idAdd +" (using title): ");
								String s = keyboard.nextLine();
								for(Track t : listTrack) {
									if(t.getTitle().contains(s) == true)
										c.addTrack(t);
								}
							}
						}
					}
					for(Media m : listMedia) {
						if(m.getId().equals(idAdd) == true) {
							order.addMedia(m);
						}
					}
					System.out.println("Add successfully item with id "+ idAdd);
				}
				break;
			case 3:
				int z=0;
				keyboard.nextLine();
				System.out.println("Enter the item that you want remove(using id):");
				String idRemove = keyboard.nextLine();
				for(String s :listID) {
					if(listID.contains(idRemove)==false)
					z=1;
				}
				if (z==1)
					System.out.println("Selection error!");
				else {
					for(Media m : listMedia) {
						if(m.getId().equals(idRemove) == true) {
							order.removeMedia(m);;
						}
					}
					System.out.println("Remove successfully item with id "+ idRemove);
				}
				break;
			case 4:
				double cost = order.totalCost();
				System.out.println("Total cost is: " + cost + "$");
				order.printOrder();
				break;
			case 5:
				List<DigitalVideoDisc> listDVD = new ArrayList<DigitalVideoDisc>();
				listDVD.add(dvd1);
				listDVD.add(dvd2);
				listDVD.add(dvd3);
				java.util.Collections.sort((List)listDVD);
				Iterator iterator = listDVD.iterator();
				System.out.println("The list DVD is sorted by cost (ASC): ");
				while(iterator.hasNext()) {
					DigitalVideoDisc d = ((DigitalVideoDisc)iterator.next());
					System.out.println(d.getCost()+"$ - "+d.getTitle());
				}
				break;
			case 6:
				// enable compile after add Tracks for cd 
				break;
			case 0:
				check_out=1;
				break;
			default:
			}
		}while(check_out == 0);
	}
}
			