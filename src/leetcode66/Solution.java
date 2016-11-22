package leetcode66;

public class Solution {
  public int[] plusOne(int[] digits) {
    int carry = 1;
    int i = digits.length - 1;

    for (; i >= 0; --i) {
      digits[i] += carry;

      if (digits[i] >= 10) {
        digits[i] -= 10;
      } else {
        break;
      }
    }
    if (i < 0) {
      int[] result = new int[digits.length + 1];
      result[0] = 1;
      System.arraycopy(digits, 0, result, 1, digits.length);
      return result;
    } else {
      return digits;
    }
  }
}
