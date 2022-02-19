package linkedlist;

public class DLLPractice {

	static Node head;

	public static class Node {
		int data;
		Node previous;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
			this.previous = null;
		}
	}

	public static void main(String[] args) {
		insertLast(1);
		insertLast(2);
		insertLast(3);
		insertLast(4);
		insertLast(7);
		insertFirst(0);
		printHeadToLast();
		insertAfter(4, 5);
		insertAfter(5, 6);
		printHeadToLast();
		/* insertBefore(6, 7); */
		insertBefore(0, 8);
		insertBefore(7, 45);
		printHeadToLast();
		insertUpdate(7, 500);
		insertUpdate(8, 200);
		insertUpdate(0, 10);
		insertUpdate(45, 4500);
		printHeadToLast();
		delete(500);
		delete(200);
		delete(4);
		printHeadToLast();
		printLastToHead();
	}

	private static void printLastToHead() {
		if(head==null) {
			return;
		}
		Node temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.previous;
		}
	}

	private static void delete(int data) {
		if(head==null) {
			return;
		}
		if(head.data==data) {
			head=head.next;
			head.previous=null;
			return;
		}
		Node temp=head;
		while(temp.next!=null) {
			if(temp.data==data) {
				Node temp2=temp.previous;
				Node temp3=temp.next;
				temp2.next=temp3;
				temp3.previous=temp2;
				return;
			}
			temp=temp.next;
		}
		if(temp.data==data) {
			temp.previous.next=null;
		}
	}

	private static void insertUpdate(int data, int replaceWith) {
		if (head == null) {
			return;
		}
		Node temp = head;
		while (temp != null) {
			if (temp.data == data) {
				temp.data = replaceWith;
				return;
			}
			temp = temp.next;
		}
	}

	private static void insertBefore(int data, int before) {
		Node n = new Node(before);
		if (head == null) {
			return;
		}
		if (head.data == data) {
			insertFirst(before);
			return;
		}

		Node temp = head;
		while (temp != null) {
			if (temp.data == data) {
				Node temp2 = temp.previous;
				temp2.next = n;
				n.previous = temp2;
				n.next = temp;
				temp.previous = n;
				return;
			}
			temp = temp.next;
		}
	}

	private static void insertAfter(int data, int after) {
		if (head == null) {
			return;
		}
		Node temp = head;
		Node n = new Node(after);
		while (temp != null) {
			if (temp.data == data) {
				Node temp2 = temp.next;
				temp.next = n;
				n.previous = temp;
				n.next = temp2;
				return;
			}
			temp = temp.next;
		}
	}

	private static void printHeadToLast() {
		if (head == null) {
			return;
		}
		Node tmp = head;
		while (tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		System.out.println();
	}

	private static void insertFirst(int data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
			return;
		}
		Node temp = head;
		head = node;
		head.next = temp;
		temp.previous = node;
	}

	private static void insertLast(int data) {
		if (head == null) {
			head = new Node(data);
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new Node(data);
		temp.next.previous = temp;
	}
}
