package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable, Comparable<DigitalVideoDisc>{
	public DigitalVideoDisc(String id, String title, String category, double cost, int length, String director) {
		super(id, title, category, cost, length, director);
	}
	
	public void play() throws PlayerException {
		if(this.getLength()>0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		}else {
			throw new PlayerException("DVD length is non-positive");
		}
		
	}
	
	public int compareTo(DigitalVideoDisc d) {
		//DigitalVideoDisc d = (DigitalVideoDisc) obj;
		//return this.getTitle().compareTo(d.getTitle());
		if(this.getCost() > d.getCost()) return 1;
		else if (this.getCost() < d.getCost()) return -1;
		else return 0;
	}
}
