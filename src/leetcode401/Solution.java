package leetcode401;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<String> readBinaryWatch(int k) {
		List<String> res = new ArrayList<String>();

		for (int h = 0; h <= k; h++) {
			dspCombination(hour, h, 0, true);
			dspCombination(minu, k - h, 0, false);

			for (int i : hs) {
				for (int j : ms) {
					if (j == 0)
						res.add("" + i + ":00");
					else {
						if (j / 10 == 0)
							res.add("" + i + ":0" + j);
						else {
							res.add("" + i + ":" + j);
						}
					}
				}
			}

			hs.clear();
			ms.clear();
		}

		return res;
	}

	int hour[] = new int[] { 1, 2, 4, 8 };
	int minu[] = new int[] { 1, 2, 4, 8, 16, 32 };
	List<Integer> list = new ArrayList<Integer>();
	List<Integer> hs = new ArrayList<Integer>();
	List<Integer> ms = new ArrayList<Integer>();

	private void dspCombination(int[] nums, int k, int level, boolean flag) {
		if (list.size() == k) {
			int sum = 0;
			for (int num : list) {
				sum += num;
			}
			if (flag) {// 当前是hour
				if (sum <= 11)
					hs.add(sum);
			} else {
				if (sum <= 59)
					ms.add(sum);
			}
			return;
		} else if (list.size() > k) {
			return;
		} else {
			for (int i = level; i < nums.length; i++) {
				list.add(nums[i]);
				dspCombination(nums, k, i + 1, flag);
				list.remove(list.size() - 1);
			}
		}
	}
}
