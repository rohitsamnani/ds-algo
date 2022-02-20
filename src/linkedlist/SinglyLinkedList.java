package linkedlist;

public class SinglyLinkedList {

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
		insertFirst(10);
		insertFirst(20);
		insertLast1(30);
		insertLast1(40);
		insertFirst(50);
		insertLast1(60);
		insertAfter(2, 22);

		insertbefore(50, 101);
		insertbefore(20, 102);
		insertbefore(10, 103);
		insertbefore(22, 104);
		insertbefore(60, 105);
		insertbefore(40, 106);
		insertbefore(50, 107);

		printData();
		System.out.println(lengthIterative());
		System.out.println(lengthRecurssive(head, 0));

		System.out.println(GetNth(0));
		System.out.println(GetNthFromEnd(0));
		System.out.println(middle());
	}
	
	static int middle() {
		if(head==null) {
			return -1;
		}
		Node singleJump=head;
		Node doubleJump=head;
		
		while(doubleJump!=null && doubleJump.next!=null) {
			doubleJump=doubleJump.next.next;
			singleJump=singleJump.next;
		}
		return singleJump.data;
	}

	static int GetNth(int index) {
		if (head == null) {
			return 0;
		}
		Node temp = head;
		while (index != 0 && temp != null) {
			temp = temp.next;
			index--;
		}
		if (temp != null)
			return temp.data;
		else
			return -1;

	}
	
	static int GetNthFromEnd(int index) {
		if (head == null) {
			return 0;
		}
		Node temp = head;
		int length=0;

		while (temp != null) {
			temp = temp.next;
			length++;
		}
		if(length<=index) {
			return -1;
		}
		temp=head;
		for(int i=0;i<length-index-1;i++) {
			temp=temp.next;
		}
		return temp.data;
	}

	private static int lengthRecurssive(Node temp, int counter) {
		if (temp == null)
			return counter;
		return lengthRecurssive(temp.next, counter + 1);
	}

	private static int lengthIterative() {

		if (head == null) {
			return 0;
		}
		int counter = 0;
		Node temp = head;
		while (temp != null) {
			counter++;
			temp = temp.next;
		}
		return counter;
	}

	private static void delete(int data) {
		if (head == null) {
			return;
		}
		if (head.data == data) {
			head = head.next;
			return;
		}
		Node temp = head;
		Node temp1 = head.next;
		while (temp1 != null) {
			if (temp1.data == data) {
				temp.next = temp1.next;
				return;
			}
			temp = temp.next;
			temp1 = temp1.next;
		}
	}

	public static void insertAfter(int after, int data) {
		if (head == null) {
			return;
		}
		Node temp = head;
		while (temp != null) {
			if (temp.data == after) {
				Node temp1 = temp.next;
				temp.next = new Node(data);
				temp.next.next  = temp1;
				return;
			}
			temp = temp.next;
		}
		if (temp == null)
			System.out.println("data after which elements need to put not available in given linked list");
	}

	public static void insertFirst(int data) {

		if (head == null)
			head = new Node(data);
		else {
			Node tmp = head;
			head = new Node(data);
			head.next = tmp;
		}
	}

	public static void insertLast1(int data) {

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

	public static void printData() {
		Node temp = head;
		if (temp == null)
			return;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	private static void insertbefore(int before, int data) {
		if (head == null) {
			return;
		}
		if (head.data == before) {
			insertFirst(data);
			return;
		}
		Node temp = head.next;
		Node temp1 = head;
		while (temp != null) {
			if (temp.data == before) {
				Node temp2 = temp1.next;
				temp1.next = new Node(data);
				temp1.next.next = temp2;
				return;
			}
			temp1 = temp1.next;
			temp = temp.next;
		}
		if (temp == null) {
			System.out.println("data isn't available");
		}
	}

}
