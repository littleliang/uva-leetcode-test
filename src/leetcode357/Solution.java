package leetcode357;

public class Solution {
  public int countNumbersWithUniqueDigits(int n) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return 10;
    }
    int digits = 9;
    int val = 10;
    for (int i = 2; i <= n; i++) {
      digits = digits * (9 - i + 2);
      val = val + digits;
    }
    return val;
  }
}
