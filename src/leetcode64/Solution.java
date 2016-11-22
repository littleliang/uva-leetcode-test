package leetcode64;

public class Solution {
  public int minPathSum(int[][] grid) {
    int n = grid.length;
    if (n == 0) {
      return 0;
    }
    int m = grid[0].length;
    int[][] res = new int[n][m];
    res[0][0] = grid[0][0];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (i == 0 && j > 0) {
          res[i][j] = res[i][j - 1] + grid[i][j];
        } else if (j == 0 && i > 0) {
          res[i][j] = res[i - 1][j] + grid[i][j];
        } else if (i > 0 && j > 0) {
          res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + grid[i][j];
        }
      }
    }
    return res[n - 1][m - 1];
  }
}
