package linkedlist;

public class SinlglyLL {
	static Node head;
	static class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data=data;
		}	
	}
		
		public static void main(String[] args) {
			insertLast(4);
			insertLast(5);
			insertLast(6);
			insertLast(7);
			insertFirst(1);
			insertAfter(2,1);
			insertAfter(3,2);
			insertAfter(8,7);   ////check this
//			insertAfter(100,10);
			insertBefore(0, 1);
			insertBefore(6,7);
			insertBefore(7, 8);
			update(8,60);
			delete(7);
			delete(60);
			printList();
		}
		
		private static void delete(int data) {	
			Node temp=head;
			if(head==null)
				return;
			else if(head.data==data) {
				head=head.next;
				return;
			}
			else {
				Node temp1=head.next;
				while(temp1!=null) {
					if(temp1.data==data) {
						temp.next=temp1.next;
						return;
					}
					temp=temp1;
					temp1=temp1.next;
				}
				
			}
		}
		
		private static void update(int current, int updateWith) {
			int counter=0;
			Node temp = head;
			if(head==null)
				return;
			else {
				while(temp!=null) {
				
					if(temp.data==current) {
						temp.data=updateWith;
						counter++;
					}
					temp=temp.next;
				}
				if(counter==0) {
					System.out.println("provided data "+ current+ " isn't avialable in the list");
				}
				else
					System.out.println(counter+" occurances of number "+ current +" has been found and updated with "+updateWith);
			}
			
		}

		private static void insertBefore(int data, int beforeThisData) {
			Node temp=head;
			Node temp1=head.next;
			if(head==null)
				return;
			else if(temp.data==beforeThisData) {
				head=new Node(data);
				head.next=temp;
				return;
			}
			else {
				while(temp1!=null) {
					if(temp1.data==beforeThisData) {
						Node temp2=temp1;
						temp.next= new Node(data);
						temp.next.next=temp2;
						return;
					}
					temp=temp1;
					temp1=temp1.next;
				}
				if(temp1==null)
					System.out.println("number "+beforeThisData+" isn\'t present in the List");
			}
			
		}

		private static void insertAfter(int data, int afterThisData) {
			Node temp = head;
			if(head==null) {
				System.out.println("head is null");
				return;
			}
			else if(head.data==afterThisData) {
				temp=head.next;
				head.next=new Node(data);
				head.next.next=temp;
			}
			else {
				while(temp!=null) {
					if(temp.data==afterThisData) {
						Node tmp= temp.next;
						temp.next= new Node(data);
						temp.next.next=tmp;
						return;
					}
					temp=temp.next;
				}
				if(temp==null) {
					System.out.println("Invalid data");
				}
			}
		}

		private static void insertFirst(int data) {
			if(head==null) {
				head=  new Node(data);
			}
			else {
				Node tmp=head;
				head= new Node(data);
				head.next=tmp;
			}
		}

		private static void insertLast(int data) {
			Node tmp=head;
			if(tmp==null)
				head= new Node(data);
			else {
				while(tmp.next!=null) {
					tmp=tmp.next;
				}
				tmp.next=new Node(data);
			}
		}
		

		private static void printList() {
			if(head==null)
				return;
			else {
				Node tmp=head;
				while(tmp!=null) {
					System.out.print(tmp.data+ " ");
					tmp=tmp.next;
				}
			}
			System.out.println();
		}
}
