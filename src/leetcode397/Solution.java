package leetcode397;

public class Solution {
	public int integerReplacement(int n) {
		int res = 0;
		int count = 0;
		while (n > 1) {
			if (n % 2 == 0) {
				if (count < 2) {
					res += 2 * count;
					count = 0;
				} else {
					res += count + 1;
					count = 0;
					n = n + 1;
					continue;
				}
				res += 1;
			} else {
				count++;
			}
			n = n >> 1;
		}
		if (count < 2) {
			res += 2 * count;
		} else {
			res += count + 2;
		}
		return res;
	}
}
