package leetcode390;

public class Solution {
	public int lastRemaining(int n) {
		return f(n, true);
	}

	public int f(int n, boolean flag) {
		if (n <= 2) {
			return flag ? n : 1;
		} else {
			return 2 * f(n / 2, !flag) - (((n & 1) == 0 && !flag) ? 1 : 0);
		}
	}
}
