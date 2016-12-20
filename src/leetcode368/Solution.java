package leetcode368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
  public List<Integer> largestDivisibleSubset(int[] nums) {
    List<Integer> res = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return res;
    }
    int n = nums.length;
    Arrays.sort(nums);
    int[] dp = new int[n];
    int[] before = new int[n];
    int maxLength = 0;
    int endIndex = 0;
    Arrays.fill(before, -1);
    Arrays.fill(dp, 1);
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] % nums[j] == 0) {
          if (dp[j] + 1 > dp[i]) {
            dp[i] = dp[j] + 1;
            before[i] = j;
          }
        }
      }
      if (dp[i] > maxLength) {
        maxLength = dp[i];
        endIndex = i;
      }
    }
    while (before[endIndex] != -1) {
      res.add(nums[endIndex]);
      endIndex = before[endIndex];
    }
    res.add(nums[endIndex]);
    Collections.sort(res);
    return res;
  }
}
