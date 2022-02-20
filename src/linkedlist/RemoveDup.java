package linkedlist;

import java.util.HashSet;

public class RemoveDup {

	public static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	static Node head;

	public static void main(String[] args) {
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(2);
		head.next.next.next = new Node(5);
		head.next.next.next.next = new Node(5);

		print();
		removeDuplicates();
		print();

		head = new Node(2);
		head.next = new Node(2);
		head.next.next = new Node(4);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(4);
		head.next.next.next.next.next = new Node(5);
		print();
		removeUnsortedDup();
		print();
	}

	private static void removeUnsortedDup() {
		if (head == null) {
			return;
		}
		HashSet<Integer> hs = new HashSet<>();
		Node current = head;
		Node prev = null;
		while (current != null) {
			if (hs.contains(current.data)) {
				prev.next = current.next;
			} else {
				hs.add(current.data);
				prev = current;
			}
			current = current.next;
		}
	}

	//avoid this one as it wont work for dup data
	private static void removeDuplicates() {
		if (head == null) {
			return;
		}
		Node temp = head;
		while (temp != null) {
			Node temp1 = temp;
			while (temp1 != null && temp1.data == temp.data) {
				temp1 = temp1.next;
			}
			
			//becoz list is sorted hence skip the mid extra duplicate part directly.
			temp.next = temp1;
			temp = temp.next;

		}
	}

	private static void print() {
		if (head == null) {
			return;
		}
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();

	}
}