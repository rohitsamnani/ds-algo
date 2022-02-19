package linkedlist;

import java.util.Stack;

public class CircularLinkedList {
	static Node head;
	static class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data=data;
			this.next=null;
	}
	
	public static void main(String[] args) {
		insertLast(3);
		insertLast(4);
		insertLast(5);
		insertLast(6);
		insertFirst(2);
		insertFirst(1);
		insertLast(7);
		insertFirst(0);
		printForward();
		printBackward();
	}

	private static void insertFirst(int data) {
		Node temp=head;
		if(head==null) {
			head=new Node(data);
		}
		else if(head.next==null) {
			head= new Node(data);
			head.next=temp;
			temp.next=head;
		}
		else {
			while(temp.next!=head) {
				temp=temp.next;
			}
			Node temp1=new Node(data);
			temp.next= temp1;
			temp1.next=head;
			head=temp1;
		}
		
	}

	private static void insertLast(int data) {
		Node temp= head;
		if(head==null)
			head= new Node(data);
		else if(head.next==null) {
			head.next=new Node(data);
			head.next.next=head;
		}
		else {
			while(temp.next!=head) {
				temp=temp.next;
			}
			temp.next= new Node(data);
			temp.next.next=head;
		}
	}

	private static void printBackward() {	
		Node temp=head;
		Stack<Integer> st= new Stack<Integer>();
		if(head==null)
			return;
		else if(head.next==null) {
			System.out.println(head.data);
			return;
		}
		else {
			while(temp.next!=head) {
				//System.out.print(temp.data+" ");
				st.push(temp.data);
				temp=temp.next;
			}
			//System.out.print(temp.data+" ");
			st.push(temp.data);
		}
		while(!st.empty())
			System.out.print(st.pop() + " ");
	}

	private static void printForward() {
		Node temp=head;
		if(head==null)
			return;
		else if(head.next==null) {
			System.out.println(head.data);
			return;
		}
		else {
			while(temp.next!=head) {
				System.out.print(temp.data+" ");
				temp=temp.next;
			}
			System.out.print(temp.data+" ");
		}
		System.out.println();
		
	}
}
}
