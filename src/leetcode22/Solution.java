package leetcode22;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<String> generateParenthesis(int n) {
		ArrayList<String> list = new ArrayList<String>();
		String s = "";

		parenthesis(list, s, n, n);

		return list;
	}

	public void parenthesis(ArrayList<String> list, String s, Integer left, Integer right) {
		if (left == 0 && right == 0) {
			list.add(s);
		}

		if (left > 0) {
			parenthesis(list, s + '(', left - 1, right);
		}
		if (right > 0 && left < right) {
			parenthesis(list, s + ')', left, right - 1);
		}
	}
}
