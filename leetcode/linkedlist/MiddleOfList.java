package linkedlist;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
	}
}

public class MiddleOfList {

	static Node head;

	public static void main(String[] args) {
		head = new Node(1);

		insertLast(30);
		insertLast(40);

		insertLast(60);
		insertLast(70);
		insertLast(80);
		insertLast(90);
		insertLast(100);

		System.out.println(middle(head));
	}

	private static int middle(Node temp) {
		Node singleJump = temp;
		Node doubleJump = temp;

		while (doubleJump != null && doubleJump.next != null) {
			singleJump = singleJump.next;
			doubleJump = doubleJump.next.next;
		}

		return singleJump.data;

	}

	public static void insertLast(int data) {

		if (head == null) {
			head = new Node(data);
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new Node(data);
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
