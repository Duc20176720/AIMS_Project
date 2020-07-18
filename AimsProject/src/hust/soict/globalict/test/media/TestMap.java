package hust.soict.globalict.test.media;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;

public class TestMap {
	public static void main(String []arg) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(2, "c");
		map.put(2, "d");
		map.put(4, "d");
		
		Set<Integer> set = map.keySet();
		for(Integer key: set) {
			System.out.println(key+" "+ map.get(key));
		}
		//System.out.println(map);
	}
}
