package leetcode85;

import java.util.Arrays;

public class Solution {
  public int maximalRectangle(char[][] matrix) {
    if (matrix == null || matrix.length == 0)
      return 0;
    int m = matrix.length;
    int n = matrix[0].length;
    int[] left = new int[n];
    int[] right = new int[n];
    int[] height = new int[n];
    Arrays.fill(right, n);
    int max = 0;
    for (int i = 0; i < m; i++) {
      int curleft = 0;
      int curright = n;
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == '1') {
          height[j] += 1;
        } else {
          height[j] = 0;
        }
      }
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == '1') {
          left[j] = Math.max(left[j], curleft);
        } else {
          left[j] = 0;
          curleft = j + 1;
        }
      }
      for (int j = n - 1; j >= 0; j--) {
        if (matrix[i][j] == '1') {
          right[j] = Math.min(right[j], curright);
        } else {
          right[j] = n;
          curright = j;
        }
      }
      for (int j = 0; j < n; j++) {
        max = Math.max(max, (right[j] - left[j]) * height[j]);
      }
    }
    return max;
  }
}
