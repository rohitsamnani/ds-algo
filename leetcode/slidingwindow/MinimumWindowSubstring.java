package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {

	public static void main(String[] args) {
		String s = "cabwefgewcwaefgcf";
		String t = "cae";
		String res = minimumWindowSubstring(s, t);
		System.out.println(res);
	}

	private static String minimumWindowSubstring(String s, String t) {
		if (s.length() < t.length()) {
			return "";
		}

		int res = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		int count = 0;
		int jx = -1;
		int ix = -1;
		Map<Character, Integer> map = new HashMap<>();
		for (int x = 0; x < t.length(); x++) {
			char c = t.charAt(x);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		count = map.size();
		while (j < s.length()) {
			char c = s.charAt(j);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				if (map.get(c) == 0) {
					count--;
				}
			}
			if (count != 0) {
				j++;
			} else if (count == 0) {
				while (count == 0) {
					c = s.charAt(i);
					if (map.containsKey(c)) {
						map.put(c, map.get(c) + 1);
						if (map.get(c) > 0) {
							if (res > j - i + 1) {
								res = j - i + 1;
								ix = i;
								jx = j;
							}
							count++;
						}
					}
					i++;
				}
				j++;
			}
		}
		if (ix == -1) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (int q = ix; q <= jx; q++) {
			sb.append(s.charAt(q));
		}
		return sb.toString();
	}
}
