package tree;

import java.util.Stack;
//Time O(N)
public class InOrderPrintUsingStack {
	Node root;
	static class Node{
		int key;
		Node left,right;
		public Node(int key) {
			this.key=key;
			this.left=this.right=null;
		}
	}
	   public static void main(String args[])
	    {
	 
	        /* creating a binary tree and entering
	        the nodes */
		   InOrderPrintUsingStack tree = new InOrderPrintUsingStack();
	        tree.root = new Node(1);
	        tree.root.left = new Node(2);
	        tree.root.right = new Node(3);
	        tree.root.left.left = new Node(4);
	        tree.root.left.right = new Node(5);
	        tree.inorder();
	    }
	   
	private void inorder() {
		if(root==null)
			return;
		
		Stack<Node> s = new Stack<Node>();
		Node temp= root;
		while(temp!=null || s.size()>0) {
			//go to left most first
			while(temp!=null) {
				s.push(temp);
				temp=temp.left;
			}
			temp=s.pop();
			System.out.print(temp.key+" ");
			temp=temp.right;
		}
	}

}
