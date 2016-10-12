package leetcode306;

public class Solution {
  public boolean isAdditiveNumber(String num) {
    int len = num.length();
    if (len <= 1)
      return false;
    for (int i = 1; i <= len / 2; i++) {
      for (int j = 1; Math.max(i, j) <= len - i - j; j++) {
        if (isValid(i, j, num))
          return true;
      }
    }
    return false;
  }

  public boolean isValid(int i, int j, String num) {
    if (num.charAt(i) == '0' && j > 1)
      return false;
    if (num.charAt(0) == '0' && i > 1)
      return false;
    Long x1 = Long.parseLong(num.substring(0, i));
    Long x2 = Long.parseLong(num.substring(i, i + j));
    String sum = "";
    for (int k = i + j; k != num.length(); k += sum.length()) {
      x2 = x2 + x1;
      x1 = x2 - x1;
      sum = x2.toString();
      if (!num.startsWith(sum, k))
        return false;
    }
    return true;
  }
}

