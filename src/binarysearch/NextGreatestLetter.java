package binarysearch;

public class NextGreatestLetter {

	public static void main(String[] args) {
		char[] letters = { 'a', 'b', 'j' };
		char target = 'l';
		System.out.println(nextGreatestLetter(letters, target));
	}

	public static char nextGreatestLetter(char[] letters, char target) {
		int start = 0;
		int end = letters.length-1 ;

		while (start!=end+1) {
			int mid = start + (end - start) / 2;
			if (letters[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			} 
		}
		
		return letters[start%letters.length];
	}
}