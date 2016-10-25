package leetcode97;

public class Solution {
  public boolean isInterleave(String s1, String s2, String s3) {
    int row = s1.length();
    int col = s2.length();
    int length = s3.length();
    if (row + col != length)
      return false;
    if (row == 0)
      return s2.equals(s3);
    else if (col == 0)
      return s1.equals(s3);

    boolean[][] matrix = new boolean[row + 1][col + 1];
    matrix[0][0] = true;

    for (int i = 1; i <= s1.length(); i++) {
      if (s3.startsWith(s1.substring(0, i)))
        matrix[i][0] = true;
      else
        break;
    }

    for (int i = 1; i <= s2.length(); i++) {
      if (s3.startsWith(s2.substring(0, i)))
        matrix[0][i] = true;
      else
        break;
    }

    for (int i = 1; i <= row; i++) {
      for (int j = 1; j <= col; j++) {
        int k = i + j;
        if (s1.charAt(i - 1) == s3.charAt(k - 1)) {
          matrix[i][j] = matrix[i - 1][j] || matrix[i][j];
        }
        if (s2.charAt(j - 1) == s3.charAt(k - 1)) {
          matrix[i][j] = matrix[i][j - 1] || matrix[i][j];
        }
      }
    }
    return matrix[row][col];
  }
}
