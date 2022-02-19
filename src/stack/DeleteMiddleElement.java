package stack;

import java.util.Stack;

public class DeleteMiddleElement {
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		
		System.out.println(s);
		deleteMiddleElement(s,s.size());
		System.out.println(s);

	}

	private static void deleteMiddleElement(Stack<Integer> s,int size) {

		if(s.size()-1==Math.ceil(size/2)) {
			s.pop();
			return;
		}
		
		int temp=s.pop();
		deleteMiddleElement(s,size);
		s.push(temp);
	}

}
