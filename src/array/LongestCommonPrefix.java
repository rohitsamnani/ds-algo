
package array;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		String tempString = strs[0];
		String word="";
		for (int k = 1; k < strs.length; k++) {
			System.out.println(tempString.length());
			System.out.println(strs[k].length());
			if (tempString.length() > strs[k].length()) {
				tempString = strs[k];
			}
		}
		
		for (int j = 0; j <= strs.length; j++) {
			for (int i = 0; i < tempString.length(); i++) {
				if (tempString.charAt(i) != strs[j].charAt(i)) {
					return word;
				}
				word=word+tempString.charAt(i);
			}
		}
		return word;
	}

	public static void main(String[] args) {
		String[] strs = { "flower", "flow", "flight" };
		System.out.println("dkdk");
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
	}

}
