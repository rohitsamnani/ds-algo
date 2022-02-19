package linkedlist;

public class NodeSwapping {
	static Node head;

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);
		head.next.next.next.next.next.next.next.next = new Node(9);
		print();
		swap(1, 9);
		print();

	}

	private static void swap(int data1, int data2) {
		if (head == null) {
			return;
		}
		Node current = head;
		Node currentMinusOne = null;
		Node current1 = null;
		Node current2 = null;
		Node prev1 = null;
		Node prev2 = null;
		while (current != null) {
			if (current.data == data1 || current.data == data2) {
				if (current.data == data1) {
					current1 = current;
					prev1 = currentMinusOne;
				}
				if (current.data == data2) {
					current2 = current;
					prev2 = currentMinusOne;
				}
			}
			currentMinusOne = current;
			current = current.next;
		}
		if (current1.next != current2) {
			Node temp = current2.next;
			current2.next = current1.next;
			prev2.next = current1;
			current1.next = temp;
			if (prev1 != null)
				prev1.next = current2;
			else {
				head = current2;
			}
		} else {
			
			Node temp = current2.next;
			current2.next = current1;
			current1.next = temp;
			if (prev1 != null)
				prev1.next = current2;
			else {
				head = current2;
			}
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
