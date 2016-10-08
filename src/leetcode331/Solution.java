package leetcode331;

public class Solution {
	public boolean isValidSerialization(String preorder) {
		String[] strs = preorder.split(",");
		int degree = -1;
		for (String str : strs) {
			degree++;
			if (degree > 0) {
				return false;
			}
			if (!str.equals("#")) {
				degree -= 2;
			}
		}
		return degree == 0;
	}
}
