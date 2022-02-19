package stack;

import linkedlist.ReverseALinkedList.Node;

//here we can use linkedlist
public class ReverseStackWithNoRecursionNoExtraStack {

	Node top;
	public class Node{
		Node next;
		int data;
		public Node(int data) {
			this.data=data;
		}
	}
	
	public static void main(String[] args) {
		ReverseStackWithNoRecursionNoExtraStack s= new ReverseStackWithNoRecursionNoExtraStack();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		s.push(7);
		s.push(8);
		s.printStack();
		System.out.println(s.poll());
		s.printStack();
		s.reverseStack();
		s.printStack();
	}

	private void reverseStack() {
		if(top==null) {
			return;
		}
		Node current=top; Node next=null;Node prev=null;
		while(current!=null) {
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		top=prev;
	}

	private int poll() {
		if(top==null) {
			System.exit(0);
		}
		Node temp= top;
		top=top.next;
		return temp.data;
	}

	private void printStack() {
		if(top==null) {
		return;
		}
		Node temp=top;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();	
		
	}

	private void push(int data) {
		if(top==null) {
			top= new Node(data);
			return;
		}
		Node temp= new Node(data);
		temp.next=top;
		top=temp;
	}
}
