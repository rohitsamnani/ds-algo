package tree;

//TBC
public class TurnTreeUpSideDown {
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
	    turnIt(root);   
	}

	private static void turnIt(Node root) {
	}
}
