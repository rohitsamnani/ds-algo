package tree;

public class PrintBinaryTree {
	static Node root;
	static class Node{
		Node left;
		Node right;
		int data;
		
		public Node(int data) {
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	
	public static void main(String[] args) {
		root= new Node(1);
	    root.left= new Node(2);
	    root.right= new Node(3);
	    root.left.left= new Node(4);
	    root.left.right= new Node(5);
	    root.right.left= new Node(6);
	    root.right.right= new Node(7);
	    
	    inOrder(root);
	    System.out.println();
	    preOrder(root);
	    System.out.println();
	    postOrder(root);
	    System.out.println();
	    leverOrderPrint(root);
	    System.out.println();
	    levelOrderPrint(root);
	    	       
	}

	private static void postOrder(Node root) {
		// LRRoot
		if(root==null)
			return;
		
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
		
	}

	private static void preOrder(Node root) {
		// RootLR
		if(root==null)
			return;
		
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}

	private static void inOrder(Node root) {
		// LRootR
		if(root==null) {
			return;
		}
		
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);	
	}

	private static void leverOrderPrint(Node root) {
		// levelOrderPrint
		
		int height = height(root);
		for(int i=1;i<=height;i++) {
			printCurrentLevel(root,i);
		}
		
		
	}

	private static void printCurrentLevel(Node root, int currLevel) {
		if(root==null || currLevel==0) {
			return;
		}
		if(currLevel==1) {
			System.out.print(root.data+" ");
		}
		printCurrentLevel(root.left,currLevel-1);
		printCurrentLevel(root.right,currLevel-1);
				
	}

	private static int height(Node root) {

		if(root==null) {
			return 0 ;
		}
		
		int lheight= height(root.left);
		int rheight = height(root.right);
		
		if(lheight>rheight) {
			return lheight+1;
		}
		else {
			return rheight+1;
		}
	}
	
	private static void levelOrderPrint(Node root) {
		
		int height=height(root);
		for(int i=1;i<=height;i++) {
			levelOrderPrintKaro(root,i);
		}
	}
	private static void levelOrderPrintKaro(Node root,int currLevel) {

		if(root==null || currLevel==0) {
			return;
		}
		if(currLevel==1) {
			System.out.print(root.data+" ");
		}
		
		levelOrderPrintKaro(root.left,currLevel-1);
		levelOrderPrintKaro(root.right,currLevel-1);
	}
}