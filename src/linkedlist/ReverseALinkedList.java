package linkedlist;

public class ReverseALinkedList {
	Node head;
	public class Node{
		Node next;
		int data;
		public Node(int data) {
			this.data=data;
		}
	}
	public static void main(String[] args) {
		ReverseALinkedList l = new ReverseALinkedList();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.add(6);
		l.printLinkedList();
		l.reverseLinkedList();
		l.printLinkedList();
	}
	private void reverseLinkedList() {
		if(head==null) {
			return;
		}
		Node current=head;
		Node next=null;
		Node prev=null;
		while(current!=null) {
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		head=prev;
	}
	private  void printLinkedList() {
		if(head==null) {
			return;
		}
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();	
	}
	private void add(int data) {
		if(head==null) {
			head= new Node(data);
			return;
		}
		Node temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next= new Node(data);		
	}

}
