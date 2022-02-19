package linkedlist;

import java.util.HashMap;
import java.util.HashSet;

import linkedlist.SinglyLinkedList.Node;

//to detect loop, create HashSet and add entries, keep checking if hs.contains(node), if yes loop exist else add the node again till last
public class DetectLoop {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();

		list.insertLast1(1);
		list.insertLast1(2);
		list.insertLast1(3);
		list.insertLast1(4);
		list.insertLast1(5);
		System.out.println(list.head.data);

		/* Create loop for testing */
		list.head.next.next.next.next.next = list.head.next;

		if (detectLoopUsingTwoPointer(list.head))
			System.out.println("Loop found");
		else
			System.out.println("No Loop");
		
		if (detectLoop(list.head))
			System.out.println("Loop found");
		else
			System.out.println("No Loop");
		
		int loopCount=detectAndCountLoop(list.head);
		if(loopCount>0)
			System.out.println("loop found and count nodes in the loop are : "+loopCount);
		else {
			System.out.println("no loop found");
		}
	}

	private static int detectAndCountLoop(Node head) {
		if(head==null) {
			return 0;
		}
		HashMap<Node,Integer> hm = new HashMap<>();
		int count=0;
		while(head!=null) {
			if(hm.containsKey(head)) {
				return count+1-hm.get(head); 
			}
			count+=1;
			hm.put(head, count);
			
			head=head.next;
		}
		return 0;
	}

	private static boolean detectLoop(Node head) {
		if (head == null) {
			return false;
		}
		HashSet<Node> hs = new HashSet<>();
		while (head != null) {
			if (hs.contains(head)) {
				return true;
			}
			hs.add(head);
			head = head.next;
		}
		return false;
	}
	
	
	private static boolean detectLoopUsingTwoPointer(Node head) {
		if(head==null) {
			return false;
		}
		Node singleJumper = head;
		Node doubleJumber = head.next;
		int count=1;
		
		while(doubleJumber!=null && doubleJumber.next!=null) {
			if(singleJumper==doubleJumber) {
				System.out.println(count);
				return true;
			}
			count++;
			doubleJumber=doubleJumber.next.next;
			singleJumper=singleJumper.next;
		}
		return false;
	}
}
