package linkedlist;

public class DoublyLinkedList {
	static Node head;
	static class Node{
		int data;
		Node previous, next;
		public Node(int data) {
			this.data=data;
			this.previous=null;
			this.next=null;
		}
		
		public static void main(String[] args) {
			insertLast(1);
			insertLast(2);
			insertLast(3);
			insertLast(4);
			insertLast(7);
			insertFirst(0);
//			insertFirst(9);
			printHeadToLast();
			insertAfter(5,4);
			printHeadToLast();
			insertBefore(6,7);
			printHeadToLast();
			insertUpdate(7,50);
			printHeadToLast();
			delete(50);
			delete(0);
			delete(5);
			printHeadToLast();
			printLastToHead();
		}

		private static void delete(int data) {
			Node temp=head;
			if(head==null)
				return;
			else if(head.data==data) {
				head= head.next;
				head.previous=null;
			}
			else {
				while(temp!=null) {
					if(temp.data==data) {
						if(temp.next!=null){
						temp.next.previous=temp.previous;
						}
						temp.previous.next=temp.next;		
						return;
					}
					temp=temp.next;
				}
				if(temp==null) {
				System.out.println("data "+data+ " isn't available in the list");
				}
			}
			
		}

		private static void insertUpdate(int current, int dataToUpdate) {
			Node temp=head;
			if(head==null)
				return;
				else {
					while(temp!=null) {
						if(temp.data==current) {
							temp.data=dataToUpdate;
							return;
						}
						temp=temp.next;
					}
					if(temp==null) {
						System.out.println("data "+current+" isn't available in the list");
					}
				}
			
		}

		private static void printLastToHead() {
			Node temp=head;
			if(head==null)
				return;
			else if(head.next==null) {
				System.out.println(head.data);
			}
			else {
					while(temp.next!=null) {
						temp= temp.next;
					}
					while(temp!=null) {
						System.out.print(temp.data+" ");
						temp=temp.previous;
					}
				}
			
		}

		private static void insertBefore(int data, int before) {
			Node temp=head;
			if(head==null)
				return;
			else if(head.data==before) {
				head= new Node(data);
				head.next=temp;
				temp.previous=head;
			}
			else {
				while(temp!=null) {
					if(temp.data==before) {
						Node temp1=	temp.previous;			//5
						temp.previous=new Node(data);		
						temp.previous.next=temp;
						temp.previous.previous=temp1;
						temp1.next=temp.previous;
						return;
					}
					temp=temp.next;
				}
				if(temp==null) {
					System.out.println("given data "+ before + " isn't available in the list");
				}
			}
		}

		private static void insertAfter(int data, int after) {
			Node temp=head;
			if(head==null)
				return;
			else {
				while(temp!=null) {
					if(temp.data==after) {
						Node temp1=temp.next;
						temp.next=new Node(data);
						temp.next.previous=temp;
						temp.next.next=temp1;
						temp1.previous=temp.next;
						return;
					}
					temp=temp.next;
				}
				if(temp==null) {
					System.out.println("given data :"+ after+ " not found");
				}
			}
		}

		private static void insertFirst(int data) {
			if(head==null) {
				head=new Node(data);
			}
			else {
				Node temp= head;
				head= new Node(data);
				head.next=temp;
				temp.previous=head;
			}			
		}

		private static void insertLast(int data) {
			Node temp= head;
			if(head==null)
				head = new Node(data);
			else {
				while(temp.next!=null) {
					temp=temp.next;
				}
				temp.next=new Node(data);
				temp.next.previous=temp;
			}
		}

		private static void printHeadToLast() {
			Node tmp=head;
			if(head==null)
				return;
			else {
				while(tmp!=null) {
					System.out.print(tmp.data+" ");
					tmp=tmp.next;
				}
			}
			System.out.println();
		}
	}

}
