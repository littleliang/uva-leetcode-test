package leetcode213;

public class Solution {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		return Math.max(robsub(nums, 0, nums.length - 2), robsub(nums, 1, nums.length - 1));
	}

	public int robsub(int[] nums, int s, int e) {
		int n = e - s + 1;
		int[] robSum = new int[n];
		robSum[0] = nums[s];
		robSum[1] = Math.max(nums[s], nums[s + 1]);

		for (int i = 2; i < n; i++) {
			robSum[i] = Math.max(robSum[i - 1], robSum[i - 2] + nums[s + i]);
		}
		return robSum[n - 1];
	}

}