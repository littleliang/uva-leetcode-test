package leetcode416;

public class Solution {
  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int i : nums) {
      sum += i;
    }
    if (sum % 2 == 1) {
      return false;
    }
    boolean[][] dp = new boolean[sum / 2 + 1][nums.length + 1];
    for (int i = 0; i < sum / 2 + 1; i++) {
      for (int j = 0; j < nums.length + 1; j++) {
        dp[0][j] = true;
        dp[i][0] = false;
      }
      dp[0][0] = true;
    }

    for (int i = 1; i < sum / 2 + 1; i++) {
      for (int j = 1; j < nums.length + 1; j++) {
        if (i - nums[j - 1] >= 0) {
          dp[i][j] = dp[i][j - 1] || dp[i - nums[j - 1]][j - 1];
        } else {
          dp[i][j] = dp[i][j - 1];
        }
      }
    }
    return dp[sum / 2][nums.length];
  }
}
