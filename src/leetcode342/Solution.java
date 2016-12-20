package leetcode342;

public class Solution {
  public boolean isPowerOfFour(int num) {
    if (num <= 0)
      return false;
    if ((num & (num - 1)) != 0)
      return false;
    if ((num & 0x55555555) != 0)
      return true;
    return false;
  }
}
