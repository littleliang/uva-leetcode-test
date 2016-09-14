package leetcode28;

public class Solution {

	public String strStr(String haystack, String needle) {
		if (haystack.length() <= 0)
			return null;
		int i = haystack.indexOf(needle);
		if (i == -1)
			return null;
		else {
			return haystack.substring(i);
		}
	}
}
