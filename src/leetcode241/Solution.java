package leetcode241;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<Integer> diffWaysToCompute(String s) {
    String[] arr = s.split("[\\+\\-\\*\\/]");
    String[] ops = s.split("\\d+");
    int n = arr.length;
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = Integer.parseInt(arr[i].trim());
    }
    return diffWays(nums, ops, 0, n - 1);
  }

  public List<Integer> diffWays(int[] nums, String[] ops, int left, int right) {
    List<Integer> list = new ArrayList<>();
    if (left == right) {
      list.add(nums[left]);
      return list;
    }
    for (int i = left + 1; i <= right; i++) {
      List<Integer> list1 = diffWays(nums, ops, left, i - 1);
      List<Integer> list2 = diffWays(nums, ops, i, right);
      for (int num1 : list1) {
        for (int num2 : list2) {
          switch (ops[i].charAt(0)) {
            case '+':
              list.add(num1 + num2);
              break;
            case '-':
              list.add(num1 - num2);
              break;
            case '*':
              list.add(num1 * num2);
              break;
            case '/':
              list.add(num1 / num2);
              break;
          }
        }
      }
    }
    return list;
  }
}
