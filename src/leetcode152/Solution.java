package leetcode152;

public class Solution {
	public int maxProduct(int[] nums) {
		if (nums == null)
			return 0;
		if (nums.length == 1)
			return nums[0];
		int maxAll = nums[0];
		int maxLast = nums[0];
		int maxCur;
		int minLast = nums[0];
		int minCur;
		for (int i = 1; i < nums.length; i++) {
			maxCur = Math.max(nums[i], Math.max(maxLast * nums[i], minLast * nums[i]));
			minCur = Math.min(nums[i], Math.min(maxLast * nums[i], minLast * nums[i]));
			maxLast = maxCur;
			minLast = minCur;
			maxAll = Math.max(maxAll, maxCur);
		}
		return maxAll;
	}
}
