package leetcode65;

public class Solution {
  public boolean isNumber(String s) {
    if (s.trim().length() == 0)
      return false;
    String regexp = "^(\\+|-)?([0-9]+(\\.[0-9]*)?|\\.[0-9]+)(e(\\+|-)?[0-9]+)?$";
    return s.trim().replaceAll(regexp, "").length() == 0;
  }
}
