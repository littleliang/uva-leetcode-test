package leetcode33;

public class Solution {
	public int search(int[] nums, int target) {
		if (nums == null)
			return -1;
		int start = 0;
		int end = nums.length - 1;
		int mid;
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > nums[start]) {
				if (target >= nums[start] && target <= nums[mid])
					end = mid;
				else
					start = mid;
			} else {
				if (target >= nums[mid] && target <= nums[end])
					start = mid;
				else
					end = mid;
			}
		}
		if (nums[start] == target)
			return start;
		if (nums[end] == target)
			return end;
		return -1;
	}
}
