package hust.soict.globalict.aims.order;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import hust.soict.globalict.aims.PlayerException;
import hust.soict.globalict.aims.media.*;

public class Order {
	
	private List<Media> itemsOrdered = new ArrayList<Media>();

	public void addMedia(Media m) {
		itemsOrdered.add(m);
	}
	public void removeMedia(Media m) {
		itemsOrdered.remove(m);
	}
	
	
	public void printOrder() {
//		DigitalVideoDisc test = (DigitalVideoDisc) itemsOrdered.get(0);			*DOWNCASTING*
//		System.out.println(test.getDirector());
		for(Media m: itemsOrdered) {
			if (m.getId().contains("b")==true) {
				Book test = (Book)m;
				System.out.println("Book: "+test.getId()+"-"+ test.getTitle()+ "-"+test.getCategory()+"-"+test.getAuthors()+ "-"+ test.getCost()+"$");
			}
			if(m.getId().contains("dvd")==true) {
				DigitalVideoDisc test =(DigitalVideoDisc)m;
				System.out.println("DVD: "+test.getId()+"-"+ test.getTitle()+ "-"+test.getCategory()+"-"+ test.getDirector()+"-"+test.getLength()+ "-"+ test.getCost()+"$");
				
				try {
					test.play();
				} catch (PlayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(m.getId().contains("cd") == true) {
				CompactDisc test = (CompactDisc)m;
				System.out.println("CD: "+ test.getId()+ "-"+ test.getTitle()+ "-"+ test.getCategory()+"-"+test.getDirector()+"-"+test.getLength()+"-"+test.getArtist()+"-"+test.getCost()+"$");
				test.play();
			}
		}
	}
	
	public double totalCost() {
		double totalCost = 0.0;
		for(Media m : itemsOrdered) {
			totalCost += m.getCost();
		}
		return totalCost;
		}
	
	


	
	
	
	
	
	
	
//	public void searchabc(String title, DigitalVideoDisc listDVD []) {
//		System.out.println("Result:");
//		int j=0;
//		String temp[] = new String[listDVD.length];
//		for(int i=0; i < listDVD.length; i++) {
//			temp[i] = listDVD[i].getTitle().toUpperCase();
//		}
//		for(int i=0; i <listDVD.length; i++) {
//			if(temp[i].contains(title.toUpperCase()) == true ) {
//				System.out.println((j+1)+ "."+" DVD - "+listDVD[i].getTitle()+" - "+listDVD[i].getCategory()+" - "+ listDVD[i].getDirector()+" - "+listDVD[i].getLength()+" - "+listDVD[i].getCost()+"$");
//				j++;
//			}
//		}
//		if(j==0) System.out.println("The DVD you need isn't exist!");
//	}
//	
//	public DigitalVideoDisc getALuckyItem(DigitalVideoDisc listDVD[]) {
//		Random gen = new Random();
//		int i = gen.nextInt(listDVD.length);
//		return listDVD[i];
//	}
}
