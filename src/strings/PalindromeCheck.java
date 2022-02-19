package strings;

public class PalindromeCheck {

	public static void main(String[] args) {
		String word = "abcdcba";
		int number = 1234567;
		System.out.println(isPalindrome2(number));
		System.out.println(isPalindrome1(word));
		System.out.println(isPalindrome1(Integer.toString(number)));
		System.out.println((isPalindrome3(123454321)));
	}

	static boolean isPalindrome(String word) {
		if (word == null || word.length() == 0)
			return true;
		for (int i = 0; i <= word.length() / 2; i++) {
			char start = word.charAt(i);
			char end = word.charAt(word.length() - 1 - i);
			if (start != end) {
				return false;
			}
		}

		return true;
	}

	static boolean isPalindrome1(String word) {
		int start = 0;
		int end = word.length() - 1;
		while (start < end) {
			if (word.charAt(start) != word.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	static boolean isPalindrome2(int number) {

		int sum = 0;
		int n = number;

		while (n > 0) {
			int temp = n % 10;
			sum = (sum * 10) + temp;
			n = n / 10;

		}
		if (sum == number) {
			return true;
		}

		return false;
	}

	static boolean isPalindrome3(int number) {
		int reverseNum = reverse(number, (int)(Math.log10(number)+1));
		if (number == reverseNum) {
			return true;
		}
		return false;
	}

	private static int reverse(int n, int digits) {
		if(n%10==n) {
			return n;
		}
		return (n%10 *(int)Math.pow(10,digits-1) + reverse(n/10,digits-1));
	}
}
