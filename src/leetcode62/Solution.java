package leetcode62;

public class Solution {
	public int uniquePaths(int m, int n) {
		int S = m + n - 2, M = m - 1;
		double sum = 1;
		for (int i = 1; i <= M; i++) {
			sum = sum * (S - M + i) / i;
		}
		return (int) sum;
	}
}