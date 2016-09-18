package leetcode384;

import java.util.Arrays;
import java.util.Random;

public class Solution {

	private int[] origin;
	private int[] data;

	public Solution(int[] nums) {
		origin = Arrays.copyOf(nums, nums.length);
		data = Arrays.copyOf(nums, nums.length);
	}

	public int[] reset() {
		return origin;
	}

	public int[] shuffle() {
		Random random = new Random();
		for (int i = data.length - 1; i >= 0; --i) {
			int index = random.nextInt(i + 1);
			int temp = data[i];
			data[i] = data[index];
			data[index] = temp;
		}
		return data;
	}
}
