package leetcode440;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  public int findKthNumber(int n, int k) {
    Deque<Integer> stack = new ArrayDeque<>();
    int count = 0;
    for (int i = 1; i < 10; i++) {
      stack.push(i);
      while (!stack.isEmpty()) {
        int current = stack.pop();
        if (k == ++count)
          return current;
        int countInSubtree = count(n, current);
        if (countInSubtree + count < k) {
          count = countInSubtree + count - 1;
        } else {
          for (int j = 9; j >= 0; j--) {
            int nextVal = Integer.parseInt("" + current + j);
            if (nextVal <= n) {
              stack.push(nextVal);
            }
          }
        }
      }
    }
    return -1;
  }

  public int count(int n, long val) {
    int ans = 0;
    int number = 1;
    while (val <= n) {
      ans += number;
      val *= 10;
      number *= 10;
    }
    if (n < (val / 10 + number / 10 - 1))
      ans -= val / 10 + number / 10 - 1 - n;
    return ans;
  }
}
