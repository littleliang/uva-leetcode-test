package leetcode238;

public class Solution {
	public int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		res[res.length - 1] = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			res[i] = res[i + 1] * nums[i + 1];
		}

		int left = 1;
		for (int i = 0; i < nums.length; i++) {
			res[i] *= left;
			left *= nums[i];
		}
		return res;
	}
}
