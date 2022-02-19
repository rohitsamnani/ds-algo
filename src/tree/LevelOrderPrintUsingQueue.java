package tree;

import java.util.LinkedList;
import java.util.Queue;

//Time Complexity O(N), Space O(N)
public class LevelOrderPrintUsingQueue {
	
	Node root;
	static class Node{
		int key;
		Node left, right;
		
		public Node(int key) {
			this.key=key;
			this.left=null;
			this.right=null;
		}
	}
	private void printCurrentOrder() {
	if(root==null)
		return;
	Queue<Node>q= new LinkedList<Node>();
	q.add(root);
	while(!(q.isEmpty())){
		Node temp=q.poll();
		System.out.print(temp.key+" ");
		if(temp.left!=null)
			q.add(temp.left);
		if(temp.right!=null)
			q.add(temp.right);
	}
		
}
	private void printCurrentOrderRightToLeft() {
	if(root==null)
		return;
	Queue<Node>q= new LinkedList<Node>();
	q.add(root);
	while(!(q.isEmpty())){
		Node temp=q.poll();
		System.out.print(temp.key+" ");
		if(temp.right!=null)
			q.add(temp.right);
		if(temp.left!=null)
			q.add(temp.left);
	}
		
}
	public static void main(String[] args) {
		LevelOrderPrintUsingQueue tree = new LevelOrderPrintUsingQueue();
	       tree.root= new Node(1);
	       tree.root.left= new Node(2);
	       tree.root.right= new Node(3);
	       tree.root.left.left= new Node(4);
	       tree.root.left.right= new Node(5);
	       tree.root.right.right= new Node(7);
	       tree.root.right.left= new Node(6);
	       
	       System.out.println("Level order traversal of binary tree is ");
	       tree.printCurrentOrder();
	       System.out.println();
	      System.out.println("Level order traversal of binary tree from right to left is ");
	       tree.printCurrentOrderRightToLeft();
	}

}
