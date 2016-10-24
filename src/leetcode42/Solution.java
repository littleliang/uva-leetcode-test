package leetcode42;

import java.util.Stack;

public class Solution {
  public int trap(int[] A) {
    if (A == null)
      return 0;
    Stack<Integer> s = new Stack<Integer>();
    int i = 0;
    int maxWater = 0;
    int maxBotWater = 0;
    while (i < A.length) {
      if (s.isEmpty() || A[i] <= A[s.peek()]) {
        s.push(i++);
      } else {
        int bot = s.pop();
        maxBotWater = s.isEmpty() ? 0 : (Math.min(A[s.peek()], A[i]) - A[bot]) * (i - s.peek() - 1);
        maxWater += maxBotWater;
      }
    }
    return maxWater;
  }
}
