package leetcode377;

public class Solution {

	public int combinationSum4(int[] nums, int target) {
		if (nums.length == 0)
			return 0;
		int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int i = 1; i <= target; i++) {
			for (int val : nums)
				if (val <= i)
					dp[i] += dp[i - val];
		}
		return dp[target];
	}
}
