package leetcode393;

public class Solution {

	public boolean validUtf8(int[] data) {
		int count = 0;
		for (int val : data) {
			if (count == 0) {
				if ((val >> 5) == 6)
					count = 1;
				else if ((val >> 4) == 14)
					count = 2;
				else if ((val >> 3) == 30)
					count = 3;
				else if ((val >> 7) > 0)
					return false;
				continue;
			}
			if ((val >> 6) != 2)
				return false;
			count--;
		}
		return count == 0;
	}
}
