package leetcode232;

import java.util.Stack;

class MyQueue {
  private Stack<Integer> stackIn = new Stack<>();
  private Stack<Integer> stackOut = new Stack<>();

  public void push(int x) {
    stackIn.push(x);
  }

  public void pop() {
    if (!stackOut.isEmpty()) {
      stackOut.pop();
    } else {
      while (!stackIn.isEmpty()) {
        stackOut.push(stackIn.peek());
        stackIn.pop();
      }
      stackOut.pop();
    }
  }

  public int peek() {
    if (!stackOut.isEmpty()) {
      return stackOut.peek();
    } else {
      while (!stackIn.isEmpty()) {
        stackOut.push(stackIn.peek());
        stackIn.pop();
      }
      return stackOut.peek();
    }
  }

  public boolean empty() {
    return stackIn.isEmpty() && stackOut.isEmpty();
  }
}
