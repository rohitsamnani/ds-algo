package stack;

import java.util.Stack;

public class CreatingQueueFromStack {
	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();

	public static void main(String[] args) {

		CreatingQueueFromStack q = new CreatingQueueFromStack();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		System.out.println(q.s1);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.s1);
	}

	private int dequeue() {

		if(s1.isEmpty()) {
			System.exit(0);
		}
		int data= s1.peek();
		s1.pop();
		return data;
	}

	private void enqueue(int data) {
		
		while(!s1.isEmpty()) {
			s2.push(s1.peek());
			s1.pop();
		}
		s1.push(data);
		
		while(!s2.isEmpty()) {
			s1.push(s2.peek());
			s2.pop();
		}
	}
}
