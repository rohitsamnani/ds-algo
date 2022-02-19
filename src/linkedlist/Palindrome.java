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
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(4);
		head.next.next.next.next.next = new Node(3);
		head.next.next.next.next.next.next = new Node(2);
		head.next.next.next.next.next.next.next = new Node(1);

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
		for(int i=0;i<=st.size()/2;i++) {
			if (st.pop() != temp.data) {
				return false;
			}
			temp = temp.next;
		}
		return true;
	}
}
