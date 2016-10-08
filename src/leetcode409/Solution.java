package leetcode409;

public class Solution {
	public int longestPalindrome(String s) {
		char chars[] = s.toCharArray();
		int lowerCount[] = new int[26];
		int upperCount[] = new int[26];
		int odds = 0;
		int n = s.length();
		for (int i = 0; i < n; i++) {
			if (chars[i] < 'a')
				upperCount[chars[i] - 'A']++;
			else
				lowerCount[chars[i] - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			if (lowerCount[i] % 2 == 1)
				odds++;
			if (upperCount[i] % 2 == 1)
				odds++;
		}
		if (odds == 0)
			return n;
		else
			return n - odds + 1;

	}
}
