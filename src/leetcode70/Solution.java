package leetcode70;


public class Solution {
    public int climbStairs(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}

		int res = 0;
		int temp;
		int pathBeforeTwoStep = 1;
		int pathBeforeOneStep = 1;

		for (int i = 2; i <= n; i++) {
			temp = pathBeforeTwoStep + pathBeforeOneStep;
			res = temp;
			pathBeforeTwoStep = pathBeforeOneStep;
			pathBeforeOneStep = res;
		}

		return res;
    }
}
