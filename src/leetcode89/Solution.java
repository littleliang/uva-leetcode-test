package leetcode89;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> grayCode(int n) {
		if (n == 0) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(0);
			return list;
		}
		if (n == 1) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(0);
			list.add(1);
			return list;
		}
		List<Integer> grayM = grayCode(n - 1);
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < Math.pow(2, n); i++) {
			if (i < Math.pow(2, n - 1)) {
				list.add(grayM.get(i));
			} else {
				int res = grayM.get((int) Math.pow(2, n) - i - 1) + (int) Math.pow(2, n - 1);
				list.add(res);
			}
		}
		return list;
	}

}
