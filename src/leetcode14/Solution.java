package leetcode14;

public class Solution {
	public String longestCommonPrefix(String[] strs) {
		int length = Integer.MAX_VALUE;
		StringBuilder stringbuilder = new StringBuilder();
		if (strs.length == 0 || strs == null)
			return "";
		if (strs.length == 1)
			return strs[0];
		for (int i = 0; i < strs.length; i++) {
			length = (strs[i].length() < length) ? strs[i].length() : length;
		}
		if (length == 0)
			return "";
		for (int j = 0; j < length; j++) {
			for (int i = 0; i < strs.length; i++) {
				if (strs[i].charAt(j) != strs[0].charAt(j))
					return stringbuilder.toString();
			}
			stringbuilder.append(strs[0].charAt(j));
		}
		return stringbuilder.toString();
	}
}
