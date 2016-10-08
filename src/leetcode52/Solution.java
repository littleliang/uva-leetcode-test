package leetcode52;

public class Solution {
	private int res = 0;

	public int totalNQueens(int n) {
		int[] queenList = new int[n];
		placeQueen(queenList, 0, n);
		return res;
	}

	private void placeQueen(int[] queenList, int row, int n) {
		if (row == n) {
			res++;
		}
		for (int col = 0; col < n; col++) {
			if (isValid(queenList, row, col)) {
				queenList[row] = col;
				placeQueen(queenList, row + 1, n);
			}
		}
	}

	private boolean isValid(int[] queenList, int row, int col) {
		for (int i = 0; i < row; i++) {
			int pos = queenList[i];
			if (pos == col) {
				return false;
			}
			if (pos + row - i == col) {
				return false;
			}
			if (pos - row + i == col) {
				return false;
			}
		}
		return true;
	}
}
