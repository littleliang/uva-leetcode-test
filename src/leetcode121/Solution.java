package leetcode121;

public class Solution {
  public int maxProfit(int[] prices) {
    if (prices.length == 0)
      return 0;

    int maxPrice = prices[prices.length - 1];
    int ans = 0;
    for (int i = prices.length - 1; i >= 0; i--) {
      maxPrice = Math.max(maxPrice, prices[i]);
      ans = Math.max(ans, maxPrice - prices[i]);
    }

    return ans;
  }
}
