package tree;

//Time Complexity O(N*N), Space O(N)
public class LevelOrderPrint {
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
	
	private int height(Node root) {
		if(root==null) {
			return 0;
		}
		int lheight=height(root.left);
		int rheight=height(root.right);
		
		if(lheight>rheight)
			return(lheight+1);  //+1 for root
		else
			return (rheight+1);		//+1 for root
	}

	private void printLevelOrder() {
		if(root==null)
			return;
		int height = height(root);
		for(int i=1;i<=height;i++) {
			printCurrentOrder(root,i);
		}
	}

	
	private void printLevelOrderRightToLeft() {
		if(root==null)
			return;
		int height = height(root);
		for(int j=1;j<=height;j++) {
		printCurrentOrderRightToLeft(root,j);
	}
}
	private void printCurrentOrder(Node root, int l) {
		if(root==null)
			return;
		if(l==1) {
			System.out.print(root.key+ " ");
		}
		else {
			printCurrentOrder(root.left, l-1);
			printCurrentOrder(root.right, l-1);
		}
	}
	
	private void printCurrentOrderRightToLeft(Node root, int l) {
		if(root==null)
			return;
		if(l==1) {
			System.out.print(root.key+ " ");
		}
		else {
			printCurrentOrderRightToLeft(root.right, l-1);
			printCurrentOrderRightToLeft(root.left, l-1);
		}
	}
	public static void main(String[] args) {
		LevelOrderPrint tree = new LevelOrderPrint();
	       tree.root= new Node(1);
	       tree.root.left= new Node(2);
	       tree.root.right= new Node(3);
	       tree.root.left.left= new Node(4);
	       tree.root.left.right= new Node(5);
	       tree.root.right.right= new Node(7);
	       tree.root.right.left= new Node(6);
	       
	       System.out.println("Level order traversal of binary tree is ");
	       tree.printLevelOrder();
	       System.out.println();
	       System.out.println("Level order traversal of binary tree is from right to left");
	       tree.printLevelOrderRightToLeft();
	}
}
