package leetcode375;

public class Solution {
	private int[][] amounts;

	private int min(int from, int to) {
		if (from >= to)
			return 0;
		if (amounts[from][to] > 0)
			return amounts[from][to];
		int min = Integer.MAX_VALUE;
		for (int i = from; i <= to; i++) {
			min = Math.min(min, max(from, to, i));
		}
		amounts[from][to] = min;
		return min;
	}

	private int max(int from, int to, int guess) {
		if (from >= to)
			return 0;
		int max = guess + Math.max(min(from, guess - 1), min(guess + 1, to));
		return max;
	}

	public int getMoneyAmount(int n) {
		amounts = new int[n + 1][n + 1];
		return min(1, n);
	}
}
