package leetcode223;

public class Solution {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int res = (D - B) * (C - A) + (G - E) * (H - F);
		int A1 = Math.max(A, E), B1 = Math.max(B, F), C1 = Math.min(C, G), D1 = Math.min(D, H);
		if (A1 >= C1 || B1 >= D1) {
			return res;
		} else {
			return res - (C1 - A1) * (D1 - B1);
		}
	}
}
