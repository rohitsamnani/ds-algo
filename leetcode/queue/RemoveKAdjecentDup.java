package queue;

import java.util.Stack;

public class RemoveKAdjecentDup {

	public static void main(String[] args) {
		System.out.println(new RemoveKAdjecentDup().removeDuplicates("deeedbbcccbdaa", 3));
	}

	public String removeDuplicates(String s, int k) {
		Stack<Character> charStack = new Stack<>();
		Stack<Integer> intStack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		char[] chars = s.toCharArray();
		for (char c : chars) {
			if (!charStack.isEmpty() && charStack.peek() == c) {
				intStack.push(intStack.peek() + 1);
			} else {
				intStack.push(1);
			}
			charStack.push(c);
			if (intStack.peek() == k) {
				for (int i = 0; i < k; i++) {
					charStack.pop();
					intStack.pop();
				}
			}
		}
		while (!charStack.isEmpty()) {
			sb.append(charStack.pop());
		}
		return sb.reverse().toString();

	}

}
