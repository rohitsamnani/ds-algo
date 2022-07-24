package company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class SmallestNegativeBalance {

	public static void main(String[] args) {
		HashMap<String, Integer> codenames = new HashMap<String, Integer>();
		codenames.put("Rohit", 1);
		codenames.put("Rahul", 5);
		codenames.put("Krishna", 8);
		codenames.put("Java", -10);
		codenames.put("DEF", -1);
		codenames.put("ABC", -1);
		codenames.put("Naya", -9);

		Set<Entry<String, Integer>> entries = codenames.entrySet();
		List<Entry<String, Integer>> listOfEntries = new ArrayList<Entry<String, Integer>>(entries);
		
		Comparator<Entry<String, Integer>> valueComparator = new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
				String v1 = e1.getKey();
				String v2 = e2.getKey();
				Integer i1 = e1.getValue();
				Integer i2 = e2.getValue();

				if (i1 == i2) {
					return v1.compareTo(v2);
				} else {
					return i1 - i2;
				}
			}
		};
		Collections.sort(listOfEntries,valueComparator);

		LinkedHashMap<String, Integer> sortedByValue = new LinkedHashMap<String, Integer>(listOfEntries.size()); 
		for(Entry<String, Integer> entry : listOfEntries){ 
			sortedByValue.put(entry.getKey(), entry.getValue()); }
		 
		Set<Entry<String, Integer>> entrySetSortedByValue = sortedByValue.entrySet(); 
		for(Entry<String, Integer> mapping : entrySetSortedByValue)
		{ System.out.println(mapping.getKey() + " ==> " + mapping.getValue()); }

		
	}
}