package leetcode172;

public class Solution {
  public int trailingZeroes(int n) {
    int res = 0;
    while (n > 0) {
      int k = n / 5;
      res += k;
      n = k;
    }
    return res;
  }
}
