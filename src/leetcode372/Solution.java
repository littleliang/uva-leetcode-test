package leetcode372;

public class Solution {
	public boolean morethanzero(int[] x) {
		for (int i = x.length - 1; i >= 0; i--) {
			if (x[i] > 0)
				return true;
		}
		return false;
	}

	public void div(int[] x, int y) {
		int tmp = 0;
		for (int i = 0; i < x.length; i++) {
			x[i] += tmp * 10;
			tmp = x[i] % y;
			x[i] = x[i] / y;
		}

	}

	public int superPow(int a, int[] b) {
		if (morethanzero(b) == false)
			return 1;
		a = a % 1337;
		boolean isEven = false;
		if (b[b.length - 1] % 2 == 0)
			isEven = true;
		div(b, 2);
		int result = superPow(a, b);
		result = result % 1337;
		result *= result;
		result = result % 1337;
		if (isEven == false) {
			result *= a;
			result = result % 1337;
		}
		return result;
	}
}