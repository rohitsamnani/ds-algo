package stack;

import java.util.Stack;

public class ReverseStringUsingStack {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("RohitSamnani");
		System.out.println(sb);
		reverseString(sb);
		System.out.println(sb);
	}

	private static StringBuffer reverseString(StringBuffer sb) {
		Stack<Character> stack = new Stack<>();
		int length = sb.length();
		for (int i = 0; i < length; i++) {
			stack.push(sb.charAt(i));
		}

		for (int i = 0; i < length; i++) {
			sb.setCharAt(i, stack.pop());
		}
		return sb;
	}
}
