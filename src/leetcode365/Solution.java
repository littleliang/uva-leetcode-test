package leetcode365;

public class Solution {
  public boolean canMeasureWater(int x, int y, int z) {
    if (z > x + y)
      return false;
    return z == 0 ? true : z % gcd(x, y) == 0;
  }

  int gcd(int x, int y) {
    return y == 0 ? x : gcd(y, x % y);
  }
}
