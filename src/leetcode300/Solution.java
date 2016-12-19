package leetcode300;

public class Solution {
  public int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int max = 1;
    int[] res = new int[nums.length];
    res[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      res[i] = 1;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j] && res[j] + 1 > res[i]) {
          res[i] = res[j] + 1;
        }
      }
      if (res[i] > max) {
        max = res[i];
      }
    }
    return max;
  }
}
