package leetcode59;

public class Solution {
  public int[][] generateMatrix(int n) {
    int[][] result = new int[n][n];
    int index = 0;
    int num = n * n;
    int row = 0, col = -1;
    while (index < num) {
      for (col = col + 1; col < n; col++) {
        if (result[row][col] != 0)
          break;
        result[row][col] = ++index;
      }
      col--;
      for (row = row + 1; row < n; row++) {
        if (result[row][col] != 0)
          break;
        result[row][col] = ++index;
      }
      row--;
      for (col = col - 1; col >= 0; col--) {
        if (result[row][col] != 0)
          break;
        result[row][col] = ++index;
      }
      col++;
      for (row = row - 1; row >= 0; row--) {
        if (result[row][col] != 0)
          break;
        result[row][col] = ++index;
      }
      row++;
    }
    return result;
  }
}
