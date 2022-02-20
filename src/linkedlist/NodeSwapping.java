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

		insertLastRecursive(head,1);
		insertLastRecursive(head,2);
		insertLastRecursive(head,3);
		insertLastRecursive(head,4);
		insertLastRecursive(head,5);
		insertLastRecursive(head,6);
		insertLastRecursive(head,7);
		insertLastRecursive(head,8);
		insertLastRecursive(head,9);
		print();
		swap(1, 9);
		print();

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
