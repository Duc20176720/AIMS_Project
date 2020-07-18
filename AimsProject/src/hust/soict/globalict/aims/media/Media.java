package hust.soict.globalict.aims.media;

public abstract class Media {
	private String id;
	private String title;
	private String category;
	private double cost;
	
	
	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public double getCost() {
		return cost;
	}

	public Media(String id, String title, String category, double cost) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Media) {
			Media another = (Media) obj;
			if(this.id.equals(another.id)) {
				return true;
			}
		}
		return false;
	}
	
	
	public Media(String title) {
		if(title == null) {
			System.out.println("Title should not be null!");
		} else if(title.length() >24) {
			System.out.println("Title should not be more than 24 characters!");
		} else {
			this.title = title;
		}
	}
	
}
