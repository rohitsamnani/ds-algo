package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class OccurancesOfAnagram {

	public static void main(String[] args) {
		String s = "cbaebabacd";
		String k = "abc";

		int count = occurancesOfAnagram1(s, k);
		System.out.println(count);
	}

	private static int occurancesOfAnagram(String s, String k) {
		int i = 0;
		int j = 0;
		int count = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (char c : k.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		Map<Character, Integer> temp = new HashMap<>();
		while (j < s.length()) {
			char c = s.charAt(j);
			if (temp.containsKey(c)) {
				temp.put(c, temp.get(c) + 1);
			} else {
				temp.put(c, 1);
			}
			if (j - i + 1 < k.length()) {
				j++;
			} else if (j - i + 1 == k.length()) {
				if (map.equals(temp)) {
					count++;
				}
				if (temp.get(s.charAt(i)) == 1) {
					temp.remove(s.charAt(i));
				} else {
					temp.put(s.charAt(i), temp.get(s.charAt(i)) - 1);
				}
				i++;
				j++;
			}
		}
		return count;
	}

	private static int occurancesOfAnagram1(String s, String k) {
		int i = 0;
		int j = 0;
		int count=0;
		int charCount=0;
		Map<Character, Integer> map = new HashMap<>();
		for (char c : k.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
				charCount++;
			}
		}
		
		while (j < s.length()) {
			char c=s.charAt(j);
			if (map.containsKey(c)) {
				if(map.get(c)==0) {
					map.put(c, 1);
					charCount++;
				}
				else {
					map.put(c, map.get(c)-1);
					if(map.get(c)==0) {
						charCount--;
					}
				}
			}
			else {
				map.put(c, 1);
				charCount++;
			}
			if (j - i + 1 < k.length()) {
				j++;
			} else if (j - i + 1 == k.length()) {
				if(charCount==0) {
					count++;
				}
				map.put(s.charAt(i), map.get(s.charAt(i))+1);
				
				i++;
				j++;
			}
		}
		return count;
	}

}
