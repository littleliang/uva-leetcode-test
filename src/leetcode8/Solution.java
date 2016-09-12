package leetcode8;

public class Solution {

	public int myAtoi(String str) {
		if (str == null)
			return 0;
		str = str.trim();
		int len = str.length();
		if (len == 0)
			return 0;
		char signal = '+';
		int i = 0;
		char ch = str.charAt(i);
		double result = 0;
		while (i < len) {
			ch = str.charAt(i);
			if (ch == '-' || ch == '+') {
				if (i != 0)
					return 0;
				if (ch == '-')
					signal = '-';
			} else if (ch >= '0' && ch <= '9') {
				result = result * 10 + (str.charAt(i) - '0');
			} else if (ch < '0' || ch > '9') {
				break;
			}
			i++;
		}
		if (signal == '-')
			result = -1 * result;
		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		return (int) result;
	}
}
