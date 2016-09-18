package leetcode347;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> list = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		int len = nums.length, i = 0;

		for (; i < len; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else {
				map.put(nums[i], map.get(nums[i]) + 1);
			}
		}

		List<Map.Entry<Integer, Integer>> list1 = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());

		Collections.sort(list1, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2) {
				return (m2.getValue() - m1.getValue());
			}
		});

		for (i = 0; i < k; i++) {
			int num = list1.get(i).getKey();
			list.add(num);
		}

		return list;
	}
}
