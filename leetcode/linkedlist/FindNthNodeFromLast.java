package linkedlist;

public class FindNthNodeFromLast {

	static Node head;

	public static void main(String[] args) {
		head = new Node(10);
		insertLast(30);
		insertLast(40);
		insertLast(60);
		insertLast(70);
		insertLast(80);
		insertLast(90);
		insertLast(100);
		
		head = new Node(10);
		head.next=new Node(2);

		System.out.println(removeNthFromEnd(head, 2));
		printList(head);
	}

	private static void printList(Node head2) {
		while (head2 != null) {
			System.out.print(head2.data + " ");
			head2 = head2.next;
		}
	}

	public static Node removeNthFromEnd(Node head, int n) {
		Node node = head;
		Node temp = head;
		int counter = 0;

		while (temp != null) {
			counter++;
			temp = temp.next;
		}
		int index = 0;
		Node prevNode = null;

		while (index++ != counter - n) {
			prevNode = node;
			node = node.next;
		}
		if (prevNode == null || counter == n) {
			head = head.next;
		} else
			prevNode.next = node.next;

		return head;

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
}