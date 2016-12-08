package leetcode169;

import java.util.Stack;

public class Solution {
  public int majorityElement(int[] nums) {
    Stack<Integer> stack = new Stack<>();
    stack.push(nums[0]);
    for (int i = 1; i < nums.length; i++) {
      if (stack.isEmpty() || nums[i] == stack.peek()) {
        stack.push(nums[i]);
      } else {
        stack.pop();
      }
    }
    return stack.peek();
  }
}
