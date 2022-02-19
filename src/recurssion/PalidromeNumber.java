package recurssion;

public class PalidromeNumber {

	public static void main(String[] args) {
		System.out.println(isPalindrome(1234321));
	}

	private static boolean isPalindrome(int n) {

		return n == ReverseDigits.reverse(n);
	}
}
