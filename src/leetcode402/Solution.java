package leetcode402;

public class Solution {
  public String removeKdigits(String num, int k) {

    StringBuilder sb = new StringBuilder(num);
    if (k >= sb.length())
      return "0";

    int i = 1;
    while (k > 0 && i < sb.length()) {
      if (i > 0) {
        if (sb.charAt(i) >= sb.charAt(i - 1)) {
          i++;
        } else {
          sb.deleteCharAt(i - 1);
          i--;
          k--;
        }
      } else
        i++;
    }

    if (k > 0)
      sb.delete(sb.length() - k, sb.length());
    return sb.toString().replaceAll("^0+(?!$)", "");
  }
}
