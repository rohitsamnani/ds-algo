package example;

public class SinglyLinkedList {
	
	Node head;
	
	public static void main(String[] args) {
		SinglyLinkedList sll= new SinglyLinkedList();
		sll.insert(2);
		sll.insert(3);
		sll.insert(4);
		sll.insert(10);
		sll.insert(12);
		sll.insert(21);
		sll.insert(432);
		sll.insert(1044);
		sll.insert(412);
		sll.insert(130);
		sll.insert(44);
		sll.insert(150);
		sll.insert(490);
		sll.insert(10444);
		sll.insert(422);
		sll.insert(110);
		sll.insert(14);
		sll.insert(3510);
		System.out.println("first: "+ sll.head.data);
		sll.print();
		System.out.println("Second :"+sll.head.data);
		System.out.println("print Next : "+sll.printNext(2));
		System.out.println("third :"+sll.head.data);
		System.out.println("print previous : "+sll.printPrevious(3510));
		System.out.println("fourth :"+sll.head.data);
	}
	
	private int printPrevious(int i) {
		if(head.data==i) 
			  return -1;
		  else { 
			  Node tmp=head.next;
			  Node previous = head;
			  while(tmp.data!=i && tmp.next!=null) {
				 previous=tmp;
				 tmp=tmp.next;
			  }
			  if(tmp.data!=i)
				  return -1;
			  else
				  return previous.data;
		  }
		
	}

	private int printNext(int i) {
		  if(head.data==i) 
			  return head.next.data;
		  else { 
			  Node tmp = head.next; 
			  while(tmp.next!=null && tmp.data!=i ) {
				tmp=tmp.next;  
			  }
			  if(tmp.next!=null)
				  return tmp.next.data;
			  else
				  return -1;
		  }
	}

	private void insert(int i) {
		if(head==null)
			head=new Node(i);
		else {
			Node tmp=head;
			while(tmp.next!=null) {
				tmp=tmp.next;
			}
			tmp.next= new Node(i);
		}
	}
	
	private void print() {
	if(head==null)
		System.out.println("List is empty");
	else {
		Node tmp=head;
		while(tmp!=null) {
			System.out.print(tmp.data + " ");
			tmp=tmp.next;
		}
		System.out.println();
	}	
  }

}
