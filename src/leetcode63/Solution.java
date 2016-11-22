package leetcode63;

public class Solution {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    if (obstacleGrid[0][0] == 1) {
      return 0;
    } else if (m == 1 && n == 1) {
      return 1;
    }
    int[][] paths = new int[m][n];
    for (int i = 0; i < m; ++i) {
      if (obstacleGrid[i][0] == 1) {
        while (i < m) {
          paths[i][0] = 0;
          ++i;
        }
        break;
      } else {
        paths[i][0] = 1;
      }
    }
    for (int j = 1; j < n; ++j) {
      if (obstacleGrid[0][j] == 1) {
        while (j < n) {
          paths[0][j] = 0;
          ++j;
        }
        break;
      } else {
        paths[0][j] = 1;
      }
    }
    for (int i = 1; i < m; ++i) {
      for (int j = 1; j < n; ++j) {
        if (obstacleGrid[i][j] == 1) {
          paths[i][j] = 0;
        } else {
          paths[i][j] = paths[i][j - 1] + paths[i - 1][j];
        }
      }
    }
    return paths[m - 1][n - 1];
  }
}
