package linkedlist;

import java.util.HashSet;
import java.util.Set;

/*
 * Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.
 */

//https://leetcode.com/problems/happy-number/submissions/
public class HappyNumber {

	public static void main(String[] args) {
		int input = 19;
		System.out.println(isHappyNumber(input));
		System.out.println(isHappyNumberWithoutUsingInbuiltCollections(input));
	}

	private static boolean isHappyNumber(int input) {
		Set<Integer> s = new HashSet<>();
		while (input != 1) {
			int number = input;
			int result = 0;
			while (number > 0) {
				int remainder = number % 10;
				result += remainder * remainder;
				number = number / 10;
			}
			input = result;
			if (s.contains(result)) {
				return false;
			}
			s.add(result);

		}
		if (input == 1) {
			return true;
		}

		return false;
	}

	private static boolean isHappyNumberWithoutUsingInbuiltCollections(int input) {

		int singleJump = input;
		int doubleJump = input;
		do {
			singleJump = findSquare(singleJump);
			doubleJump = findSquare(findSquare(doubleJump));
		} while (singleJump != doubleJump);
		if (singleJump == 1) {
			return true;
		}
		return false;
	}

	static int findSquare(int num) {
		int result = 0;
		while (num > 0) {
			int remainder = num % 10;
			result += remainder * remainder;
			num /= 10;
		}
		return result;
	}
}
