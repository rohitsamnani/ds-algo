package queue;

import java.util.Stack;

public class MaxStack {
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> maxStack = new Stack<>();
	public static void main(String[] args) {
		MaxStack obj = new MaxStack();
		obj.push(-2);
		obj.push(-3);
		obj.push(10);
		System.out.println(obj.getMax());
		obj.pop();
		System.out.println(obj.top());
		System.out.println(obj.getMax());
	}

	private int getMax() {
		return maxStack.peek();
	}

	private int top() {
		return stack.peek();
	}

	private void pop() {
		int ele = stack.pop();
		if(ele==maxStack.peek()) {
			maxStack.pop();
		}
	}

	private void push(int val) {
		if(maxStack.size()==0 || maxStack.peek()<=val) {
			maxStack.push(val);
		}
		stack.push(val);
		
	}

}
