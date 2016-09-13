package leetcode118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<List<Integer>> generate(int numRows) {

		List<List<Integer>> lists = new ArrayList<>();
		if (numRows <= 0)
			return lists;
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		lists.add(list1);
		if (numRows == 1)
			return lists;
		List<Integer> oldList = null;
		for (int i = 2; i <= numRows; ++i) {
			List<Integer> newList = new ArrayList<Integer>();
			newList.add(1);
			newList.add(1);
			for (int j = 1; j < i - 1; ++j) {
				newList.add(j, oldList.get(j) + oldList.get(j - 1));
			}
			lists.add(newList);
			oldList = newList;
		}
		return lists;
	}
}
