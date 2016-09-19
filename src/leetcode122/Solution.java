package leetcode122;

public class Solution {
	public int maxProfit(int[] prices) {
		int p = 0;
		for (int i = 1; i < prices.length; ++i) {
			int delta = prices[i] - prices[i - 1];
			if (delta > 0) {
				p += delta;
			}
		}
		return p;
	}
}
