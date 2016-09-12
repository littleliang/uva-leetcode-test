package leetcode155;

import java.util.Stack;

public class MinStack {

	private Stack<Integer> stack;
	private Stack<Integer> minstack;

	public MinStack() {
		stack = new Stack<>();
		minstack = new Stack<>();
	}

	public void push(int x) {
		stack.push(x);
		if (minstack.isEmpty()) {
			minstack.push(x);
		} else {
			minstack.push(Math.min(x, minstack.peek()));
		}

	}

	public void pop() {
		stack.pop();
		minstack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minstack.peek();
	}
}
