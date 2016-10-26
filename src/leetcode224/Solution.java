package leetcode224;

import java.util.Stack;

public class Solution {
  public int calculate(String s) {
    Stack<Integer> stack = new Stack<>();
    int result = 0;
    int number = 0;
    int sign = 1;
    for (char c : s.toCharArray()) {
      if (Character.isDigit(c)) {
        number = number * 10 + c - '0';
      } else if (c == '+') {
        result += sign * number;
        number = 0;
        sign = 1;
      } else if (c == '-') {
        result += sign * number;
        number = 0;
        sign = -1;
      } else if (c == '(') {
        stack.push(result);
        stack.push(sign);
        result = 0;
        sign = 1;
      } else if (c == ')') {
        result += sign * number;
        result *= stack.pop();
        result += stack.pop();
        number = 0;
      }
    }
    result += sign * number;
    return result;
  }
}
