package stack;

import java.util.LinkedList;
import java.util.Queue;

public class CreatingStackFromQueues {

	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();

	public static void main(String[] args) {
		CreatingStackFromQueues s = new CreatingStackFromQueues();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);

		System.out.println(s.q1);
		s.pop();
		System.out.println(s.q1);
		System.out.println(s.top());
		System.out.println(s.q1);

	}

	private void pop() {
		if (q1.isEmpty()) {
			return;
		} else {
			q1.remove();
		}
	}

	private void push(int data) {

		q2.add(data);

		while (!q1.isEmpty()) {
			q2.add(q1.peek());
			q1.remove();
		}
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
	}

	private int top() {
		if(q1.isEmpty()) {
			return -1;
		}
		else {
			return q1.peek();
		}
	}
}
