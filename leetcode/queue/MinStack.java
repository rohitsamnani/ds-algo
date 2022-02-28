package queue;

import java.util.Stack;

class MinStack {
	Stack<Integer> st = new Stack<>();
	Stack<Integer> minStack = new Stack<>();

	public MinStack() {

	}

	public void push(int val) {
		if (minStack.size() == 0 || minStack.peek() >= val) {
			minStack.push(val);
		}

		st.push(val);
	}

	public void pop() {
		int item = st.pop();
		if (item == minStack.peek()) {
			minStack.pop();
		}
	}

	public int top() {
		return st.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

	public static void main(String[] args) {
		
		//["MinStack","push","push","push","getMin","pop","top","getMin"]
		//[[],[-2],[0],[-3],[],[],[],[]]
		
		MinStack obj = new MinStack();
		obj.push(-2);
		obj.push(0);
		obj.push(-3);
		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.top());
		System.out.println(obj.getMin());
	}

}
