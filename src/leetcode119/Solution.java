package leetcode119;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> getRow(int rowIndex) {
		if (rowIndex < 0) {
			return null;
		}
		rowIndex++;
		List<Integer> list = new ArrayList<>();
		list.add(1);
		for (int row = 0; row < rowIndex; row++) {
			int tmp = 1;
			for (int col = 1; col <= row; col++) {
				if (col < list.size()) {
					int tmp2 = list.get(col);
					list.set(col, tmp + list.get(col));
					tmp = tmp2;
				} else {
					list.add(1);
				}
			}
		}
		return list;
	}
}
