package linkedlist;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


//you have to two list, check and bring the intersection point of those list (where the cut each other)
public class IntersectionPoint {
	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
			}

			this.tail = node;
		}
	}

	public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
			throws IOException {
		while (node != null) {
			bufferedWriter.write(String.valueOf(node.data));

			node = node.next;

			if (node != null) {
				bufferedWriter.write(sep);
			}
		}
	}

	// Complete the findMergeNode function below.

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode { int data; SinglyLinkedListNode next; }
	 *
	 */
	static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		int point = 0;
		int head1Length = findLength(head1);
		int head2Length = findLength(head2);
		int d = 0;
		if (head1Length > head2Length) {
			d = head1Length - head2Length;
			point = insectionPoint(d, head1, head2);
		} else {
			d = head2Length - head1Length;
			point = insectionPoint(d, head2, head1);
		}

		return point;

	}

	private static int insectionPoint(int d, SinglyLinkedListNode node1, SinglyLinkedListNode node2) {
		SinglyLinkedListNode temp1 = node1;
		SinglyLinkedListNode temp2 = node2;
		for (int i = 0; i < d; i++) {
			temp1 = temp1.next;
		}
		while (temp1 != null && temp2 != null) {
			if (temp2.data == temp1.data) {
				return temp2.data;
			}
			temp1 = temp1.next;
			temp2 = temp2.next;

		}
		return 0;
	}

	private static int findLength(SinglyLinkedListNode head) {
		int count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OUTPUT_PATH"));

		int tests = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int testsItr = 0; testsItr < tests; testsItr++) {
			int index = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			SinglyLinkedList llist1 = new SinglyLinkedList();

			int llist1Count = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < llist1Count; i++) {
				int llist1Item = scanner.nextInt();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				llist1.insertNode(llist1Item);
			}

			SinglyLinkedList llist2 = new SinglyLinkedList();

			int llist2Count = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < llist2Count; i++) {
				int llist2Item = scanner.nextInt();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				llist2.insertNode(llist2Item);
			}

			SinglyLinkedListNode ptr1 = llist1.head;
			SinglyLinkedListNode ptr2 = llist2.head;

			for (int i = 0; i < llist1Count; i++) {
				if (i < index) {
					ptr1 = ptr1.next;
				}
			}

			for (int i = 0; i < llist2Count; i++) {
				if (i != llist2Count - 1) {
					ptr2 = ptr2.next;
				}
			}

			ptr2.next = ptr1;

			int result = findMergeNode(llist1.head, llist2.head);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
