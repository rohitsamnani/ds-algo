package slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class CountGoodString {

	public static void main(String[] args) {

		String s = "aababcabc";
		System.out.println(countGoodSubstrings(s));
	}

	public static int countGoodSubstrings(String s) {
		int i = 0;
		int j = 0;
		int count = 0;
		int k = 3;

		Set<Character> set = new HashSet<>();
		while (j < s.length()) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j));

				if (set.size() < k) {
					j++;
				} else if (set.size() == k) {
					count++;
					set.remove(s.charAt(i));

					i++;
					j++;
				}
			} else {
				set.remove(s.charAt(i));
				i++;
			}
		}
		return count;
	}
}
