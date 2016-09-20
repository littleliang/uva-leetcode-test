package leetcode216;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	List<List<Integer>> result;
	List<Integer> solu;
	int[] candidate = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	int knum;

	public List<List<Integer>> combinationSum3(int k, int n) {
		knum = k;
		result = new ArrayList<>();
		solu = new ArrayList<>();
		Arrays.sort(candidate);
		getCombination(candidate, n, 0, 0, 0);
		return result;
	}

	public void getCombination(int[] candidates, int target, int sum, int level, int k) {
		if (sum > target || k > knum)
			return;
		if (sum == target && k == knum) {
			result.add(new ArrayList<>(solu));
			return;
		}
		for (int i = level; i < candidates.length; i++) {
			sum += candidates[i];
			solu.add(candidates[i]);
			getCombination(candidates, target, sum, i + 1, k + 1);
			solu.remove(solu.size() - 1);
			sum -= candidates[i];
		}
	}

}
