package leetcode73;

public class Solution {
  public void setZeroes(int[][] matrix) {
    int height = matrix.length;
    if (height == 0) {
      return;
    }
    int width = matrix[0].length;
    int col0 = 1;
    for (int i = 0; i < height; ++i) {
      if (matrix[i][0] == 0) {
        col0 = 0;
      }
      for (int j = 1; j < width; ++j) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }
    for (int i = height - 1; i >= 0; --i) {
      for (int j = width - 1; j >= 1; --j) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
      if (col0 == 0) {
        matrix[i][0] = 0;
      }
    }
  }
}
