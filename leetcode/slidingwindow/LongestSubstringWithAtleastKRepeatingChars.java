package slidingwindow;

//Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.
public class LongestSubstringWithAtleastKRepeatingChars {

	public static void main(String[] args) {
		String s = "abadbbc";
		int k = 2;
		int count = subStringWithAtleastKRepeatingChars(s, k);
		System.out.println(count);
	}

	private static int subStringWithAtleastKRepeatingChars(String s, int k) {
		if (s.length() == 0)
			return 0;
		if (s.length() < k)
			return 0;
		if (k == 1 || k == 0)
			return s.length();

		int[] chars = new int[26];
		for (int x = 0; x < s.length(); x++) {
			chars[s.charAt(x) - 'a']++;
		}
		int len = 0;
		while (len < s.length() && chars[s.charAt(len) - 'a'] >= k) {
			len++;
		}
		if (len >= s.length() - 1) {
			return len;
		}
		int len1 = subStringWithAtleastKRepeatingChars(s.substring(0, len), k);
		while (len < s.length() && chars[s.charAt(len) - 'a'] < k) {
			len++;
		}
		int len2 = subStringWithAtleastKRepeatingChars(s.substring(len), k);

		return Math.max(len1, len2);
	}
}
