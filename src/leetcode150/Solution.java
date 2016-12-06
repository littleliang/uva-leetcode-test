package leetcode150;

import java.util.Stack;

public class Solution {
  public int evalRPN(String[] tokens) {
    if (tokens == null || tokens.length < 1) {
      throw new IllegalArgumentException();
    }
    int op1;
    int op2;
    Stack<Integer> stack = new Stack<>();
    for (String token : tokens) {
      if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
        op2 = stack.pop();
        op1 = stack.pop();
        switch (token.charAt(0)) {
          case '+':
            op1 += op2;
            break;
          case '-':
            op1 -= op2;
            break;
          case '*':
            op1 *= op2;
            break;
          case '/':
            op1 /= op2;
            break;
        }
        stack.push(op1);
      }
      else {
        stack.push(Integer.parseInt(token));
      }
    }
    return stack.pop();
  }
}
