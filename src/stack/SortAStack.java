package stack;

import java.util.Stack;

//here we are going to sort a stack using recurssion
public class SortAStack {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(1);
		s.push(-10);
		s.push(30);
		s.push(15);
		s.push(12);
		s.push(-3);

		sortIt(s);
		System.out.print(s + " ");
	}

	private static void sortIt(Stack<Integer> s) {

		if (s.isEmpty()) {
			return;
		}

		int data = s.pop();
		sortIt(s);
		pushDataintoSortedStack(s, data);

	}

	private static void pushDataintoSortedStack(Stack<Integer> s, int data) {

		if (s.isEmpty() || data > s.peek()) {
			s.push(data);
			return;
		}
		int temp = s.pop();
		pushDataintoSortedStack(s, data);
		s.push(temp);
	}
}
