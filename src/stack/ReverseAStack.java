package stack;

import java.util.Stack;

public class ReverseAStack {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(12);
		s.push(11);
		s.push(14);
		s.push(15);
		s.push(19);
		s.push(66);
		s.push(16);
		System.out.println(s);
		Stack<Integer> tmpStack = new Stack<>();
		reverseUsingTempStack(s, tmpStack);
		System.out.println(tmpStack);

		// Reverse Using Recursion
		System.out.println(tmpStack);
		reverseUsingRecursion(tmpStack);
		System.out.println(tmpStack);
	}

	private static void reverseUsingRecursion(Stack<Integer> s) {
		if (s.isEmpty())
			return;
		int temp = s.pop();
		reverseUsingRecursion(s);
		inseredAtBottom(s, temp);

	}

	private static void inseredAtBottom(Stack<Integer> s, int temp) {
		if(s.isEmpty()) {
			s.push(temp);
		}
		else {
		int tempData=s.peek();
		s.pop();
		inseredAtBottom(s,temp);
		s.push(tempData);
		}

	}

	private static void reverseUsingTempStack(Stack<Integer> s, Stack<Integer> tmpStack) {
		while (!s.isEmpty())
			tmpStack.push(s.pop());
	}

}
