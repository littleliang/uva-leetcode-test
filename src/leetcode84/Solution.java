package leetcode84;

import java.util.Stack;

public class Solution {
  public int largestRectangleArea(int[] height) {
    Stack<Integer> stack = new Stack<>();
    int n = height.length;
    int maxarea = 0;
    int i = 0;
    int temp = 0;
    int tempTop = 0;
    while (i <= n) {
      temp = (i == n ? 0 : height[i]);
      if (stack.isEmpty() || height[stack.peek()] <= temp) {
        stack.push(i);
        i++;
      } else {
        tempTop = height[stack.pop()];
        maxarea = Math.max(maxarea, tempTop * (stack.isEmpty() ? i : i - 1 - stack.peek()));
      }
    }
    return maxarea;
  }
}
