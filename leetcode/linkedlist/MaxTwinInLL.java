package linkedlist;

import java.util.Stack;

public class MaxTwinInLL {
	static Node head;
	static int sum=0;
	static int counter=1;
	public static void main(String[] args) {

		head = new Node(1);

		insertLast(30);
		insertLast(40);

		insertLast(60);
		insertLast(70);
		insertLast(80);
		insertLast(90);
		insertLast(1);
		

		findMaxTwinSum(head);
		System.out.println(sum);

	}

	private static void findMaxTwinSum(Node temp) {
		Stack<Integer> s = new Stack<>();
		Node temp1=temp;
		while(temp!=null){
			s.push(temp.data);
			temp=temp.next;
			counter++;
		}
		
		for(int i=0;i<counter/2;i++) {
				sum=Math.max(sum, temp1.data+s.pop());
				temp1=temp1.next;
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

}
