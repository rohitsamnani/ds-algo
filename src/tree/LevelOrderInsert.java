package tree;

import java.util.LinkedList;
import java.util.Queue;

//LeverOder insertion will use Queue/LL for maintaining temporary middle node until we aren't finding any blank node to insert value 
public class LevelOrderInsert {
	static Node root;

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String[] args) {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);

		insertAtlast(root, 7);
		System.out.println(root.right.left.data);
		System.out.println(root.right.right.data);
		insertAtlast(root, 8);
		System.out.println(root.left.left.left.data);

	}

	private static void insertAtlast(Node root, int data) {
		//
		if(root==null) {
			root=new Node(data);
		}
		Node temp = root;
		Queue<Node> q = new LinkedList<Node>();
		q.add(temp);

		while (!q.isEmpty()) {
			temp = q.peek();
			q.remove();
			if (temp.left == null) {
				temp.left= new Node(data);
				break;

			} else {
				q.add(temp.left);
				
			}
			if (temp.right == null) {
				temp.right=new Node(data);
				break;
			} else {
				q.add(temp.right);
			}
		}
	}
}
