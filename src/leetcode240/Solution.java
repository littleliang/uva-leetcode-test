package leetcode240;

public class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int n = matrix.length;
    if (n == 0) {
      return false;
    }
    int m = matrix[0].length;
    int i = 0;
    int j = m - 1;
    while (i < n && j >= 0) {
      if (target < matrix[i][j]) {
        j--;
      } else if (target > matrix[i][j]) {
        i++;
      } else {
        return true;
      }
    }
    return false;
  }
}
