package leetcode322;

public class Solution {
  public int coinChange(int[] coins, int amount) {
    int[] res = new int[amount + 1];
    res[0] = 0;
    for (int i = 1; i <= amount; i++) {
      res[i] = Integer.MAX_VALUE;
      for (int j : coins) {
        if (i - j >= 0) {
          if (res[i] > res[i - j]) {
            res[i] = res[i - j] + 1;
          }
        }
      }
    }
    return res[amount] == Integer.MAX_VALUE ? -1 : res[amount];
  }
}
