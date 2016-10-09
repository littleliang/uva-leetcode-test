package leetcode50;

public class Solution {
  public double myPow(double x, int n) {
    if (n == 0)
      return 1.0;
    double res;
    int exp = n > 0 ? n : -n;
    if (n == Integer.MIN_VALUE) {
      exp = Integer.MAX_VALUE;
      res = exp % 2 == 0 ? myPow(x * x, exp / 2) * x : myPow(x * x, exp / 2) * x * x;
    } else {
      res = exp % 2 == 0 ? myPow(x * x, exp / 2) : myPow(x * x, exp / 2) * x;
    }
    return n > 0 ? res : 1 / res;
  }
}
