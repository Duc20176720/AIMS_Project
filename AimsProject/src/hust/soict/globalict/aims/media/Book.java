package hust.soict.globalict.aims.media;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.HashMap;
import java.util.Iterator;

public class Book extends Media implements Comparable<Media> {
	private List<String> authors = new ArrayList<String>();
	private String content = new String();
	private List<String> contentTokens = new ArrayList<String>();
	private Map<String, Integer> wordFrequency = new HashMap<String, Integer>();
	
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public List<String> getAuthors() {
		return authors;
	}
	

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	public Book(String id, String title, String category, double cost) {
		super(id, title, category, cost);
	}
	
	public void addAuthor(String authorName) {
		if(authors.contains(authorName) == true) {
			System.out.println("This name of author is existed! ");
		}
		else {
			authors.add(authorName);
		}
	}
	
	public void removeAuthor(String authorName) {
		if(authors.contains(authorName) == false) {
			System.out.println("This name of author is not existed!");
		}
		else {
			authors.remove(authorName);
		}
	}
	
	public int compareTo(Media obj) {
		Book b = (Book) obj;
		return this.getTitle().compareTo(b.getTitle());
	}
	
	@Override
	public String toString() {
		return "IDBook: "+ this.getId() + "\n"
				+"TitleBook: "+this.getTitle() +"\n"
				+"CategoryBook: "+this.getCategory() + "\n"
				+"CostBook: " + this.getCost()+ "$";
	}
	
	public void processContent() {
		String[] words = content.split("\\s");
		for(String w: words) {
			if (w.contains(".")) {
				String[] wordssub = w.split("\\.");
				for(String x: wordssub)
					contentTokens.add(x);
			}else
				contentTokens.add(w);
			
		}
		//sort:
		java.util.Collections.sort((List)contentTokens);
		System.out.println("The ordered token list of content: ");
		Iterator iterator = contentTokens.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("The word frequency of the content: ");
		iterator = contentTokens.iterator();
		while(iterator.hasNext()) {
			String w = (String)iterator.next();
			//System.out.println(w + ": " + Collections.frequency(contentTokens, w));
			wordFrequency.put(w, Collections.frequency(contentTokens, w));
		}
		Set<String> set = wordFrequency.keySet();
		for (String key : set) {
            System.out.println(key + ": " + wordFrequency.get(key));
        }
	}
}
