package leetcode151;

public class Solution {
	public String reverseWords(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (start <= end && s.charAt(start) == ' ') {
			start++;
		}
		while (start <= end && s.charAt(end) == ' ') {
			end--;
		}
		if (start > end)
			return "";
		StringBuilder r = new StringBuilder();
		while (start <= end) {
			StringBuilder temp = new StringBuilder();
			while (start <= end && s.charAt(end) != ' ') {
				temp.append(s.charAt(end));
				end--;
			}
			temp.reverse();
			r.append(temp + " ");
			while (start <= end && s.charAt(end) == ' ') {
				end--;
			}
		}
		return r.substring(0, r.length() - 1).toString();
	}

}
