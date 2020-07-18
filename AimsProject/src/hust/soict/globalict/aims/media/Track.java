package hust.soict.globalict.aims.media;

public class Track implements Playable, Comparable{
	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	public void play() {
		System.out.println("Playing Track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Track) {
			Track another = (Track) obj;
			if(this.title.equals(another.title) &&
				this.length == another.length){
				return true;
			}
		}
		return false;
	}
	
	public int compareTo(Object obj) {
		Track t = (Track) obj;
		return this.getTitle().compareTo(t.getTitle());
	}
}
