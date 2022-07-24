package slidingwindow;

import java.util.LinkedHashSet;
import java.util.Set;

public class LongestSubstringwithNonRepeativeChars {
	public static void main(String[] args) {

		String s = " ";
		LongestSubstringwithNonRepeativeChars lswn = new LongestSubstringwithNonRepeativeChars();
		int result = lswn.longestSubstringwithNonRepeativeChars(s);
		System.out.println(result);
	}

	Set<Character> set = new LinkedHashSet<>();

	private int longestSubstringwithNonRepeativeChars(String s) {
		int i = 0;
		int j = 0;
		int max = 0;

		while (j < s.length()) {
			char c = s.charAt(j);
			boolean repeat = false;
			if (set.contains(c)) {
				repeat = true;
			} else {
				set.add(c);
			}
			if (!repeat) {
				j++;
			} else {
				max = Math.max(max, set.size());
				c = s.charAt(j);
				while (set.contains(c)) {
					set.remove(s.charAt(i));
					i++;
				}
				set.add(c);
				repeat = false;
				j++;
			}
		}

		return Math.max(max, set.size());
	}

}
