package leetcode123;

public class Solution {
  public int maxProfit(int[] prices) {
    if (prices.length == 0) {
      return 0;
    }
    int[] leftProfit = new int[prices.length];
    int[] rightProfit = new int[prices.length];
    int minPrice = prices[0];
    for (int i = 0; i < prices.length; ++i) {
      if (prices[i] < minPrice) {
        minPrice = prices[i];
      }
      leftProfit[i] = prices[i] - minPrice;
      if (i != 0 && leftProfit[i] < leftProfit[i - 1]) {
        leftProfit[i] = leftProfit[i - 1];
      }
    }
    int maxPrice = prices[prices.length - 1];
    for (int i = prices.length - 1; i >= 0; --i) {
      if (prices[i] > maxPrice) {
        maxPrice = prices[i];
      }
      rightProfit[i] = maxPrice - prices[i];
      if (i != prices.length - 1 && rightProfit[i] < rightProfit[i + 1]) {
        rightProfit[i] = rightProfit[i + 1];
      }
    }
    int finalResult = 0;
    for (int i = 0; i < prices.length; ++i) {
      int result = leftProfit[i] + rightProfit[i];
      if (result > finalResult) {
        finalResult = result;
      }
    }
    return finalResult;
  }
}
