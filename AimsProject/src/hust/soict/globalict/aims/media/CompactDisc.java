package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable, Comparable<CompactDisc> {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
		return artist;
	}
	
	public List<Track> getTracks() {
		return tracks;
	}
//	public CompactDisc(String id, String title, String category, double cost, int length, String director, String artist, List<Track> tracks) {
//		super(id, title, category, cost, length, director);
//		this.artist = artist;
//		this.tracks = tracks;
//	}
	

	public CompactDisc(String id, String title, String category, double cost, String director, String artist) {
		super(id, title, category, cost, director);
		this.artist = artist;
	}
	
	public void addTrack(Track track) {
		if(tracks.contains(track)) {
			System.out.println("The track is existed !");
		} else {
			tracks.add(track);
		}
	}
	
	public void removeTrack(Track track) {
		if(!tracks.contains(track)) {
			System.out.println("The track is not existed !");
		} else {
			tracks.remove(track);
		}
	}
	
	public int getLength() {
		int sumLength = 0;
		for(Track t : tracks) {
			sumLength = sumLength + t.getLength();
		}
		return sumLength;
	}
	
	public void play(){
		for(Track t : tracks) {
			t.play();
		}
	}
	
	public int compareTo(CompactDisc cd) {
		//CompactDisc cd = (CompactDisc) obj;
		//return this.getTitle().compareTo(cd.getTitle());
		if(this.getTracks().size() > cd.getTracks().size()) return 1;
		else if(this.getTracks().size() < cd.getTracks().size())return -1;
		else if (this.getTracks().size() == cd.getTracks().size()) {
			if(this.getLength() > cd.getLength()) return 1;
			else if(this.getLength() < cd.getLength()) return -1;
			else if(this.getLength() == cd.getLength()) return 0; 
			else return 0;
		}
		else return 0;
	}

}