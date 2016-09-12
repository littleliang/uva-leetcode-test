package leetcode303;

public class NumArray {
	int[] sums;

	public NumArray(int[] nums) {
		sums = new int[nums.length];
		System.arraycopy(nums, 0, sums, 0, nums.length);
		for (int i = 1; i < sums.length; i++) {
			sums[i] += sums[i - 1];
		}
	}

	public int sumRange(int i, int j) {
		if (i > j || i < 0 || j < 0 || j >= sums.length)
			return 0;
		return i == 0 ? sums[j] : (sums[j] - sums[i - 1]);
	}
}
