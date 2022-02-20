package linkedlist;

import java.util.Stack;

//put everything in stack, and run a loop till half of stack to check list is palindrome
public class Palindrome {

	static Node head;

	public static class Node {
		Node next;
		int data;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		insertLastRecursive(head, 1);
		insertLastRecursive(head, 2);
		insertLastRecursive(head, 3);
		insertLastRecursive(head, 4);
		insertLastRecursive(head, 4);
		insertLastRecursive(head, 3);
		insertLastRecursive(head, 2);
		insertLastRecursive(head, 1);

		// if you want to make false palindrom, uncomment below lines
		// head.next.next.next.next = new Node(5);
		// head.next.next.next.next.next = new Node(6);
		// head.next.next.next.next.next.next = new Node(1);

		if (isPalindrome())
			System.out.println("isPalidrome :" + "Yes");
		else
			System.out.println("isPalidrome :" + "No");

		if (isPalindromeWithHalfCheck())
			System.out.println("isPalindromeWithHalfCheck :" + "Yes");
		else
			System.out.println("isPalindromeWithHalfCheck :" + "No");

	}

	private static void insertLastRecursive(Node temp, int data) {
		if (temp == null) {
			head = new Node(data);
			return;
		}
		if (temp.next == null) {
			temp.next = new Node(data);
			return;
		}
		insertLastRecursive(temp.next, data);
	}

	private static boolean isPalindrome() {

		if (head == null) {
			return false;
		}
		Stack<Integer> st = new Stack<>();
		Node temp = head;
		while (temp != null) {
			st.push(temp.data);
			temp = temp.next;
		}
		temp = head;
		while (!st.isEmpty()) {
			if (st.pop() != temp.data) {
				return false;
			}
			temp = temp.next;
		}
		return true;
	}

	private static boolean isPalindromeWithHalfCheck() {

		if (head == null) {
			return false;
		}
		Stack<Integer> st = new Stack<>();
		Node temp = head;

		while (temp != null) {
			st.push(temp.data);
			temp = temp.next;
		}
		temp = head;
		for (int i = 0; i <= st.size() / 2; i++) {
			if (st.pop() != temp.data) {
				return false;
			}
			temp = temp.next;
		}
		return true;
	}
}