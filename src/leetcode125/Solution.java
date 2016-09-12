package leetcode125;

public class Solution {
	public boolean isPalindrome(String s) {

		if (s == null) {
			return false;
		}
		s = s.toLowerCase();
		int left = 0;
		int right = s.length() - 1;

		char l;
		char r;

		while (left < right) {
			while (left < s.length() && !isAlphanumericCharacters(s.charAt(left))) {
				left++;
			}

			while (right >= 0 && !isAlphanumericCharacters(s.charAt(right))) {
				right--;
			}

			if (left < right) {
				l = s.charAt(left);
				r = s.charAt(right);
				if (l == r) {
					left++;
					right--;
				} else {
					return false;
				}
			}
		}

		return true;
	}

	private boolean isAlphanumericCharacters(char c) {
		return c >= '0' && c <= '9' || c >= 'a' && c <= 'z';
	}
}
