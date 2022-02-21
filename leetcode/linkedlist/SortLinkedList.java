package linkedlist;

//Using Bubble Sort on this
public class SortLinkedList {
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
		
		print();
		bubbleSort(head);
		print();
	}

	private static void bubbleSort(Node temp) {
		if(temp==null) {
			return;
		}
		Node firstRef=temp;
		Node secondRef=temp.next;
		
		while(firstRef!=null) {
			while(secondRef!=null) {
				if(firstRef.data>secondRef.data) {
					
				}
				secondRef=secondRef.next;
			}
			firstRef=firstRef.next;
		}

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
