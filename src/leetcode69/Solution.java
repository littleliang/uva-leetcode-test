package leetcode69;

public class Solution {
  public int mySqrt(int x) {
    if (x == 0 || x == 1) {
      return x;
    }
    long start = 1;
    long end = x;
    long mid;
    while (start < end - 1) {
      mid = start + (end - start) / 2;
      if (mid * mid == x) {
        return (int) mid;
      } else if (mid * mid < x) {
        start = mid;
      } else {
        end = mid;
      }
    }
    return (int) start;
  }
}
