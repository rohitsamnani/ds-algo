package linkedlist;

import linkedlist.SinglyLinkedList.Node;

public class SegregationEvenOdd {

	public static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	static Node head;

	public static void main(String[] args) {
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);

		printEvenOdd();
	}

	private static void printEvenOdd() {
		if (head == null) {
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		Node temp1 = head;
		Node temp2 = temp;
		Node prev = null;
		while (temp1 != temp) {
			if (temp1.data % 2 == 0) {
				temp2.next = temp1;
				temp2 = temp2.next;
				if (prev != null)
					prev.next = temp1.next;
				else
					head = temp1.next;
			} else {
				if(prev==null) {
					head=temp1;
				}
				prev = temp1;
			}
			temp1 = temp1.next;
		}
		temp2.next=null;
		print();
	}

	private static void print() {
		Node temp = head;
		if (temp == null)
			return;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();

	}
}
