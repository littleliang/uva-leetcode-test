package leetcode354;

import java.util.Arrays;

public class Solution {
  public int maxEnvelopes(int[][] envelopes) {
    int n = envelopes.length;
    if (n <= 1) {
      return n;
    }
    Arrays.sort(envelopes, (x, y) -> (x[0] == y[0] ? y[1] - x[1] : x[0] - y[0]));
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
          if (dp[j] + 1 > dp[i]) {
            dp[i] = dp[j] + 1;
          }
        }
      }
    }
    Arrays.sort(dp);
    return dp[n - 1];
  }
}
