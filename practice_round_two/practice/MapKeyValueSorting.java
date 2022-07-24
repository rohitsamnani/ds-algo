package practice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapKeyValueSorting {
	
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("Aohit", 111);
		map.put("Mohit", 112);
		map.put("Rahul", 111);
		map.put("Kohit", 125);
		map.put("Lohit", 112);
		map.put("Neha", 90);
		map.put("Meha", 87);
		map.put("Rhea", 12);
		map.put("Raghu", -2);
		map.put("Roshan", -10);
		
		
		
		Comparator<Entry<String, Integer>> comparator =  new Comparator<Entry<String, Integer>>() {
			
			public int compare(Entry<String,Integer> e1, Entry<String, Integer> e2) {
				if(e1.getValue()==e2.getValue()) {
					return e1.getKey().compareTo(e2.getKey());
				}
				return e1.getValue()-e2.getValue();
			}
		};
		//sort by only value
		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(k -> System.out.println(k.getKey()+"  = "+k.getValue()));
		System.out.println("\n");
		//sort by value first, and if value is equal and then sort by key
		
		
		map.entrySet().stream().sorted(comparator).forEach(k -> System.out.println(k.getKey()+"  = "+k.getValue()));
		
		
		
		System.out.println("\n");
		
		Comparator<Entry<String, Integer>> comparator1 =	(e1,e2)->  {
			if(e1.getValue()==e2.getValue()) {
				return e1.getKey().compareTo(e2.getKey());
			}
			return e1.getValue()-e2.getValue();
		};
		
		map.entrySet().stream().sorted(comparator1).forEach(k -> System.out.println(k.getKey()+"  = "+k.getValue()));
		
	}
}
