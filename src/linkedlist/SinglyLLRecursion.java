package linkedlist;

public class SinglyLLRecursion {
	static Node head;

	static class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		insertLastRecursive(head, 4);
		insertLastRecursive(head, 5);
		insertLastRecursive(head, 6);
		insertLastRecursive(head, 7);
		insertFirst(1);
		insertAfterRecursive(head, 2, 1);
		insertAfterRecursive(head, 3, 2);
		insertAfterRecursive(head, 8, 7);
		insertBeforeRecursive(head, 0, 1);
		insertBeforeRecursive(head, 6, 7);
		insertBeforeRecursive(head, 7, 8);
		updateRecursive(head, 8, 60);
		deleteRecursive(head, 7);
		deleteRecursive(head, 60);
		printList();
	}

	private static void deleteRecursive(Node temp, int data) {
		if (temp == null)
			return;
		if (head.data == data) {
			head = head.next;
			return;
		}
		deleteRecursive(temp, temp.next, data);
	}

	private static void deleteRecursive(Node temp, Node temp1, int data) {
		if (temp1 == null) {
			return;
		}
		if (temp1.data == data) {
			temp.next = temp1.next;
			return;
		}
		deleteRecursive(temp.next, temp1.next, data);
	}

	private static void updateRecursive(Node temp, int current, int updateWith) {
		if (temp == null) {
			return;
		}
		if (temp.data == current) {
			temp.data = updateWith;
			return;
		}
		updateRecursive(temp.next, current, updateWith);
	}

	private static void insertBeforeRecursive(Node temp, int data, int beforeThisData) {
		if (temp == null) {
			return;
		}
		if (temp.data == beforeThisData) {
			Node temp1 = new Node(data);
			temp1.next = temp;
			temp1 = head;
			return;
		}
		insertBeforeRecursive(temp, temp.next, data, beforeThisData);
	}

	private static void insertBeforeRecursive(Node temp, Node temp1, int data, int beforeThisData) {
		if (temp1 == null) {
			return;
		}
		if (temp1.data == beforeThisData) {
			temp.next = new Node(data);
			temp.next.next = temp1;
			return;
		}
		insertBeforeRecursive(temp.next, temp1.next, data, beforeThisData);
	}

	private static void insertAfterRecursive(Node temp, int data, int afterThisData) {
		if (temp == null) {
			System.out.println("Data not found");
			return;
		}
		if (temp.data == afterThisData) {
			Node temp1 = temp.next;
			temp.next = new Node(data);
			temp.next.next = temp1;
			return;
		}
		insertAfterRecursive(temp.next, data, afterThisData);

	}

	private static void insertFirst(int data) {
		if (head == null) {
			head = new Node(data);
		} else {
			Node tmp = head;
			head = new Node(data);
			head.next = tmp;
		}
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

	private static void printList() {
		if (head == null)
			return;
		else {
			Node tmp = head;
			while (tmp != null) {
				System.out.print(tmp.data + " ");
				tmp = tmp.next;
			}
		}
		System.out.println();
	}
}
