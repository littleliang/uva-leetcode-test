package leetcode115;

public class Solution {
  public int numDistinct(String s, String t) {
    if (s == null || t == null || s.length() < t.length()) {
      return 0;
    }
    int n = s.length();
    int m = t.length();
    int[][] dp = new int[2][n + 1];
    dp[0][0] = (t.charAt(0) == s.charAt(0)) ? 1 : 0;
    for (int i = 1; i < n; i++) {
      dp[0][i] = (t.charAt(0) == s.charAt(i)) ? dp[0][i - 1] + 1 : dp[0][i - 1];
    }
    int index = 0;
    for (int i = 1; i < m; i++) {
      index = 1 - index;
      for (int j = 0; j < n; j++) {
        dp[index][j] = (j < i) ? 0
            : (s.charAt(j) == t.charAt(i)) ? dp[1 - index][j - 1] + dp[index][j - 1]
                : dp[index][j - 1];
      }
    }
    return dp[index][n - 1];
  }
}
