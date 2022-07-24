package graph;

public class Node {
	
	int firstNode;
	int secondNode;
	
	public Node(int firstNode, int secondNode) {
		this.firstNode=firstNode;
		this.secondNode= secondNode;
	}
	
	public int getKey() {
		return this.firstNode;
	}
	
	public int getValue() {
		return this.secondNode ;
	}
}
