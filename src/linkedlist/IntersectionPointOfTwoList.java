package linkedlist;

public class IntersectionPointOfTwoList {
	static Node list1;
	static Node list2;

	public static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {

		list1 = new Node(3);
		list1.next = new Node(6);
		list1.next.next = new Node(9);
		list1.next.next.next = new Node(15);
		list1.next.next.next.next = new Node(30);
		list2 = new Node(10);
		list2.next = new Node(15);
		list2.next.next = new Node(30);

		System.out.println(intersectionPoint(list1, list2));
	}

	private static int intersectionPoint(Node list1, Node list2) {
		if (list1 == null || list2 == null) {
			return -1;
		}

		int list1_length = length(list1);
		int list2_length = length(list2);
		int d = 0;
		if (list1_length > list2_length) {
			d = list1_length - list2_length;
			return findIntersection(d, list1, list2);
		} else
			d = list2_length - list1_length;
		return findIntersection(d, list2, list1);
	}

	private static int findIntersection(int d, Node list1, Node list2) {
		Node temp1 = list1;
		Node temp2 = list2;
		for (int i = 0; i < d; i++) {
			temp1 = temp1.next;
		}
		while (temp2 != null && temp1 != null) {
			if (temp1.data == temp2.data) {
				return temp1.data;
			}
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		return -1;
	}

	private static int length(Node list) {

		int counter = 0;
		while (list != null) {
			counter++;
			list = list.next;
		}
		return counter;
	}
}