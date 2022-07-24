package example;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class EmployeeTrainignAttendence {

	public static void main(String[] args) {
		String[] arr = { "039", "4", "14", "32","", "34", "7" };
		String[] arr1 = { "801234567", "180234567", "0","189234567","891234567","98","9" };
		String[] arr2 = { "5421","245","1452","0345","53","354"};
		System.out.println(findIt(arr));

	}

	private static int findIt(String[] arr) {
		Map<Character, Integer> k = new HashMap<>();

		for (String x : arr) {
			for (char c : x.toCharArray()) {
				if (k.containsKey(c)) {
					k.put(c, k.get(c) + 1);
				} else {
					k.put(c, 1);
				}

			}
		}
		Entry<Character, Integer> max1 = null;
		Entry<Character, Integer> max2 = null;

		for (Map.Entry<Character, Integer> en : k.entrySet()) {
			if (max1 == null || en.getValue().compareTo(max1.getValue()) > 0) {
				max1 = en;
			}
		}
		for (Map.Entry<Character, Integer> en : k.entrySet()) {
			if (en != max1 && (max2 == null || (en.getValue().compareTo(max2.getValue()) >0))) {
				max2 = en;
			}
		}
		
		char firstKey = max1.getKey();
		int firstValue = max1.getValue();
		char secondKey = max2.getKey();
		int secondValue = max2.getValue();
		int totalValue= firstValue+secondValue;
		
		if(max1.getValue()==arr.length) {
			totalValue=arr.length;
		}
		else {
		for (String x : arr) {
			if(!x.isEmpty() && x.indexOf(firstKey)==-1 && x.indexOf(secondKey)==-1) {
				totalValue = totalValue-1;
			}
		}
		}
		return totalValue;
	}

}
