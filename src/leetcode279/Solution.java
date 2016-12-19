package leetcode279;

public class Solution {
  public int numSquares(int n) {
    int[] d = new int[n + 1];
    d[1] = 1;
    for (int i = 2; i <= n; i++) {
      int min = Integer.MAX_VALUE;
      int j = 1;
      while (j * j <= i) {
        if (j * j == i) {
          min = 1;
          break;
        }
        min = Math.min(min, d[i - j * j] + 1);
        ++j;
      }
      d[i] = min;
    }
    return d[n];
  }
}
