package leetcode90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	private List<List<Integer>> res;
	private List<Integer> sol;

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		res = new ArrayList<>();
		sol = new ArrayList<>();
		res.add(new ArrayList<>(sol));
		Arrays.sort(nums);
		travel(nums, 0, sol);
		return res;
	}

	private void travel(int[] nums, int start, List<Integer> sol) {
		if (start >= nums.length) {
			return;
		}
		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1]) {
				continue;
			}
			sol.add(nums[i]);
			res.add(new ArrayList<>(sol));
			travel(nums, i + 1, sol);
			sol.remove(sol.size() - 1);
		}
	}
}
