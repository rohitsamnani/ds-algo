package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKUniqueChars {

	public static void main(String[] args) {
		String s = "abcbdbdbbdcdabd";
		int k = 5;
		int result = longestSubstringWithKUniqueChar(s, k);
		System.out.println(result);
	}

	private static int longestSubstringWithKUniqueChar(String s, int k) {
		int i = 0;
		int j = 0;
		Map<Character, Integer> map = new HashMap<>();
		int maxSubString = 0;
		while (j < s.length()) {
			char c = s.charAt(j);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else
				map.put(c, 1);
			if (map.size() < k) {
				j++;
			} else if (map.size() == k) {
				maxSubString = Math.max(j - i + 1, maxSubString);
				j++;
			} else if (map.size() > k) {
				c = s.charAt(i);
				while (map.size() > k) {
					map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
					if (map.get(s.charAt(i)) == 0) {
						map.remove(s.charAt(i));
					}
					i++;
				}
				j++;
				if (map.size() == k) {
					maxSubString = Math.max(j - i + 1, maxSubString);
				}
			}
		}
		return maxSubString;
	}
}