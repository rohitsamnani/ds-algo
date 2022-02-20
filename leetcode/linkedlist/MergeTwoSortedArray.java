package linkedlist;

public class MergeTwoSortedArray {

	public static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	static Node head1;
	static Node head2;

	public static void main(String[] args) {
		head1 = new Node(1);
		insertLastRecursive(head1, 3);
		insertLastRecursive(head1, 4);
		insertLastRecursive(head1, 6);
		insertLastRecursive(head1, 7);
		head2 = new Node(1);
		insertLastRecursive(head2, 2);
		insertLastRecursive(head2, 3);
		insertLastRecursive(head2, 5);
		insertLastRecursive(head2, 8);
		Node head = null;
		if (head1.data > head2.data) {
			head = new Node(head2.data);
			mergeIt(head, head1, head2.next);
		} else {
			head = new Node(head1.data);
			mergeIt(head, head1.next, head2);
		}
		printIt(head);
	}

	private static void printIt(Node temp) {
		if (temp == null) {
			return;
		}
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}

	private static void mergeIt(Node temp, Node temp1, Node temp2) {
		while (temp1 != null && temp2 != null) {
			if (temp1.data >= temp2.data) {
				temp.next = temp2;
				temp2 = temp2.next;
			} else {
				temp.next = temp1;
				temp1 = temp1.next;
			}
			temp=temp.next;
		}

		if (temp1 == null) {
			while (temp2 != null) {
				temp.next = temp2;
				temp2 = temp2.next;
			}
		}
		if (temp2 == null) {
			while (temp1 != null) {
				temp.next = temp1;
				temp1 = temp1.next;
			}
		}
	}

	private static void insertLastRecursive(Node temp, int data) {
		if (temp == null) {
			return;
		}
		if (temp.next == null) {
			temp.next = new Node(data);
			return;
		}
		insertLastRecursive(temp.next, data);
	}
}
